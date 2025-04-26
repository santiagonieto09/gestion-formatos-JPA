package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;

import java.util.List;

@Repository
public interface DocentesRepository extends JpaRepository<DocenteEntity, Integer> {

    List<DocenteEntity> findByNombreGrupoStartingWithIgnoreCaseOrderByApellidosDocenteAsc(String nombreGrupo);

    @Query("SELECT COUNT(d) > 0 FROM DocenteEntity d WHERE LOWER(d.correo) = LOWER(:correo)")
    boolean existeDocenteConCorreo(@Param("correo") String correo);

    @Query("SELECT d FROM DocenteEntity d " +
            "JOIN d.listaHistoricoEntities h " +
            "JOIN h.rolEntity r " +
            "WHERE r.rolAsignado = :rolComite")
    List<DocenteEntity> buscarMiembrosComite(@Param("rolComite") String rolComite);

} 