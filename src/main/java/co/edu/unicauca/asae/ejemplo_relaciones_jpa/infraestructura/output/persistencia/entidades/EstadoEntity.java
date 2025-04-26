package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstado;
    @Column(name = "estado_actual", nullable = false, length = 50)
    private String estadoActual;
    @Column(name = "fecha_registro_estado", nullable = false)
    private Date fechaRegistroEstado;
    @OneToOne
    @JoinColumn(name = "idFormatoA", nullable = false)
    private FormatoAEntity formatoAEntity;
}
