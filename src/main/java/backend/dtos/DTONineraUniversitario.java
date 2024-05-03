package backend.dtos;

import backend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DTONineraUniversitario {

    private Long id;

    private String nombre_ninera;

    private String genero_ninera;

    private String dni_ninera;

    private LocalDate fecha_nacimiento_ninera;

    private String telefono_ninera;

    private String tarifa_por_hora;

    private String descripcion;

    private byte[] foto;

    private String codigo_alumno;

    private User usuario_ninera;

//    private Universidad universidad_ninera;

}
