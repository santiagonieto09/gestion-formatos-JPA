package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "FormatosA")
public class FormatoAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFormatoA;
    @Column(name = "objetivo_general", nullable = false)
    private String objetivoGeneral;
    @Column(name = "objetivos_especificos", nullable = false)
    private String objetivosEspecificos;
    @Column(unique = true, nullable = false)
    private String titulo;

    @CreationTimestamp
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private Date fechaCreacion;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "idDocente", nullable = false)
    private DocenteEntity docenteEntity;

    @OneToOne(mappedBy = "formatoAEntity", cascade = CascadeType.PERSIST)
    private EstadoEntity estadoEntity;

    @OneToMany(mappedBy = "formatoAEntity", fetch = FetchType.EAGER)
    private List<EvaluacionEntity> listaEvaluaciones;

}
