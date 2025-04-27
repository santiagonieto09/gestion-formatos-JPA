package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.ObservacionEntity;

@Repository
public interface ObservacionesRepository extends JpaRepository<ObservacionEntity, Integer> {
    // Listar observaciones por id de evaluación
    List<ObservacionEntity> findByEvaluacionEntity_IdEvaluacion(Integer idEvaluacion);
}