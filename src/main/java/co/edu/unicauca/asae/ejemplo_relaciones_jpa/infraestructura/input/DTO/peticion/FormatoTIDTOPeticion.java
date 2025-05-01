/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FormatoTIDTOPeticion extends FormatoDTOPeticion{
    @NotBlank(message = "{formatoTI.nombreEstudiante1.empty}")
    @Size(min = 2, max = 100, message = "{formatoTI.nombreEstudiante1.size}")
    private String nombreEstudiante1;
    @NotNull(message = "{formatoTI.idEstudiante1.empty}")
    @Pattern(regexp = "^1046[0-9]{8}$", message = "{formatoTI.idEstudiante1.invalid}")
    private String idEstudiante1;
    @NotBlank(message = "{formatoTI.nombreEstudiante2.empty}")
    @Size(min = 2, max = 100, message = "{formatoTI.nombreEstudiante2.size}")
    private String nombreEstudiante2;
    @NotNull(message = "{formatoTI.idEstudiante2.empty}")
    @Pattern(regexp = "^1046[0-9]{8}$", message = "{formatoTI.idEstudiante2.invalid}")
    private String idEstudiante2;
}
