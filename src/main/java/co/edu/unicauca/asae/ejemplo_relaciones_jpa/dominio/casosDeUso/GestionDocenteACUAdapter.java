package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.casosDeUso;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input.GestionDocenteACUIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionDocenteGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.Docente;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.DocenteDTORespuesta;

import java.util.List;

public class GestionDocenteACUAdapter implements GestionDocenteACUIntPort {
    private final GestionDocenteGatewayIntPort objGestionDocenteGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionDocenteACUAdapter(GestionDocenteGatewayIntPort objGestionDocenteGateway, FormateadorResultadosIntPort objFormateadorResultados) {
        this.objGestionDocenteGateway = objGestionDocenteGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public List<Docente> listarDocentes(String prefijoGrupo) {
        return objGestionDocenteGateway.listarDocentes(prefijoGrupo);
    }

    @Override
    public List<Docente> listarMiembrosComite() {
        return objGestionDocenteGateway.listarMiembrosComite();
    }
}
