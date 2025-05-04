package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.casosDeUso;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input.GestionFormatoACUIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionDocenteGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionFormatoAGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.FormatoA;

import java.util.Date;
import java.util.List;


public class GestionFormatoACUAdapter implements GestionFormatoACUIntPort {

   private final GestionFormatoAGatewayIntPort objGestionFormatoAGateway;
   private final GestionDocenteGatewayIntPort objGestionDocenteGateway;
   private final FormateadorResultadosIntPort objFormateadorResultados;

   public GestionFormatoACUAdapter(GestionFormatoAGatewayIntPort objGestionFormatoAGateway, FormateadorResultadosIntPort objFormateadorResultados, GestionDocenteGatewayIntPort objGestionDocenteGateway) {
       this.objGestionFormatoAGateway = objGestionFormatoAGateway;
       this.objFormateadorResultados = objFormateadorResultados;
         this.objGestionDocenteGateway = objGestionDocenteGateway;
   }

    @Override
    public FormatoA crearFormatoA(FormatoA formatoA) {
        FormatoA formatoACreado;

        if(objGestionFormatoAGateway.existeFormatoAPorTitulo(formatoA.getTitulo())){
            objFormateadorResultados.retornarRespuestaErrorEntidadExiste("Ya existe un formato A con el mismo título.");
        }

        if(!objGestionDocenteGateway.existeDocentePorId(formatoA.getDocente().getIdDocente()) && objGestionFormatoAGateway.existeDocenteConCorreo(formatoA.getDocente().getCorreo())){
            objFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("Ya existe un docente con el mismo correo.");
        }

        formatoA.inicializarFormato();
        formatoACreado = objGestionFormatoAGateway.crearFormatoA(formatoA);

        return formatoACreado;
    }

    @Override
    public List<FormatoA> consultarFormatosADocente(Integer idDocente) {
        if (!objGestionDocenteGateway.existeDocentePorId(idDocente)) {
            objFormateadorResultados.retornarRespuestaErrorEntidadNoExiste("El docente no existe.");
        }
        return objGestionFormatoAGateway.consultarFormatosADocente(idDocente);
    }

    @Override
    public List<FormatoA> consultarFormatosADocenteRangoFechas(Integer idDocente, Date fechaInicio, Date fechaFin) {
        if (!objGestionDocenteGateway.existeDocentePorId(idDocente)) {
            objFormateadorResultados.retornarRespuestaErrorEntidadNoExiste("El docente no existe.");
        }
        return objGestionFormatoAGateway.consultarFormatosADocenteRangoFechas(idDocente, fechaInicio, fechaFin);
    }
}
