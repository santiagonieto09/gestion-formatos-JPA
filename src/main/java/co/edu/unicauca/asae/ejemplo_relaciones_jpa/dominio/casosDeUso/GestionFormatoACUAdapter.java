package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.casosDeUso;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.input.GestionFormatoACUIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.aplicacion.output.GestionFormatoAGatewayIntPort;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta.FormatoDTORespuesta;

import java.util.Date;
import java.util.List;


public class GestionFormatoACUAdapter implements GestionFormatoACUIntPort {

   private final GestionFormatoAGatewayIntPort objGestionFormatoAGateway;
   private final FormateadorResultadosIntPort objFormatoAFormateadorResultados;

   public GestionFormatoACUAdapter(GestionFormatoAGatewayIntPort objGestionFormatoAGateway, FormateadorResultadosIntPort objFormatoAFormateadorResultados) {
       this.objGestionFormatoAGateway = objGestionFormatoAGateway;
       this.objFormatoAFormateadorResultados = objFormatoAFormateadorResultados;
   }

    @Override
    public FormatoDTORespuesta crearFormatoA(FormatoDTORespuesta formatoDTOPeticion) {
        return null;
    }

    @Override
    public FormatoDTORespuesta listarObservacionesFormatoA(Integer idFormatoA) {
        return null;
    }

    @Override
    public List<FormatoDTORespuesta> consultarFormatosADocente(Integer idDocente) {
        return List.of();
    }

    @Override
    public List<FormatoDTORespuesta> consultarFormatosADocenteRangoFechas(Integer idDocente, Date fechaInicio, Date fechaFin) {
        return List.of();
    }
}
