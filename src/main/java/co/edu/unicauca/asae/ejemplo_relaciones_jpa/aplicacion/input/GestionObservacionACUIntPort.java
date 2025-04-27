package co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.ObservacionesDTORespuesta;
import java.util.List;

public interface GestionObservacionACUIntPort {
    ObservacionesDTORespuesta crearObservacion(ObservacionDTOPeticion observacionDTOPeticion);
    List<ObservacionesDTORespuesta> listarObservaciones(Integer idFormatoA);
}
