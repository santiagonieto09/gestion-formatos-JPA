package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.Observacion;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EvaluacionDTORespuesta {
    private Integer idEvaluacion;
    private String concepto;
    private Date fechaRegistroConcepto;
    private String nombreCoordinador;
    //private List<Observacion> listaObservaciones;
}
