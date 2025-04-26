package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FormatoPPDTOPeticion extends FormatoDTOPeticion{
    String nombreAsesor;
    String nombreEstudiante1;
    String rutaCartaAceptacion;
}
