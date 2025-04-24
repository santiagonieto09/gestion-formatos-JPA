package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Historicos")
public class HistoricoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistoricos;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDocente", nullable = false)
    private DocenteEntity docenteEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRol", nullable = false)
    private RolEntity rolEntity;

    @Column(nullable = false)
    private Boolean activo;

    @Column(nullable = false)
    private Date fechaInicio;
    @Column(nullable = true)
    private Date fechaFin;

}
