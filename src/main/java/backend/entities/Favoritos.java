package backend.entities;

public class Favoritos {
    private int idFavorito;
    private int padreEmpleadorId;
    private int nineraUniversitarioId;


    public Favoritos(int idFavorito, int padreEmpleadorId, int nineraUniversitarioId) {
        this.idFavorito = idFavorito;
        this.padreEmpleadorId = padreEmpleadorId;
        this.nineraUniversitarioId = nineraUniversitarioId;
    }

    public static void main(String[] args) {

        Favoritos favorito = new Favoritos(1, 456, 123);


        System.out.println("ID Favorito: " + favorito.getIdFavorito());
        System.out.println("ID del padre empleador: " + favorito.getPadreEmpleadorId());
        System.out.println("ID de la niñera/universitario: " + favorito.getNineraUniversitarioId());
    }
}

