package co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Historico;

@Repository
public interface HistoricosRepository extends JpaRepository<Historico, Integer> {
    
}