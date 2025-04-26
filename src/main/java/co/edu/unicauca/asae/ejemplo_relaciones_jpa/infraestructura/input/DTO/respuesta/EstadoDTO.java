package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta;

import lombok.Data;

import java.util.Date;

@Data
public class EstadoDTO {
    private Integer idEstado;
    private String estadoActual;
    private Date fechaRegistroEstado;
}
