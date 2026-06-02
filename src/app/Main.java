package app;
import modelo.Pelicula;
import modelo.Director;
import pesistencia.PeliculaCSV;

public class Main {
    public static void main(String[] args) {
        // Prueba de clases, metodos y persistencia
        Director director1 = new Director("Christopher", "Nolan", 55, "30/07/1970", "masculino");
        Pelicula pelicula1 = new Pelicula("Interestelar", "Ficcion", 180, director1);
        PeliculaCSV peliculaCSV1 = new PeliculaCSV();
        peliculaCSV1.guardarPelicula(pelicula1);
        peliculaCSV1.leerPelicula();
    }
}





