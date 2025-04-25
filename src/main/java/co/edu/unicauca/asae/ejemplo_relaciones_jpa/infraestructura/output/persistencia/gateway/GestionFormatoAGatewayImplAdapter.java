package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionFormatoAGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.FormatosARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GestionFormatoAGatewayImplAdapter implements GestionFormatoAGatewayIntPort {
    private final FormatosARepository formatoARepository;

}
