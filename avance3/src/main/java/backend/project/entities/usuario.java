package backend.project.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Scanner;
import javax.persistence.*;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    private int tipo_usuario;
    private String nombre_usuario;
    private String contrasena;


    public usuario(int id_usuario, int tipo_usuario, String nombre_usuario, String contrasena) {
        this.id_usuario = id_usuario;
        this.tipo_usuario = tipo_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;



    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    public class LoginSection {
        private static usuario[] usuarios = new usuario[10]; // 10 usuarios con acceso
        private static int numUsuarios = 0;

        public static void main(String[] args) {
            // usuarios admitidos
            usuarios[numUsuarios++] = new usuario(1, 1, "admin", "password123");
            usuarios[numUsuarios++] = new usuario(2, 2, "user1", "password123");
            usuarios[numUsuarios++] = new usuario(3, 3, "user2", "password123");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Login Section");
            System.out.print("Enter nombre_usuario: ");
            String nombre_usuario = scanner.nextLine();
            System.out.print("ingrese contraseña: ");
            String contrasena = scanner.nextLine();
            System.out.print("ingrese tipo_usuario (1 o 2): ");
            int tipo_usuario = scanner.nextInt();
            scanner.nextLine();

            boolean logeovalido = false;
            for (usuario user : usuarios) {
                if (user.getNombre_usuario().equals(nombre_usuario) &&
                        user.getContrasena().equals(contrasena) &&
                        user.getTipo_usuario() == tipo_usuario) {
                    logeovalido = true;
                    System.out.println("Login successful! Welcome, " + nombre_usuario);
                    break;
                }
            }

            if (!logeovalido) {
                System.out.println("Invalid login credentials. Please try again.");
            }
        }
    }

}
