package co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.FormatoA;

public interface GestionFormatoAGatewayIntPort {

    boolean existeFormatoAPorId(Integer idFormatoA);

    boolean existeFormatoAPorTitulo(String titulo);

    FormatoA crearFormatoA(FormatoA formatoA);



}
