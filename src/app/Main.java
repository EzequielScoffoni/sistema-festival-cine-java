package app;
import modelo.*;
import pesistencia.FuncionCSV;
import pesistencia.PeliculaCSV;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // Prueba de clases, metodos y persistencia (peliculas.csv)
        Director director1 = new Director("Christopher", "Nolan", 55, "30/07/1970", "masculino");
        Pelicula pelicula1 = new Pelicula("Interestelar", "Ficcion", 180, director1);
        PeliculaCSV peliculaCSV1 = new PeliculaCSV();
        peliculaCSV1.guardarPelicula(pelicula1);
        peliculaCSV1.leerPelicula();

        // Prueba de persistencia (Funcion.csv)
        Festival festival1 = new Festival("Nueva ficcion");
        Edicion edicion1 = new Edicion(1, "Buenos Aires", "30/06/2026", festival1);
        Sala sala1 = new Sala(6, new HashSet<>());
        Funcion funcion1 = new Funcion("30/06/2026", "12:30", pelicula1, edicion1, sala1, new HashSet<>());

        FuncionCSV funcionCSV1 = new FuncionCSV();
        funcionCSV1.guardarFuncion(funcion1);
        funcionCSV1.leerFuncion();

    }
}





