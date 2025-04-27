package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionObservacionGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.ObservacionesDTORespuesta;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.EvaluacionEntity;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.ObservacionEntity;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.EvaluacionesRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.ObservacionesRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.FormatosARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
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
        // Buscar la ultima evaluacion del formato A
        Long idUltimaEvaluacion = formatosARepository.buscarIdUltimaEvaluacionPorFormato(Long.valueOf(observacionDTOPeticion.getIdFormatoA()));
        if (idUltimaEvaluacion == null) {
            throw new RuntimeException("No se encontró evaluación para el formato A");
        }
        Optional<EvaluacionEntity> evaluacionOpt = evaluacionesRepository.findById(idUltimaEvaluacion.intValue());
        if (!evaluacionOpt.isPresent()) {
            throw new RuntimeException("No se encontró la evaluación asociada");
        }
        EvaluacionEntity evaluacionEntity = evaluacionOpt.get();

        //Crear la observacion
        ObservacionEntity observacionEntity = new ObservacionEntity();
        observacionEntity.setObservacion(observacionDTOPeticion.getObservacion());
        observacionEntity.setFechaRegistro(new Date());
        observacionEntity.setIdsDocentes(observacionDTOPeticion.getIdDocentes());
        observacionEntity.setEvaluacionEntity(evaluacionEntity);

        //Guardar la observacion
        ObservacionEntity saved = observacionesRepository.save(observacionEntity);

        //Retornar respuesta
        ObservacionesDTORespuesta respuesta = new ObservacionesDTORespuesta();
        respuesta.setIdObservacion(saved.getIdObservacion());
        respuesta.setObservacion(saved.getObservacion());
        respuesta.setFechaRegistro(saved.getFechaRegistro());
        respuesta.setIdDocentes(saved.getIdsDocentes());
        respuesta.setIdEvaluacion(saved.getEvaluacionEntity().getIdEvaluacion());
        return respuesta;
    }
}
