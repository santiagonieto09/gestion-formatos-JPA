package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.mappers;


import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.Historico;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.HistoricoDTO;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DocenteMapperInfDom {
    DocenteMapperInfDom INSTANCE = Mappers.getMapper(DocenteMapperInfDom.class);

    DocenteDTORespuesta toDTO(Docente docente);

    List<DocenteDTORespuesta> toDocenteDTOList(List<Docente> docentes);

    HistoricoDTO toHistoricoDTO(Historico historico);
}

