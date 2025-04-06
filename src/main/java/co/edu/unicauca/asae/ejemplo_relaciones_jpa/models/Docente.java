package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Docentes")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocente;
    @Column(name = "nombre_docente", nullable = false, length = 100)
    private String nombreDocente;
    @Column(name = "apellidos_docente", nullable = false, length = 100)
    private String apellidosDocente;
    @Column(name = "nombre_grupo", nullable = false, length = 50)
    private String nombreGrupo;
    @Column(unique = true, nullable = false, length = 100)
    private String correo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "docente")
    private List<FormatoA> listaFormatosA; 

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "docente")
    private List<Historico> listaHistoricos;     

}
