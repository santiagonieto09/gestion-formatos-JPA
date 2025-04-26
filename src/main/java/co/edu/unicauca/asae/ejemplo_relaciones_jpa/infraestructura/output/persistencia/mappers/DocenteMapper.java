package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.mappers;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.Historico;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.HistoricoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DocenteMapper {
    DocenteMapper INSTANCE = Mappers.getMapper(DocenteMapper.class);

    @Mapping(target = "listaHistoricos", source = "listaHistoricoEntities")
    Docente toDomain(DocenteEntity docenteEntity);
    DocenteEntity toEntity(Docente docente);

    List<Docente> toDomainList(List<DocenteEntity> docenteEntities);

    @Mapping(target = "rol", source = "rolEntity")
    Historico toDomain(HistoricoEntity historicoEntity);
}
