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

@Entity
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

    @ManyToOne
    @JoinColumn(name = "idDocente", nullable = false)
    private Docente docente;

    @OneToOne(mappedBy = "formatoA")
    private Estado estado;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "formatoA")
    private List<Evaluacion> listaEvaluaciones;

    public Integer getIdFormatoA() {
        return idFormatoA;
    }

    public void setIdFormatoA(Integer idFormatoA) {
        this.idFormatoA = idFormatoA;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public String getObjetivoGeneral() {
        return objetivoGeneral;
    }

    public void setObjetivoGeneral(String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }

    public String getObjetivosEspecificos() {
        return objetivosEspecificos;
    }

    public void setObjetivosEspecificos(String objetivosEspecificos) {
        this.objetivosEspecificos = objetivosEspecificos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
