package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.mappers;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.*;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.FormatoDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.FormatoPPDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion.FormatoTIDTOPeticion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface FormatoAMapperInfDom {
    FormatoAMapperInfDom INSTANCE = Mappers.getMapper(FormatoAMapperInfDom.class);

    EvaluacionDTORespuesta toEvaluacionDTO(Evaluacion evaluacion);
    List<EvaluacionDTORespuesta> toEvaluacionDTOList(Collection<Evaluacion> evaluaciones);

    // Mapeo de Domain a DTO
    @SubclassMapping(source = FormatoPPA.class, target = FormatoPPDTORespuesta.class)
    @SubclassMapping(source = FormatoTIA.class, target = FormatoTIDTORespuesta.class)
    FormatoDTORespuesta toDTO(FormatoA domain);

    @Mapping(target = "tipo", constant = "PP")
    FormatoPPDTORespuesta toPPDTO(FormatoPPA domain);

    @Mapping(target = "tipo", constant = "TI")
    FormatoTIDTORespuesta toTIDTO(FormatoTIA domain);

    List<FormatoDTORespuesta> toDTOList(Collection<FormatoA> domains);

    // Mapeo de DTO a Entity
    @SubclassMapping(source = FormatoPPDTOPeticion.class, target = FormatoPPA.class)
    @SubclassMapping(source = FormatoTIDTOPeticion.class, target = FormatoTIA.class)
    FormatoA toDomain(FormatoDTOPeticion dto);

    FormatoPPA toPPDomain(FormatoPPDTOPeticion dto);

    FormatoTIA toTIDomain(FormatoTIDTOPeticion dto);
}