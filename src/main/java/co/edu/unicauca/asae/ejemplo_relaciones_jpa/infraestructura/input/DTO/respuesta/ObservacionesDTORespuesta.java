package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ObservacionesDTORespuesta {
    private Integer idObservacion;
    private String observacion;
    private Date fechaRegistro;
    private List<Integer> idsDocentes;
    private Integer idEvaluacion;
  
    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }
    public void setIdDocentes(List<Integer> idsDocentes) {
        this.idsDocentes = idsDocentes;
    }
}
