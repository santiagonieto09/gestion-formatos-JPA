package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Historicos")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistoricos;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDocente", nullable = false)
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;

    @Column(nullable = false)
    private Boolean activo;

    @Column(nullable = false)
    private Date fechaInicio;
    @Column(nullable = true)
    private Date fechaFin;

}
