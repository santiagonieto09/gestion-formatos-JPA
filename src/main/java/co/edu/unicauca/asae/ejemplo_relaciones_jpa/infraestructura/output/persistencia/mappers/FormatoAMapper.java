package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.mappers;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.*;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface FormatoAMapper {
    FormatoAMapper INSTANCE = Mappers.getMapper(FormatoAMapper.class);

    default List<String> map(String value) {
        return value != null ? List.of(value.split("\n")) : null;
    }

    default String map(List<String> value) {
        return value != null ? String.join("\n", value) : null;
    }

    Docente toDomain(DocenteEntity docenteEntity);
    DocenteEntity toEntity(Docente docente);

    Evaluacion toDomain(EvaluacionEntity evaluacionEntity);
    EvaluacionEntity toEntity(Evaluacion evaluacion);

    Estado toDomain(EstadoEntity estadoEntity);
    EstadoEntity toEntity(Estado estado);

    // Método base para mapear FormatoEntity
    @SubclassMapping(source = FormatoPPAEntity.class, target = FormatoPPA.class)
    @SubclassMapping(source = FormatoTIAEntity.class, target = FormatoTIA.class)
    FormatoA toDomain(FormatoAEntity entity);

    // Mapeo específico para PP
    @Mapping(source = "docenteEntity", target = "docente")
    @Mapping(source = "estadoEntity", target = "estado")
    FormatoPPA toPPDomain(FormatoPPAEntity entity);

    // Mapeo específico para TI
    @Mapping(source = "docenteEntity", target = "docente")
    @Mapping(source = "estadoEntity", target = "estado")
    FormatoTIA toTIDomain(FormatoTIAEntity entity);

    List<FormatoA> toDomainList(Collection<FormatoAEntity> entities);

    @SubclassMapping(source = FormatoPPA.class, target = FormatoPPAEntity.class)
    @SubclassMapping(source = FormatoTIA.class, target = FormatoTIAEntity.class)
    FormatoAEntity toEntity(FormatoA dto);

    // Mapeo específico para PP
    @Mapping(source = "docente", target = "docenteEntity")
    @Mapping(source = "estado", target = "estadoEntity")
    FormatoPPAEntity toPPEntity(FormatoPPA dto);

    // Mapeo específico para TI
    @Mapping(source = "docente", target = "docenteEntity")
    @Mapping(source = "estado", target = "estadoEntity")
    FormatoTIAEntity toTIEntity(FormatoTIA dto);
}
