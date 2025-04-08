package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "FormatosPPA")
public class FormatoPPA extends FormatoA{
    
    @Column(name = "nombre_asesor", nullable = false, length = 100)    
    private String nombreAsesor;

    @Column(name = "nombre_estudiante1", nullable = false, length = 100)
    private String nombreEstudiante1;

    @Column(name = "ruta_carta_aceptacion", nullable = false, length = 255)
    private String rutaCartaAceptacion;
}
