package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionFormatoAGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.FormatoAEntity;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.mappers.FormatoAMapper;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.DocentesRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.FormatosARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GestionFormatoAGatewayImplAdapter implements GestionFormatoAGatewayIntPort {
    private final FormatosARepository formatoARepository;
    private final DocentesRepository docentesRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean existeFormatoAPorId(Integer idFormatoA) {
        return formatoARepository.existsById(idFormatoA);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeFormatoAPorTitulo(String titulo) {
        return formatoARepository.existsByTitulo(titulo) > 0;
    }

    @Override
    @Transactional
    public FormatoA crearFormatoA(FormatoA formatoA) {
        FormatoAEntity formatoACreado;
        FormatoAEntity formatoAEntity = FormatoAMapper.INSTANCE.toEntity(formatoA);
        Optional<DocenteEntity> docenteOpt = docentesRepository.findById(formatoA.getDocente().getIdDocente());

        if (docenteOpt.isPresent()) {
            System.out.println("El docente ya existe en la base de datos.");
            formatoAEntity.setDocenteEntity(docenteOpt.get());
        } else {
            System.out.println("El docente no existe en la base de datos. Creando docente...");
            formatoAEntity.getDocenteEntity().setIdDocente(null);

            if(docentesRepository.existeDocenteConCorreo(formatoA.getDocente().getCorreo())) {
                System.out.println("Este correo ya se encuentra registrad.");
                throw new ReglaNegocioExcepcion("El correo ya se encuentra registrado.");
            }
        }

        formatoAEntity.getEstadoEntity().setFormatoAEntity(formatoAEntity);
        formatoACreado = formatoARepository.save(formatoAEntity);
        return FormatoAMapper.INSTANCE.toDomain(formatoACreado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FormatoA> consultarFormatosADocente(Integer idDocente) {
        return FormatoAMapper.INSTANCE.toDomainList(formatoARepository.findByDocenteEntityId(idDocente));
    }

    @Override
    @Transactional(readOnly = true)
    public List<FormatoA> consultarFormatosADocenteRangoFechas(Integer idDocente, Date fechaInicio, Date fechaFin) {
        return FormatoAMapper.INSTANCE.toDomainList(
                formatoARepository.listarFormatosPorDocenteYFechas(idDocente, fechaInicio, fechaFin));
    }
}
