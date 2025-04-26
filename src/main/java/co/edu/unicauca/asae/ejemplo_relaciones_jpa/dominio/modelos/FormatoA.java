package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FormatoA {
    private Integer idFormatoA;
    private String objetivoGeneral;
    private List<String> objetivosEspecificos;
    private String titulo;
    private Docente docente;
    private Estado estado;
    private List<Evaluacion> listaEvaluaciones;

    public void inicializarFormato(){
        estado = new Estado();
        estado.setEstadoActual("EN_FORMULACION");
        estado.setFechaRegistroEstado(new java.util.Date());
    }
}
