package backend.entities;

public class Estado_de_servicio {
    private int id;
    private String nombre_del_estado;

    public Estado_de_servicio(int id, String nombre_del_estado) {
        this.id = id;
        this.nombre_del_estado = nombre_del_estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_del_estado() {
        return nombre_del_estado;
    }

    public void setNombre_del_estado(String nombre_del_estado) {
        this.nombre_del_estado = nombre_del_estado;
    }
}
