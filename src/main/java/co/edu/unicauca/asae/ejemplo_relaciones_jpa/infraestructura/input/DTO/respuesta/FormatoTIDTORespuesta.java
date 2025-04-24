/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FormatoTIDTORespuesta extends FormatoDTORespuesta{
    String nombreEstudiante1;
    String nombreEstudiante2;
}
