package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.Rol;
import lombok.Data;

import java.util.Date;

@Data
public class HistoricoDTO {
    private Integer idHistoricos;
    private RolDTO rol;
    private Boolean activo;
    private Date fechaInicio;
    private Date fechaFin;
}
