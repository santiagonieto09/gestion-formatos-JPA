package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.configuracion;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionFormatoAGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.casosDeUso.GestionFormatoACUAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {

    @Bean
    public GestionFormatoACUAdapter crearGestionFormatoACUInt(
        GestionFormatoAGatewayIntPort gestionarFormatoAGatewayIntPort,
        FormateadorResultadosIntPort formateadorResultadosIntPort) {
        return new GestionFormatoACUAdapter(gestionarFormatoAGatewayIntPort, formateadorResultadosIntPort);
    }
}