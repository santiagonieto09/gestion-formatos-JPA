package co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.FormatoDTORespuesta;

import java.util.Date;
import java.util.List;

public interface GestionFormatoACUIntPort {
    FormatoDTORespuesta crearFormatoA(FormatoDTORespuesta formatoDTOPeticion);
    FormatoDTORespuesta listarObservacionesFormatoA(Integer idFormatoA);
    List<FormatoDTORespuesta> consultarFormatosADocente(Integer idDocente);
    List<FormatoDTORespuesta> consultarFormatosADocenteRangoFechas(Integer idDocente, Date fechaInicio, Date fechaFin);
}
