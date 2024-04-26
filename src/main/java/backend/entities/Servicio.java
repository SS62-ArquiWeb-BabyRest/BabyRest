package backend.entities;

import java.util.Date;

public class Servicio {
    private int id;
    private int padre_empleador_id;
    private int ninera_universitaria_id;
    private double precio;
    private String descripción;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String dirección;
    private Date fecha_registro;
    private int estado_de_servicio_id;

    public Servicio(int id, int padre_empleador_id, int ninera_universitaria_id, double precio, String descripción, Date fecha_inicio, Date fecha_fin, String dirección, Date fecha_registro, int estado_de_servicio_id) {
        this.id = id;
        this.padre_empleador_id = padre_empleador_id;
        this.ninera_universitaria_id = ninera_universitaria_id;
        this.precio = precio;
        this.descripción = descripción;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.dirección = dirección;
        this.fecha_registro = fecha_registro;
        this.estado_de_servicio_id = estado_de_servicio_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPadre_empleador_id() {
        return padre_empleador_id;
    }

    public void setPadre_empleador_id(int padre_empleador_id) {
        this.padre_empleador_id = padre_empleador_id;
    }

    public int getNinera_universitaria_id() {
        return ninera_universitaria_id;
    }

    public void setNinera_universitaria_id(int ninera_universitaria_id) {
        this.ninera_universitaria_id = ninera_universitaria_id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getEstado_de_servicio_id() {
        return estado_de_servicio_id;
    }

    public void setEstado_de_servicio_id(int estado_de_servicio_id) {
        this.estado_de_servicio_id = estado_de_servicio_id;
    }
}
