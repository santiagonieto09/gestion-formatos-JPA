package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.mappers;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DocenteMapper {
    DocenteMapper INSTANCE = Mappers.getMapper(DocenteMapper.class);

    Docente toDomain(DocenteEntity docenteEntity);
    DocenteEntity toEntity(Docente docente);

    List<Docente> toDomainList(List<DocenteEntity> docenteEntities);

}
