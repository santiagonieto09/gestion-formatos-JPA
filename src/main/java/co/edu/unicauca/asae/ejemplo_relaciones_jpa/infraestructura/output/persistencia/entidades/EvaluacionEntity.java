package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "Evaluaciones")
public class EvaluacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvaluacion;
    @Column(nullable = false, length = 255)
    private String concepto;
    @Column(name = "fecha_registro_concepto", nullable = false)
    private Date fechaRegistroConcepto;
    @Column(name = "nombre_coordinador", nullable = false, length = 100)
    private String nombreCoordinador;

    @ManyToOne
    @JoinColumn(name = "idFormatoA", nullable = false)
    private FormatoAEntity formatoAEntity;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evaluacion")
    private List<ObservacionEntity> listaObservaciones;
    
}
