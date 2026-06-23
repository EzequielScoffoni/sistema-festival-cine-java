package modelo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Pelicula {

    private String titulo;
    private String genero;
    private int duracion;
    private Set<Actor> actores;
    private Director director;
    private Set<Categoria> categorias;
    private Set<Evaluacion> evaluaciones;

    public Pelicula(String titulo, String genero, int duracion, Director director) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.actores = new HashSet<>();
        this.director = director;
        this.categorias = new HashSet<>();
        this.evaluaciones = new HashSet<>();
    }

    public boolean agregarEvaluacion (Evaluacion evaluacion) {
        return evaluaciones.add(evaluacion);
    }

    public double calcularPromedioEvaluaciones () {
        double suma = 0;
        for (Iterator<Evaluacion> i = evaluaciones.iterator(); i.hasNext(); ) {
            Evaluacion evaluacion = i.next();
            suma += evaluacion.getPuntaje();
        }
        if (evaluaciones.isEmpty()) {
            return 0;
        } else {
            return suma / evaluaciones.size();
        }
    }

    public boolean agregarActor (Actor actor) {
        return actores.add(actor);
    }

    public boolean agregarCategoria (Categoria categoria) {
        return categorias.add(categoria);
    }

    public String obtenerInformacion () {
        return "Título: " + titulo + "\nGénero: " + genero + "\nDuración: " + duracion + "\nDirector: " + director + "\nActores: " + actores + "\nCategorías: " + categorias;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public Set<Actor> getActores() {
        return actores;
    }

    public Director getDirector() {
        return director;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pelicula pelicula = (Pelicula) o;

        if (!titulo.equals(pelicula.titulo)){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode(){
        return titulo.hashCode();
    }

}
