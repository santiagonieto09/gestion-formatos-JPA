package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion;

import java.util.List;

import lombok.Data;

@Data
public class ObservacionDTOPeticion {
    private String observacion;
    private List<Integer> idDocentes;
    private Integer idFormatoA;
}
