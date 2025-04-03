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

@Entity
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

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getApellidosDocente() {
        return apellidosDocente;
    }

    public void setApellidosDocente(String apellidosDocente) {
        this.apellidosDocente = apellidosDocente;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<FormatoA> getListaFormatosA() {
        return listaFormatosA;
    }

    public void setListaFormatosA(List<FormatoA> listaFormatosA) {
        this.listaFormatosA = listaFormatosA;
    }

    public List<Historico> getListaHistoricos() {
        return listaHistoricos;
    }

    public void setListaHistoricos(List<Historico> listaHistoricos) {
        this.listaHistoricos = listaHistoricos;
    }

    

}
