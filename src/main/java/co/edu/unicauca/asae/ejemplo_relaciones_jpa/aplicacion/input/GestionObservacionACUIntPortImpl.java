package co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionObservacionGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.ObservacionesDTORespuesta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GestionObservacionACUIntPortImpl implements GestionObservacionACUIntPort {
    private final GestionObservacionGatewayIntPort gestionObservacionGatewayIntPort;

    @Override
    public ObservacionesDTORespuesta crearObservacion(ObservacionDTOPeticion observacionDTOPeticion) {
        return gestionObservacionGatewayIntPort.crearObservacion(observacionDTOPeticion);
    }
}
