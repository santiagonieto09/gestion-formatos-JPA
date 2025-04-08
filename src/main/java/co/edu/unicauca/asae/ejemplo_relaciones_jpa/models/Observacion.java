package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
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
@Table(name = "Observaciones")
public class Observacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idObservacion;
    @Column(nullable = false)
    private String observacion;
    @Column(name = "fecha_registro_observacion", nullable = false)
    private Date fechaRegistro;
    
    @ElementCollection
    @CollectionTable(name = "observacion_docentes", 
        joinColumns = @JoinColumn(name = "idObservacion"))
    @Column(name = "idDocente")
    private List<Integer> idsDocentes;

    @ManyToOne
    @JoinColumn(name = "idEvaluacion", nullable = false)
    private Evaluacion evaluacion;

}
