package servicios;

import modelo.Festival;
import modelo.Pelicula;

import java.util.LinkedHashSet;
import java.util.Set;

public class SistemaFestival {

    private static Set<Festival> festivales = new LinkedHashSet<>();
    private static Set<Pelicula> peliculas = new LinkedHashSet<>();

    public static Set<Festival> getFestivales() {
        return festivales;
    }
    public static Set<Pelicula> getPeliculas() {
        return peliculas;
    }
}
