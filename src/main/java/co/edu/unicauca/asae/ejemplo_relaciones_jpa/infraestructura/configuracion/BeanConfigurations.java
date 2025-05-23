package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.configuracion;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionDocenteGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionFormatoAGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionObservacionGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.casosDeUso.GestionDocenteACUAdapter;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.casosDeUso.GestionFormatoACUAdapter;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.casosDeUso.GestionObservacionCUAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {

    @Bean
    public GestionFormatoACUAdapter crearGestionFormatoACUInt(
        GestionFormatoAGatewayIntPort gestionarFormatoAGatewayIntPort,
        GestionDocenteGatewayIntPort gestionarDocenteGatewayIntPort,
        FormateadorResultadosIntPort formateadorResultadosIntPort) {
        return new GestionFormatoACUAdapter(gestionarFormatoAGatewayIntPort, formateadorResultadosIntPort, gestionarDocenteGatewayIntPort);
    }

    @Bean
    public GestionDocenteACUAdapter crearGestionDocenteCUInt(
        GestionDocenteGatewayIntPort gestionarDocenteGatewayIntPort,
        FormateadorResultadosIntPort formateadorResultadosIntPort) {
        return new GestionDocenteACUAdapter(gestionarDocenteGatewayIntPort, formateadorResultadosIntPort);
    }

    @Bean
    public GestionObservacionCUAdapter crearGestionObservacionCUInt(
        GestionObservacionGatewayIntPort gestionarObservacionGatewayIntPort,
        GestionFormatoAGatewayIntPort gestionarFormatoAGatewayIntPort,
        FormateadorResultadosIntPort formateadorResultadosIntPort) {
        return new GestionObservacionCUAdapter(gestionarObservacionGatewayIntPort, gestionarFormatoAGatewayIntPort, formateadorResultadosIntPort);
    }

}