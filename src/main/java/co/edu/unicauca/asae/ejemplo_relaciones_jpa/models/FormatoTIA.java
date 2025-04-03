package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "FormatosTIA")
public class FormatoTIA extends FormatoA {

    @Column(name = "nombre_estudiante1", nullable = false, length = 100)
    private String nombreEstudiante1;

    @Column(name = "nombre_estudiante2", nullable = true, length = 100)
    private String nombreEstudiante2;

    public String getNombreEstudiante1() {
        return nombreEstudiante1;
    }

    public void setNombreEstudiante1(String nombreEstudiante1) {
        this.nombreEstudiante1 = nombreEstudiante1;
    }

    public String getNombreEstudiante2() {
        return nombreEstudiante2;
    }

    public void setNombreEstudiante2(String nombreEstudiante2) {
        this.nombreEstudiante2 = nombreEstudiante2;
    }
}
