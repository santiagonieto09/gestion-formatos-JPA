package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class ObservacionDTO {
    private Integer idObservacion;
    private String observacion;
    private Date fechaRegistro;
    private List<Integer> idsDocentes;
}