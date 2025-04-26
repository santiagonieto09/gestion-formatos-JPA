package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta;

import lombok.Data;

import java.util.List;

@Data
public class DocenteDTORespuesta {
    private Integer idDocente;
    private String nombreDocente;
    private String apellidosDocente;
    private String nombreGrupo;
    private String correo;
    private List<HistoricoDTO> listaHistoricos;
}
