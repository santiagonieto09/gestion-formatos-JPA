package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.controladores;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input.GestionDocenteACUIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input.GestionFormatoACUIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.mappers.DocenteMapperInfDom;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.mappers.FormatoAMapperInfDom;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/docente")
public class DocenteRestController {

    private final GestionDocenteACUIntPort gestionDocenteACUIntPort;

    @GetMapping
    public ResponseEntity<List<DocenteDTORespuesta>> listarDocentes(@RequestParam(required = false, defaultValue = "") String prefijoGrupo) {
        List<Docente> docentes = gestionDocenteACUIntPort.listarDocentes(prefijoGrupo);
        return new ResponseEntity<>(
                DocenteMapperInfDom.INSTANCE.toDocenteDTOList(docentes),
                HttpStatus.OK
        );
    }

    @GetMapping("/comite")
    public ResponseEntity<List<DocenteDTORespuesta>> listarMiembrosComite() {
        List<Docente> docentes = gestionDocenteACUIntPort.listarMiembrosComite();
        return new ResponseEntity<>(
                DocenteMapperInfDom.INSTANCE.toDocenteDTOList(docentes),
                HttpStatus.OK
        );
    }
}
