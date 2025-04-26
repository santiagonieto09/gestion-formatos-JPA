package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.modelos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FormatoPPA extends FormatoA {
    private String nombreAsesor;
    private String nombreEstudiante1;
    private String rutaCartaAceptacion;
}
