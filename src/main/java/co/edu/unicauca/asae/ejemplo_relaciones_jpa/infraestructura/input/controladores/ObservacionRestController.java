package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.controladores;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.ObservacionDTOPeticion;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/observacion")
public class ObservacionRestController {
    //TODO: Crear observacion
    @PostMapping
    public ResponseEntity<?> crearObservacion(@RequestBody ObservacionDTOPeticion observacionDTOPeticion) {
        return ResponseEntity.ok().build();
    }
}
