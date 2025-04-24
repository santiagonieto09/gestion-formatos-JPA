package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.controladores;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.DocenteDTORespuesta;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/docente")
public class DocenteRestController {
    //TODO: Listar docentes
    @GetMapping
    public ResponseEntity<DocenteDTORespuesta> listarDocentes() {
        return ResponseEntity.ok().build();
    }

    //TODO: Listar miembros del comite
    @GetMapping("/comite")
    public ResponseEntity<DocenteDTORespuesta> listarMiembrosComite() {
        return ResponseEntity.ok().build();
    }
}
