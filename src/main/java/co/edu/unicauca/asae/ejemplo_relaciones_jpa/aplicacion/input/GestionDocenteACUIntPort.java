package co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.DocenteDTORespuesta;

import java.util.List;

public interface GestionDocenteACUIntPort {
    List<Docente> listarDocentes(String prefijoGrupo);

    List<Docente> listarMiembrosComite();
}
