package co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input;



import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.FormatoA;

import java.util.Date;
import java.util.List;

public interface GestionFormatoACUIntPort {
    FormatoA crearFormatoA(FormatoA formatoA);
    FormatoA listarObservacionesFormatoA(Integer idFormatoA);
    List<FormatoA> consultarFormatosADocente(Integer idDocente);
    List<FormatoA> consultarFormatosADocenteRangoFechas(Integer idDocente, Date fechaInicio, Date fechaFin);
}
