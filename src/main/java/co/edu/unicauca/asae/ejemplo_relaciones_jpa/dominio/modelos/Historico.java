package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Historico {
    private Integer idHistoricos;
    private Docente docente;
    private Rol rol;
    private Boolean activo;
    private Date fechaInicio;
    private Date fechaFin;
}
