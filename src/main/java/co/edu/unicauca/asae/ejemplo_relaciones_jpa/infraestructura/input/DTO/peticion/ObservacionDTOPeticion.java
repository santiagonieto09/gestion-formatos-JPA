package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class ObservacionDTOPeticion {
    @NotBlank(message = "{observacion.empty}")
    private String observacion;
    @NotEmpty(message = "{observacion.idDocentes.empty}")
    private List<@Min(value = 1, message = "{observacion.idDocentes.invalid}") Integer> idDocentes;
    @NotNull(message = "{observacion.idFormatoA.empty}")
    @Min(value = 1, message = "{observacion.idFormatoA.invalid}")
    private Integer idFormatoA;
}
