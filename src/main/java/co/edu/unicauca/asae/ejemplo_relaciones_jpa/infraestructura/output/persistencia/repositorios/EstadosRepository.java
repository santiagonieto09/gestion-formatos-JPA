package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosRepository extends JpaRepository<EstadoEntity, Integer> {
    
} 