package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.HistoricoEntity;

@Repository
public interface HistoricosRepository extends JpaRepository<HistoricoEntity, Integer> {
    
}