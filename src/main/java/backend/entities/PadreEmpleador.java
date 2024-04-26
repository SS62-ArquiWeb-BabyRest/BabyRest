package backend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "padre_empleador")
public class PadreEmpleador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre_padre;

    private String genero_padre;

    private String dni_padre;

    private LocalDate fecha_nacimiento_padre;

    private String telefono_padre;

    private String direccion_actual_padre;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Usuario_id")
    private Usuario usuario_padre;
}
