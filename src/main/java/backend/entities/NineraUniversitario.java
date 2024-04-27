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
@Table(name = "ninera_universitario")

public class NineraUniversitario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Usuario_id")
    private User usuario_ninera;



}
