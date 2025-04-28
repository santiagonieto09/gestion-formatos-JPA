package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.casosDeUso;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input.GestionObservacionACUIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionObservacionGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.ObservacionDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.ObservacionesDTORespuesta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


public class GestionObservacionCUAdapter implements GestionObservacionACUIntPort {
    private final GestionObservacionGatewayIntPort gestionObservacionGatewayIntPort;

    public GestionObservacionCUAdapter(GestionObservacionGatewayIntPort gestionObservacionGatewayIntPort) {
        this.gestionObservacionGatewayIntPort = gestionObservacionGatewayIntPort;
    }

    @Override
    public ObservacionesDTORespuesta crearObservacion(ObservacionDTOPeticion observacionDTOPeticion) {
        return gestionObservacionGatewayIntPort.crearObservacion(observacionDTOPeticion);
    }

    @Override
    public List<ObservacionesDTORespuesta> listarObservaciones(Integer idFormatoA) {
        return gestionObservacionGatewayIntPort.listarObservaciones(idFormatoA);
    }
}
