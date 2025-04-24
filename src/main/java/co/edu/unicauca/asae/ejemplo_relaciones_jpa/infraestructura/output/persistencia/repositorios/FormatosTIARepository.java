package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.FormatoTIAEntity;

@Repository
public interface FormatosTIARepository extends JpaRepository<FormatoTIAEntity, Integer> {
    
} 