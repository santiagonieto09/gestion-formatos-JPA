package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionDocenteGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.mappers.DocenteMapper;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.DocentesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GestionDocenteGatewayImplAdapter implements GestionDocenteGatewayIntPort {
    private final DocentesRepository docenteRepository;

    @Override
    public boolean existeDocentePorId(Integer idDocente) {
        return docenteRepository.existsById(idDocente);
    }

    @Override
    public List<Docente> listarDocentes(String prefijoGrupo) {
        // Hacer mapper de DocenteEntity a Docente
        return DocenteMapper.INSTANCE.toDomainList(docenteRepository.findByNombreGrupoStartingWithIgnoreCaseOrderByApellidosDocenteAsc(prefijoGrupo));
    }

    @Override
    public List<Docente> listarMiembrosComite() {
        return List.of();
    }
}
