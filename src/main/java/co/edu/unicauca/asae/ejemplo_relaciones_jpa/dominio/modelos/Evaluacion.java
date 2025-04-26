package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos;

import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Evaluacion {
    private Integer idEvaluacion;
    private String concepto;
    private Date fechaRegistroConcepto;
    private String nombreCoordinador;
    private List<Observacion> listaObservaciones;
}
