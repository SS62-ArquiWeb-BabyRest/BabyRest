package backend.entities;

public class Disponibilidad {
    private int id;
    private int dia;
    private int horaIni;
    private int horaFin;
    private int nineraUniversitarioId;

    // Constructor
    public Disponibilidad(int id, int dia, int horaIni, int horaFin, int nineraUniversitarioId) {
        this.id = id;
        this.dia = dia;
        this.horaIni = horaIni;
        this.horaFin = horaFin;
        this.nineraUniversitarioId = nineraUniversitarioId;
    }

    public static void main(String[] args) {
        // Crear una instancia de Disponibilidad
        Disponibilidad disponibilidad = new Disponibilidad(1, 2, 8, 17, 123);

        // Acceder a las variables miembro
        System.out.println("ID: " + disponibilidad.getId());
        System.out.println("Día: " + disponibilidad.getDia());
        System.out.println("Hora Inicial: " + disponibilidad.getHoraIni());
        System.out.println("Hora Final: " + disponibilidad.getHoraFin());
        System.out.println("ID de la niñera/universitario: " + disponibilidad.getNineraUniversitarioId());
    }
}
