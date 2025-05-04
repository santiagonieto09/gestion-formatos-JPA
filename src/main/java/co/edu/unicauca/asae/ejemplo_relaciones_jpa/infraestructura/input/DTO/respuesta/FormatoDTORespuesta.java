/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.respuesta;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.EstadoEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FormatoDTORespuesta {
    Integer idFormatoA;
    String tipo; //PP, TI
    String titulo;
    String objetivoGeneral;
    List<String> objetivosEspecificos;
    EstadoDTO estado;
    DocenteDTORespuesta docente;
    List<EvaluacionDTORespuesta> listaEvaluaciones;
}
