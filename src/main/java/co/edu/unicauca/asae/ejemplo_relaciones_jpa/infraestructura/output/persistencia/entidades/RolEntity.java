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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Roles")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    @Column(name= "rol_asignado",nullable = false, length = 100)
    private String rolAsignado;

     @OneToMany(fetch = FetchType.EAGER, mappedBy = "rolEntity")
    private List<HistoricoEntity> listaHistoricoEntities;

}
