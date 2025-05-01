package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.controladores;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input.GestionFormatoACUIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input.GestionObservacionACUIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.FormatoDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.FormatoDTORespuesta;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.ObservacionesDTORespuesta;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.mappers.FormatoAMapperInfDom;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping("/api/formatoA")
public class FormatoARestController {

    private final GestionFormatoACUIntPort objGestionFormatoACUIntPort;
    private final GestionObservacionACUIntPort gestionObservacionACUIntPort;

    @PostMapping
    public ResponseEntity<FormatoDTORespuesta> crearFormatoA(@Valid @RequestBody FormatoDTOPeticion formatoDTOPeticion) {
        FormatoA formatoACrear = FormatoAMapperInfDom.INSTANCE.toDomain(formatoDTOPeticion);
        FormatoA formatoACreado = objGestionFormatoACUIntPort.crearFormatoA(formatoACrear);
        return new ResponseEntity<>(
                FormatoAMapperInfDom.INSTANCE.toDTO(formatoACreado),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{idFormatoA}/observaciones")
    public ResponseEntity<List<ObservacionesDTORespuesta>> listarObservacionesFormatoA(
        @PathVariable("idFormatoA")
        @NotNull(message = "idFormatoA no puede ser null")
        @Min(value = 1, message = "idFormatoA debe ser >= 1") Integer idFormatoA) {
        List<ObservacionesDTORespuesta> lista = gestionObservacionACUIntPort.listarObservaciones(idFormatoA);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/docente/{idDocente}")
public ResponseEntity<List<FormatoDTORespuesta>> consultarFormatosADocente(
    @PathVariable
    @Min(value = 1, message = "{docente.idDocente.invalid}") Integer idDocente) {
    List<FormatoA> formatosADocente = objGestionFormatoACUIntPort.consultarFormatosADocente(idDocente);
    return new ResponseEntity<>(
            FormatoAMapperInfDom.INSTANCE.toDTOList(formatosADocente),
            HttpStatus.OK
    );
}

   @GetMapping("/docente/{idDocente}/rangoFechas")
public ResponseEntity<List<FormatoDTORespuesta>> consultarFormatosADocenteRangoFechas(
    @PathVariable
    @Min(value = 1, message = "{docente.idDocente.invalid}") Integer idDocente,
    @RequestParam
    @DateTimeFormat(pattern = "dd-MM-yyyy") Date fechaInicio,
    @RequestParam
    @DateTimeFormat(pattern = "dd-MM-yyyy") Date fechaFin) {

    List<FormatoA> formatosADocente = objGestionFormatoACUIntPort.consultarFormatosADocenteRangoFechas(idDocente, fechaInicio, fechaFin);
    return new ResponseEntity<>(
            FormatoAMapperInfDom.INSTANCE.toDTOList(formatosADocente),
            HttpStatus.OK
    );
}
}
