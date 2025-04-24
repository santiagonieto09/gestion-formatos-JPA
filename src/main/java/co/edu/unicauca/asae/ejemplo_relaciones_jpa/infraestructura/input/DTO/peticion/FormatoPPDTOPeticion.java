package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FormatoPPDTOPeticion extends FormatoDTOPeticion{
    String nombreAsesor;
    String nombreEstudiante1;
    String rutaCartaAceptacion;
}
