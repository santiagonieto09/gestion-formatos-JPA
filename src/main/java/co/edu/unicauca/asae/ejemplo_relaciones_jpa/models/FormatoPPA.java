package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "FormatosPPA")
public class FormatoPPA extends FormatoA{
    
    @Column(name = "nombre_asesor", nullable = false, length = 100)    
    private String nombreAsesor;

    @Column(name = "nombre_estudiante1", nullable = false, length = 100)
    private String nombreEstudiante1;

    @Column(name = "ruta_carta_aceptacion", nullable = false, length = 255)
    private String rutaCartaAceptacion;

    public String getNombreAsesor() {
        return nombreAsesor;
    }

    public void setNombreAsesor(String nombreAsesor) {
        this.nombreAsesor = nombreAsesor;
    }

    public String getNombreEstudiante1() {
        return nombreEstudiante1;
    }

    public void setNombreEstudiante1(String nombreEstudiante1) {
        this.nombreEstudiante1 = nombreEstudiante1;
    }

    public String getRutaCartaAceptacion() {
        return rutaCartaAceptacion;
    }

    public void setRutaCartaAceptacion(String rutaCartaAceptacion) {
        this.rutaCartaAceptacion = rutaCartaAceptacion;
    }
}
