package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;
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
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "FormatosA")
public class FormatoA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFormatoA;
    @Column(name = "nombre_director", nullable = false, length = 100)
    private String nombreDirector;
    @Column(name = "objetivo_general", nullable = false)
    private String objetivoGeneral;
    @Column(name = "objetivos_especificos", nullable = false)
    private String objetivosEspecificos;
    @Column(unique = true)
    private String titulo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idDocente", nullable = false)
    private Docente docente;

    @OneToOne(mappedBy = "formatoA", cascade = CascadeType.PERSIST)
    private Estado estado;

    @OneToMany(mappedBy = "formatoA", fetch = FetchType.EAGER)
    private List<Evaluacion> listaEvaluaciones;

}
