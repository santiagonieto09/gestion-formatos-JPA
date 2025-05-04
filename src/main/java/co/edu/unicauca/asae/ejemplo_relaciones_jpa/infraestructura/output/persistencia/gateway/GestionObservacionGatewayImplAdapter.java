package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionObservacionGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.ObservacionesDTORespuesta;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.ObservacionDTO;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.ObservacionEntity;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.FormatoAEntity;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.EvaluacionesRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.ObservacionesRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.FormatosARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GestionObservacionGatewayImplAdapter implements GestionObservacionGatewayIntPort {
    private final ObservacionesRepository observacionesRepository;
    private final FormatosARepository formatosARepository;
    private final EvaluacionesRepository evaluacionesRepository;

    @Override
    @Transactional
    public ObservacionesDTORespuesta crearObservacion(ObservacionDTOPeticion observacionDTOPeticion, Long idUltimaEvaluacion) {
        Optional<EvaluacionEntity> evaluacionOpt = evaluacionesRepository.findById(idUltimaEvaluacion.intValue());

        if (evaluacionOpt.isEmpty()) {
            throw new RuntimeException("No se encontro la evaluacion asociada");
        }

        EvaluacionEntity evaluacionEntity = evaluacionOpt.get();

        ObservacionEntity observacionEntity = new ObservacionEntity();
        observacionEntity.setObservacion(observacionDTOPeticion.getObservacion());
        observacionEntity.setFechaRegistro(new Date());
        observacionEntity.setIdsDocentes(observacionDTOPeticion.getIdDocentes());
        observacionEntity.setEvaluacionEntity(evaluacionEntity);

        ObservacionEntity saved = observacionesRepository.save(observacionEntity);

        // Crea el DTO de respuesta
        ObservacionesDTORespuesta respuesta = new ObservacionesDTORespuesta();
        
        // Agrega informacion de evaluacion
        respuesta.setIdEvaluacion(saved.getEvaluacionEntity().getIdEvaluacion());
        
        // Crea y agrega el DTO de observacion
        ObservacionDTO obsDTO = new ObservacionDTO();
        obsDTO.setIdObservacion(saved.getIdObservacion());
        obsDTO.setObservacion(saved.getObservacion());
        obsDTO.setFechaRegistro(saved.getFechaRegistro());
        obsDTO.setIdsDocentes(saved.getIdsDocentes());
        
        // Agrega la observacion a la lista
        List<ObservacionDTO> observaciones = new ArrayList<>();
        observaciones.add(obsDTO);
        respuesta.setObservaciones(observaciones);
        
        return respuesta;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ObservacionesDTORespuesta> listarObservaciones(Integer idFormatoA) {

        System.out.println("Listando observaciones para el formato A con ID: " + idFormatoA);
        FormatoAEntity formato = formatosARepository.findById(idFormatoA).get();
        System.out.println("Formato A con ID " + idFormatoA + " encontrado.");

        List<ObservacionesDTORespuesta> resultado = new ArrayList<>();

        for (EvaluacionEntity ev : formato.getListaEvaluaciones()) {
            // Crea un solo DTO para cada evaluacion
            ObservacionesDTORespuesta dto = new ObservacionesDTORespuesta();
            
            // Agrega informacion del formato A
            dto.setIdFormatoA(formato.getIdFormatoA());
            dto.setTituloFormatoA(formato.getTitulo());
            dto.setEstadoFormatoA(formato.getEstadoEntity().getEstadoActual());

            // Agrega informacion de la evaluacion
            dto.setIdEvaluacion(ev.getIdEvaluacion());
            dto.setConceptoEvaluacion(ev.getConcepto());
            dto.setFechaRegistroConcepto(ev.getFechaRegistroConcepto());
            dto.setNombreCoordinador(ev.getNombreCoordinador());

            // Crea lista de observaciones
            List<ObservacionDTO> observaciones = new ArrayList<>();
            for (ObservacionEntity obs : ev.getListaObservaciones()) {
                ObservacionDTO obsDTO = new ObservacionDTO();
                obsDTO.setIdObservacion(obs.getIdObservacion());
                obsDTO.setObservacion(obs.getObservacion());
                obsDTO.setFechaRegistro(obs.getFechaRegistro());
                obsDTO.setIdsDocentes(obs.getIdsDocentes());
                observaciones.add(obsDTO);
            }
            dto.setObservaciones(observaciones);
            
            resultado.add(dto);
        }
        System.out.println("Se encontraron " + resultado.size() + " observaciones para el formato A con ID: " + idFormatoA);
        return resultado;
    }
}
