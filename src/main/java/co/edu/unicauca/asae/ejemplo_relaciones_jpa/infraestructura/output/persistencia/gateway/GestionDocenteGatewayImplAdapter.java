package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionDocenteGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.mappers.DocenteMapper;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.DocentesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class GestionDocenteGatewayImplAdapter implements GestionDocenteGatewayIntPort {
    private final DocentesRepository docenteRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean existeDocentePorId(Integer idDocente) {
        return docenteRepository.existsById(idDocente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Docente> listarDocentes(String prefijoGrupo) {
        return DocenteMapper.INSTANCE.toDomainList(docenteRepository.findByNombreGrupoStartingWithIgnoreCaseOrderByApellidosDocenteAsc(prefijoGrupo));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Docente> listarMiembrosComite() {
        System.out.println("Consultando miembros del comite");
        List<DocenteEntity> docentesComite = docenteRepository.buscarMiembrosComite();
        System.out.println(docentesComite.size() + " miembros encontrados");
        return DocenteMapper.INSTANCE.toDomainList(docentesComite);
    }
}
