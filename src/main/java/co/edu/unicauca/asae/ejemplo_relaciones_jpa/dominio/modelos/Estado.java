package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos;

import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Estado {
    private Integer idEstado;
    private String estadoActual;
    private Date fechaRegistroEstado;
}
