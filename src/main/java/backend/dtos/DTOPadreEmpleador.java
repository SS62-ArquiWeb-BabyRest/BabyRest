package backend.dtos;

import backend.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DTOPadreEmpleador {

    private Long id;

    private String nombre_padre;

    private String genero_padre;

    private String dni_padre;

    private LocalDate fecha_nacimiento_padre;

    private String telefono_padre;

    private String direccion_actual_padre;

    private Usuario usuario_padre;
}
