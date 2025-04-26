package co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output;

public interface FormateadorResultadosIntPort {
    void retornarRespuestaErrorEntidadExiste(String mensaje);

    void retornarRespuestaErrorReglaDeNegocio(String mensaje);

    void retornarRespuestaErrorEntidadNoExiste(String mensaje);
}
