package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.formateador;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;

public class FormateadorResultadosImplAdapter implements FormateadorResultadosIntPort {

    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        ReglaNegocioExcepcion objException = new ReglaNegocioExcepcion(mensaje);
        throw objException;
    }
}
