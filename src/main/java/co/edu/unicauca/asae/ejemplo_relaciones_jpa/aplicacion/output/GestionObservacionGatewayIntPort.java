package co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.ObservacionesDTORespuesta;

public interface GestionObservacionGatewayIntPort {
    ObservacionesDTORespuesta crearObservacion(ObservacionDTOPeticion observacionDTOPeticion);
}
