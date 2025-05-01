/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.validaciones.ObjetivoInfinitivo;

import java.util.List;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FormatoPPDTOPeticion.class, name = "PP"),
        @JsonSubTypes.Type(value = FormatoTIDTOPeticion.class, name = "TI")
})
public class FormatoDTOPeticion {
    @Size(min = 2, max = 2, message = "{formato.tipo.size}")
    String tipo; //PP, TI
    @NotBlank(message = "{formato.titulo.empty}")
    @Size(min = 2, max = 100, message = "{formato.titulo.size}")
    String titulo;
    @Valid
    @NotNull(message = "{formato.docente.empty}")
    DocenteDTOPeticion docente;
    @NotBlank(message = "{formato.objetivoGeneral.empty}")
    @ObjetivoInfinitivo()
    String objetivoGeneral;
    @NotNull(message = "{formato.objetivosEspecificos.empty}")
    @Size(min = 3, max = 5, message = "{formato.objetivosEspecificos.size}")
    List< @ObjetivoInfinitivo() String> objetivosEspecificos;
}
