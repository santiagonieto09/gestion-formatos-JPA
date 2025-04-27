package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class ObservacionDTOPeticion {
    @NotBlank(message = "El texto de la observacion es obligatorio")
    private String observacion;
    @NotEmpty(message = "Debe haber al menos un docente")
    private List<@Min(value = 1, message = "idDocente debe ser >=1") Integer> idDocentes;
    @NotNull(message = "El idFormatoA es obligatorio")
    @Min(value = 1, message = "idFormatoA debe ser >=1")
    private Integer idFormatoA;
}
