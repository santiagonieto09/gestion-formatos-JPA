package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.casosDeUso;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input.GestionObservacionACUIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionFormatoAGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionObservacionGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.ObservacionesDTORespuesta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


public class GestionObservacionCUAdapter implements GestionObservacionACUIntPort {
    private final GestionObservacionGatewayIntPort gestionObservacionGatewayIntPort;
    private final GestionFormatoAGatewayIntPort gestionFormatoAGatewayIntPort;
    private final FormateadorResultadosIntPort formateadorResultadosIntPort;

    public GestionObservacionCUAdapter(GestionObservacionGatewayIntPort gestionObservacionGatewayIntPort, GestionFormatoAGatewayIntPort gestionFormatoAGatewayIntPort, FormateadorResultadosIntPort formateadorResultadosIntPort) {
        this.gestionObservacionGatewayIntPort = gestionObservacionGatewayIntPort;
        this.gestionFormatoAGatewayIntPort = gestionFormatoAGatewayIntPort;
        this.formateadorResultadosIntPort = formateadorResultadosIntPort;
    }

    @Override
    public ObservacionesDTORespuesta crearObservacion(ObservacionDTOPeticion observacionDTOPeticion) {
        Long idUltimaEvaluacion;
        if (!gestionFormatoAGatewayIntPort.existeFormatoAPorId(observacionDTOPeticion.getIdFormatoA())) {
            formateadorResultadosIntPort.retornarRespuestaErrorEntidadNoExiste("El formato A no existe.");
        }

        idUltimaEvaluacion = gestionFormatoAGatewayIntPort.buscarIdUltimaEvaluacionPorFormato(Long.valueOf(observacionDTOPeticion.getIdFormatoA()));
        if (idUltimaEvaluacion == null) {
            formateadorResultadosIntPort.retornarRespuestaErrorReglaDeNegocio("No se encontró ninguna evaluación para el formato A.");
        }


        return gestionObservacionGatewayIntPort.crearObservacion(observacionDTOPeticion, idUltimaEvaluacion);
    }

    @Override
    public List<ObservacionesDTORespuesta> listarObservaciones(Integer idFormatoA) {
        if (!gestionFormatoAGatewayIntPort.existeFormatoAPorId(idFormatoA)) {
            formateadorResultadosIntPort.retornarRespuestaErrorEntidadNoExiste("El formato A no existe.");
        }
        return gestionObservacionGatewayIntPort.listarObservaciones(idFormatoA);
    }
}
