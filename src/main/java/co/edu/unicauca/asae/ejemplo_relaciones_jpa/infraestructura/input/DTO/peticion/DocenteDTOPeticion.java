package co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.input.DTO.peticion;

import lombok.Data;

@Data
public class DocenteDTOPeticion {
    private Integer idDocente;
    private String nombreDocente;
    private String apellidosDocente;
    private String nombreGrupo;
    private String correo;
}
