package co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.FormatoA;

import java.util.Date;
import java.util.List;

public interface GestionFormatoAGatewayIntPort {

    boolean existeFormatoAPorId(Integer idFormatoA);

    boolean existeFormatoAPorTitulo(String titulo);

    FormatoA crearFormatoA(FormatoA formatoA);

    List<FormatoA> consultarFormatosADocente(Integer idDocente);

    List<FormatoA> consultarFormatosADocenteRangoFechas(Integer idDocente, Date fechaInicio, Date fechaFin);

    public boolean existeDocenteConCorreo(String correo);

    public Long buscarIdUltimaEvaluacionPorFormato(Long idFormatoA);
}
