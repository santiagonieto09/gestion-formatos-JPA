package co.edu.unicauca.asae.ejemplo_relaciones_jpa.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estados")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstado;
    @Column(name = "estado_actual", nullable = false, length = 50)
    private String estadoActual;
    @Column(name = "fecha_registro_estado", nullable = false)
    private Date fechaRegistroEstado;
    @OneToOne
    @JoinColumn(name = "idFormatoA")
    private FormatoA formatoA;

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Date getFechaRegistroEstado() {
        return fechaRegistroEstado;
    }

    public void setFechaRegistroEstado(Date fechaRegistroEstado) {
        this.fechaRegistroEstado = fechaRegistroEstado;
    }

    public FormatoA getFormatoA() {
        return formatoA;
    }

    public void setFormatoA(FormatoA formatoA) {
        this.formatoA = formatoA;
    }

}
