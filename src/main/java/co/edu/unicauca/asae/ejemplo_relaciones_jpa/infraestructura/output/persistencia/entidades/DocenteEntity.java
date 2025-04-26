package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Docentes")
public class DocenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocente;
    @Column(name = "nombre_docente", nullable = false, length = 100)
    private String nombreDocente;
    @Column(name = "apellidos_docente", nullable = false, length = 100)
    private String apellidosDocente;
    @Column(name = "nombre_grupo", nullable = true, length = 50)
    private String nombreGrupo;
    @Column(unique = true, nullable = false, length = 100)
    private String correo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "docenteEntity")
    private List<FormatoAEntity> listaFormatosA;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "docenteEntity")
    private List<HistoricoEntity> listaHistoricoEntities;

}
