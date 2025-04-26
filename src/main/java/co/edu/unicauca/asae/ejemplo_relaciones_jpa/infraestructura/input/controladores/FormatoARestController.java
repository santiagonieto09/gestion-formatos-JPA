package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.controladores;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input.GestionFormatoACUIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.FormatoDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.FormatoDTORespuesta;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.ObservacionesDTORespuesta;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.mappers.FormatoAMapperInfDom;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/formatoA")
public class FormatoARestController {

    private final GestionFormatoACUIntPort objGestionFormatoACUIntPort;

    @PostMapping
    public ResponseEntity<FormatoDTORespuesta> crearFormatoA(@RequestBody FormatoDTOPeticion formatoDTOPeticion) {
        FormatoA formatoACrear = FormatoAMapperInfDom.INSTANCE.toDomain(formatoDTOPeticion);
        FormatoA formatoACreado = objGestionFormatoACUIntPort.crearFormatoA(formatoACrear);
        return new ResponseEntity<>(
                FormatoAMapperInfDom.INSTANCE.toDTO(formatoACreado),
                HttpStatus.CREATED
        );
    }

    //TODO: Listar observaciones de un formatoA. se necesita devolver la info del formato A
    @GetMapping("/{idFormatoA}/observaciones")
    public ResponseEntity<ObservacionesDTORespuesta> listarObservacionesFormatoA(@RequestParam Integer idFormatoA) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/docente/{idDocente}")
    public ResponseEntity<List<FormatoDTORespuesta>> consultarFormatosADocente(@PathVariable Integer idDocente) {
        List<FormatoA> formatosADocente = objGestionFormatoACUIntPort.consultarFormatosADocente(idDocente);
        return new ResponseEntity<>(
                FormatoAMapperInfDom.INSTANCE.toDTOList(formatosADocente),
                HttpStatus.OK
        );
    }

    @GetMapping("/docente/{idDocente}/rangoFechas")
    public ResponseEntity<List<FormatoDTORespuesta>> consultarFormatosADocenteRangoFechas(@PathVariable Integer idDocente,
                                                                                           @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date fechaInicio,
                                                                                           @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date fechaFin) {
        List<FormatoA> formatosADocente = objGestionFormatoACUIntPort.consultarFormatosADocenteRangoFechas(idDocente, fechaInicio, fechaFin);
        return new ResponseEntity<>(
                FormatoAMapperInfDom.INSTANCE.toDTOList(formatosADocente),
                HttpStatus.OK
        );
    }
}
