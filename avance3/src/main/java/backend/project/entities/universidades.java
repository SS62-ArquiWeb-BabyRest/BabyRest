package backend.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Scanner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@Entity
@Table(name = "universidades")

public class universidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_universidades;
    private String nombre;

    public universidades(int id_universidades, String nombre) {
        this.id_universidades = id_universidades;
        this.nombre = nombre;
    }

    public int getId_universidades() {
        return id_universidades;
    }

    public void setId_universidades(int id_universidades) {
        this.id_universidades = id_universidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public class univ {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingresa el nombre de la universidad de origen: ");
            String nombre = scanner.nextLine();

            universidades universidad = new universidades(1, nombre); // assume id_universidades is 1 for now

            System.out.println("Ingresaste: " + universidad.getNombre());
        }
    }

}
