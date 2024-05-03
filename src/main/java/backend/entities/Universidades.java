package backend.entities;

public class Universidades {
    private int id;
    private String nombre_Universidad;

    public Universidades(int id, String nombre_Universidad) {
        this.id = id;
        this.nombre_Universidad = nombre_Universidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_Universidad() {
        return nombre_Universidad;
    }

    public void setNombre_Universidad(String nombre_Universidad) {
        this.nombre_Universidad = nombre_Universidad;
    }

    @Override
    public String toString() {
        return "Universidades{" +
                "id=" + id +
                ", nombre_Universidad='" + nombre_Universidad + '\'' +
                '}';
    }
}
