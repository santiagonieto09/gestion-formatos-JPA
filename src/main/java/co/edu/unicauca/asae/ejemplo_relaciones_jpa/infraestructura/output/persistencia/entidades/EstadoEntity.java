package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Estados")
public class EstadoEntity {

    @Id
    private Integer idEstado;
    @Column(name = "estado_actual", nullable = false, length = 50)
    private String estadoActual;
    @Column(name = "fecha_registro_estado", nullable = false)
    private Date fechaRegistroEstado;
    @OneToOne
    @MapsId
    @JoinColumn(name = "idFormatoA", nullable = false)
    private FormatoAEntity formatoAEntity;
}
