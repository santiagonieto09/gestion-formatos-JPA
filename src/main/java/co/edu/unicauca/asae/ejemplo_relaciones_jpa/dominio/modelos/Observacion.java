package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos;

import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Observacion {
    private Integer idObservacion;
    private String observacion;
    private Date fechaRegistro;
    private List<Integer> idsDocentes;
}
