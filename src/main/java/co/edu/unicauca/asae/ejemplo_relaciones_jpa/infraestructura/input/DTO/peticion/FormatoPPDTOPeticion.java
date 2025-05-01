package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FormatoPPDTOPeticion extends FormatoDTOPeticion{
    @NotBlank(message = "{formatoPP.nombreAsesor.empty}")
    @Size(min = 2, max = 100, message = "{formatoPP.nombreAsesor.size}")
    String nombreAsesor;
    @NotBlank(message = "{formatoPP.nombreEstudiante1.empty}")
    @Size(min = 2, max = 100, message = "{formatoPP.nombreEstudiante1.size}")
    String nombreEstudiante1;
    @NotNull(message = "{formatoPP.idEstudiante1.empty}")
    @Pattern(regexp = "^1046[0-9]{8}$", message = "{formatoPP.idEstudiante1.invalid}")
    String idEstudiante1;
    @NotBlank(message = "{formatoPP.rutaCartaAceptacion.empty}")
    @Size(min = 2, max = 255, message = "{formatoPP.rutaCartaAceptacion.size}")
    String rutaCartaAceptacion;
}
