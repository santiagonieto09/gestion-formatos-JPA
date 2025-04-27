package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.controladores;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.ObservacionDTOPeticion;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping("/api/observacion")
public class ObservacionRestController {
    private final co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input.GestionObservacionACUIntPort gestionObservacionACUIntPort;

    @PostMapping
    public ResponseEntity<?> crearObservacion(@Valid @RequestBody ObservacionDTOPeticion observacionDTOPeticion) {
        var respuesta = gestionObservacionACUIntPort.crearObservacion(observacionDTOPeticion);
        return ResponseEntity.ok(respuesta);
    }
}
