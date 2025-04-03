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
@Table(name = "Roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    @Column(name= "rol_asignado",nullable = false, length = 100)
    private String rolAsignado;

     @OneToMany(fetch = FetchType.EAGER, mappedBy = "rol")
    private List<Historico> listaHistoricos;

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getRolAsignado() {
        return rolAsignado;
    }

    public void setRolAsignado(String rolAsignado) {
        this.rolAsignado = rolAsignado;
    }

    public List<Historico> getListaHistoricos() {
        return listaHistoricos;
    }

    public void setListaHistoricos(List<Historico> listaHistoricos) {
        this.listaHistoricos = listaHistoricos;
    }
  
    

}
