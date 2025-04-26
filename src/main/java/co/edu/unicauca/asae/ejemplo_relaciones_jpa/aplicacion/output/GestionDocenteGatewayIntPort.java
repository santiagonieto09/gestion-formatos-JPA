package co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.DocenteDTORespuesta;

import java.util.List;

public interface GestionDocenteGatewayIntPort {
    boolean existeDocentePorId(Integer idDocente);

    List<Docente> listarDocentes(String prefijoGrupo);

    List<Docente> listarMiembrosComite();
}
