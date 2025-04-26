package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.casosDeUso;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input.GestionFormatoACUIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionFormatoAGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos.FormatoA;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.FormatoDTORespuesta;

import java.util.Date;
import java.util.List;


public class GestionFormatoACUAdapter implements GestionFormatoACUIntPort {

   private final GestionFormatoAGatewayIntPort objGestionFormatoAGateway;
   private final FormateadorResultadosIntPort objFormateadorResultados;

   public GestionFormatoACUAdapter(GestionFormatoAGatewayIntPort objGestionFormatoAGateway, FormateadorResultadosIntPort objFormateadorResultados) {
       this.objGestionFormatoAGateway = objGestionFormatoAGateway;
       this.objFormateadorResultados = objFormateadorResultados;
   }

    @Override
    public FormatoA crearFormatoA(FormatoA formatoA) {
        FormatoA formatoACreado;

        if(objGestionFormatoAGateway.existeFormatoAPorTitulo(formatoA.getTitulo())){
            objFormateadorResultados.retornarRespuestaErrorEntidadExiste("Ya existe un formato A con el mismo título.");
        }

        formatoA.inicializarFormato();
        System.out.println("Formato A inicializado: " + formatoA);
        formatoACreado = objGestionFormatoAGateway.crearFormatoA(formatoA);

        return formatoACreado;
    }

    @Override
    public FormatoA listarObservacionesFormatoA(Integer idFormatoA) {
        return null;
    }

    @Override
    public List<FormatoA> consultarFormatosADocente(Integer idDocente) {
        return List.of();
    }

    @Override
    public List<FormatoA> consultarFormatosADocenteRangoFechas(Integer idDocente, Date fechaInicio, Date fechaFin) {
        return List.of();
    }
}
