package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DocenteDTOPeticion {
    @PositiveOrZero(message = "{docente.idDocente.invalid}")
    private Integer idDocente;
    @NotNull(message = "{docente.name.empty}")
    @Size(min = 2, max = 100, message = "{docente.name.size}")
    private String nombreDocente;
    @NotNull(message = "{docente.lastname.empty}")
    @Size(min = 2, max = 100, message = "{docente.lastname.size}")
    private String apellidosDocente;
    @Size(min = 2, max = 50, message = "{docente.group.size}")
    private String nombreGrupo;
    @NotNull(message = "{docente.email.empty}")
    @Size(min = 5, max = 100, message = "{docente.email.size}")
    @Email(message = "{docente.email.invalid}")
    private String correo;
}
