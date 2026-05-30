package modelo;

import java.util.HashSet;
import java.util.Set;

public class Pelicula {

    private String titulo;
    private String genero;
    private int duracion;
    private Set<Actor> actores;
    private Director director;
    private Set<Categoria> categorias;

    public Pelicula(String titulo, String genero, int duracion, Director director) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.actores = new HashSet<>();
        this.director = director;
        this.categorias = new HashSet<>();
    }

    public boolean agregarActor (Actor actor) {
        return actores.add(actor);
    }

    public boolean agregarCategoria (Categoria categoria) {
        return categorias.add(categoria);
    }

    public String obtenerInformacion () {
        return "Titulo: " + titulo + "Genero: " + genero + "Duración: " + duracion + "Actores: " + actores + "Director: " + director + "Categorias: " + categorias;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setActores(Set<Actor> actores) {
        this.actores = actores;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }
}
