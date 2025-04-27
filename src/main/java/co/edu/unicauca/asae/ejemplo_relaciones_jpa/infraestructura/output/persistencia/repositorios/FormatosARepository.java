package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.FormatoAEntity;

import java.util.Date;
import java.util.List;

@Repository
public interface FormatosARepository extends JpaRepository<FormatoAEntity, Integer> {
    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM FormatosA WHERE titulo = :titulo", nativeQuery = true)
    Integer existsByTitulo(@Param("titulo") String titulo);

    @Query("SELECT f FROM FormatoAEntity f " +
            "JOIN f.estadoEntity e " +
            "JOIN f.docenteEntity d " +
            "WHERE f.titulo = :titulo " +
            "AND e.fechaRegistroEstado BETWEEN :fechaInicio AND :fechaFin")
    List<FormatoAEntity> buscarFormatosConEstadoYDocentePorTituloYFechas(@Param("titulo") String titulo,
                                                                         @Param("fechaInicio") Date fechaInicio,
                                                                         @Param("fechaFin") Date fechaFin);

@Query("SELECT f FROM FormatoAEntity f " +
       "JOIN f.docenteEntity d " +
       "JOIN f.estadoEntity e " +
       "WHERE d.idDocente = :idDocente " +
       "AND f.fechaCreacion BETWEEN :fechaInicio AND :fechaFin")
    List<FormatoAEntity> listarFormatosPorDocenteYFechas(
            @Param("idDocente") Integer idDocente,
            @Param("fechaInicio") Date fechaInicio,
            @Param("fechaFin") Date fechaFin);

    @Query(value = "SELECT e.idEvaluacion FROM evaluaciones e " +
            "WHERE e.idFormatoA = :idFormato " +
            "ORDER BY e.fecha_registro_concepto DESC " +
            "LIMIT 1", nativeQuery = true)
    Long buscarIdUltimaEvaluacionPorFormato(@Param("idFormato") Long idFormato);

    @Query("SELECT f FROM FormatoAEntity f " +
       "JOIN f.docenteEntity d " +
       "WHERE d.idDocente = :idDocente")
    List<FormatoAEntity> findByDocenteEntityId(@Param("idDocente") Integer idDocente);

} 