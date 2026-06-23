package servicios;

import modelo.*;
import pesistencia.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SistemaFestival {

    private static Set<Festival> festivales = new LinkedHashSet<>();
    private static Set<Pelicula> peliculas = new LinkedHashSet<>();
    private static Set<Director> directores = new LinkedHashSet<>();
    private static Set<Actor> actores = new LinkedHashSet<>();
    private static Set<Categoria> categorias = new LinkedHashSet<>();
    private static Set<Sala> salas = new LinkedHashSet<>();
    private static Set<Funcion> funciones = new LinkedHashSet<>();
    private static Set<Espectador>espectadores = new LinkedHashSet<>();
    private static Set<Entrada> entradas = new LinkedHashSet<>();
    private static Set<Jurado> jurados = new HashSet<>();
    private static Set<Evaluacion> evaluaciones = new HashSet<>();

    public static Set<Festival> getFestivales() {
        return festivales;
    }
    public static Set<Pelicula> getPeliculas() {
        return peliculas;
    }

    public static Set<Director> getDirectores() {
        return directores;
    }

    public static Set<Actor> getActores() {
        return actores;
    }

    public static Set<Categoria> getCategorias() {
        return categorias;
    }

    public static Set<Sala> getSalas() {
        return salas;
    }

    public static Set<Funcion> getFunciones() {
        return funciones;
    }

    public static Set<Espectador> getEspectadores() {
        return espectadores;
    }

    public static Set<Entrada> getEntradas() {
        return entradas;
    }

    public static Set<Jurado> getJurados() {
        return jurados;
    }

    public static Set<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public static void cargarDatos () {

        DirectorCSV directorCSV = new DirectorCSV();
        ActorCSV actorCSV = new ActorCSV();
        FestivalCSV festivalCSV = new FestivalCSV();
        EdicionCSV edicionCSV = new EdicionCSV();
        PeliculaCSV peliculaCSV = new PeliculaCSV();
        CategoriaCSV categoriaCSV = new CategoriaCSV();
        ActorPeliculaCSV actorPeliculaCSV = new ActorPeliculaCSV();
        SalaCSV salaCSV = new SalaCSV();
        FuncionCSV funcionCSV = new FuncionCSV();
        EspectadorCSV espectadorCSV = new EspectadorCSV();
        EntradaCSV entradaCSV = new EntradaCSV();
        JuradoCSV juradoCSV = new JuradoCSV();
        EvaluacionCSV evaluacionCSV = new EvaluacionCSV();


        directores.addAll(directorCSV.cargarDirectores());
        actores.addAll(actorCSV.cargarActores());
        festivales.addAll(festivalCSV.cargarFestivales());
        edicionCSV.cargarEdiciones(festivales);
        peliculas.addAll(peliculaCSV.cargarPeliculas());
        categoriaCSV.cargarCategorias(peliculas);
        actorPeliculaCSV.cargarActoresPeliculas(peliculas, actores);
        salas.addAll(salaCSV.cargarSalas());
        funcionCSV.cargarFunciones(funciones, peliculas, salas, festivales);
        espectadores.addAll(espectadorCSV.cargarEspectadores());
        entradaCSV.cargarEntradas(entradas, espectadores, funciones);
        jurados.addAll(juradoCSV.cargarJurados());
        evaluacionCSV.cargarEvaluaciones(evaluaciones, peliculas, jurados);

    }

}
