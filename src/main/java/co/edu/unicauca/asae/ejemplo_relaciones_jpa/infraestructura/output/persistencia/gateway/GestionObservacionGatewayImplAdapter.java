package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionObservacionGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.ObservacionesDTORespuesta;
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
    public ObservacionesDTORespuesta crearObservacion(ObservacionDTOPeticion observacionDTOPeticion) {
        Long idUltimaEvaluacion = formatosARepository
                .buscarIdUltimaEvaluacionPorFormato(Long.valueOf(observacionDTOPeticion.getIdFormatoA()));
        if (idUltimaEvaluacion == null) {
            throw new RuntimeException("No se encontro evaluacion para el formato A");
        }
        Optional<EvaluacionEntity> evaluacionOpt = evaluacionesRepository.findById(idUltimaEvaluacion.intValue());
        if (!evaluacionOpt.isPresent()) {
            throw new RuntimeException("No se encontro la evaluacion asociada");
        }
        EvaluacionEntity evaluacionEntity = evaluacionOpt.get();

        ObservacionEntity observacionEntity = new ObservacionEntity();
        observacionEntity.setObservacion(observacionDTOPeticion.getObservacion());
        observacionEntity.setFechaRegistro(new Date());
        observacionEntity.setIdsDocentes(observacionDTOPeticion.getIdDocentes());
        observacionEntity.setEvaluacionEntity(evaluacionEntity);

        ObservacionEntity saved = observacionesRepository.save(observacionEntity);

        ObservacionesDTORespuesta respuesta = new ObservacionesDTORespuesta();
        respuesta.setIdObservacion(saved.getIdObservacion());
        respuesta.setObservacion(saved.getObservacion());
        respuesta.setFechaRegistro(saved.getFechaRegistro());
        respuesta.setIdDocentes(saved.getIdsDocentes());
        respuesta.setIdEvaluacion(saved.getEvaluacionEntity().getIdEvaluacion());
        return respuesta;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ObservacionesDTORespuesta> listarObservaciones(Integer idFormatoA) {
        FormatoAEntity formato = formatosARepository.findById(idFormatoA)
                .orElseThrow(() -> new RuntimeException("Formato A no existe"));

        List<ObservacionesDTORespuesta> resultado = new ArrayList<>();

        for (EvaluacionEntity ev : formato.getListaEvaluaciones()) {
            for (ObservacionEntity obs : ev.getListaObservaciones()) {

                ObservacionesDTORespuesta dto = new ObservacionesDTORespuesta();

                // Agregar informacion Formato A
                dto.setIdFormatoA(formato.getIdFormatoA());
                dto.setTituloFormatoA(formato.getTitulo());
                dto.setEstadoFormatoA(formato.getEstadoEntity().getEstadoActual());

                // Agregar informacion Evaluacion
                dto.setConceptoEvaluacion(ev.getConcepto());
                dto.setFechaRegistroConcepto(ev.getFechaRegistroConcepto());
                dto.setNombreCoordinador(ev.getNombreCoordinador());

                //Agregar informacion de Observaciones
                dto.setIdObservacion(obs.getIdObservacion());
                dto.setObservacion(obs.getObservacion());
                dto.setFechaRegistro(obs.getFechaRegistro());
                dto.setIdsDocentes(obs.getIdsDocentes());
                dto.setIdEvaluacion(ev.getIdEvaluacion());                

                resultado.add(dto);
            }
        }
        return resultado;
    }
}
