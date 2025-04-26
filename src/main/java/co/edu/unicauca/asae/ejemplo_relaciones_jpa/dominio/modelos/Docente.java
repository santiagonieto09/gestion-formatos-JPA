package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Docente {
    private Integer idDocente;
    private String nombreDocente;
    private String apellidosDocente;
    private String nombreGrupo;
    private String correo;
    private List<Historico> listaHistoricos;
}
