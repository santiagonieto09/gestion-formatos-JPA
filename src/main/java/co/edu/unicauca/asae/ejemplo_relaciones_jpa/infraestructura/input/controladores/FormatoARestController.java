package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.controladores;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input.GestionFormatoACUIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.FormatoDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.FormatoDTORespuesta;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.ObservacionesDTORespuesta;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.mappers.FormatoAMapperInfDom;
import lombok.AllArgsConstructor;
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
        System.out.println("FormatoA creado: " + formatoACreado);
        System.out.println("FormatoA DTO: " + FormatoAMapperInfDom.INSTANCE.toDTO(formatoACreado));
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

    //TODO: Consultar por docente
    @GetMapping("/docente/{idDocente}")
    public ResponseEntity<List<FormatoDTORespuesta>> consultarFormatosADocente(@RequestParam Integer idDocente) {

        return ResponseEntity.ok().build();
    }

    //TODO: Consultar por docente entre rango de fechas
    @GetMapping("/docente/{idDocente}/rangoFechas/{fechaInicio}/{fechaFin}")
    public ResponseEntity<List<FormatoDTORespuesta>> consultarFormatosADocenteRangoFechas(@PathVariable Integer idDocente,
                                                                                           @PathVariable Date fechaInicio,
                                                                                           @PathVariable Date fechaFin) {
        return ResponseEntity.ok().build();
    }
}
