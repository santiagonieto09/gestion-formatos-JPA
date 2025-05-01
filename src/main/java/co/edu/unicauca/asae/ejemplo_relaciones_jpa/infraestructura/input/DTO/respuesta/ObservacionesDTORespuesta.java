package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ObservacionesDTORespuesta {
    // Datos del Formato A
    private Integer idFormatoA;
    private String tituloFormatoA;
    
    // Estado del Formato
    private String estadoFormatoA;
    
    // Datos de la Evaluacion
    private Integer idEvaluacion;
    private String conceptoEvaluacion;
    private Date fechaRegistroConcepto;
    private String nombreCoordinador;
    
    // Datos de la Observacion
    private Integer idObservacion;
    private String observacion;
    private Date fechaRegistro;
    
    // Datos de los Docentes asociados 
    private List<Integer> idsDocentes;
  
    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }
    public void setIdDocentes(List<Integer> idsDocentes) {
        this.idsDocentes = idsDocentes;
    }
}
