package co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.ObservacionesDTORespuesta;
import java.util.List;

public interface GestionObservacionGatewayIntPort {
    ObservacionesDTORespuesta crearObservacion(ObservacionDTOPeticion observacionDTOPeticion,  Long idUltimaEvaluacion);
    List<ObservacionesDTORespuesta> listarObservaciones(Integer idFormatoA);
}
