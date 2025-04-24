/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FormatoPPDTORespuesta extends FormatoDTORespuesta{
    String nombreAsesor;
    String nombreEstudiante1;
    String rutaCartaAceptacion;
}
