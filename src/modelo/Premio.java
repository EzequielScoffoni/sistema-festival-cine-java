package modelo;

import java.util.HashSet;
import java.util.Set;

public class Premio {

    private String nombrePremio;
    private int anio;
    private String descripcion;
    private Categoria categoria;
    private Set<Pelicula> peliculas;

    public Premio(String nombrePremio, int anio, String descripcion, Categoria categoria) {
        this.nombrePremio = nombrePremio;
        this.anio = anio;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.peliculas = new HashSet<>();
    }

    public boolean asignarGanador (Pelicula pelicula) {
        return peliculas.add(pelicula);
    }

    public String getNombrePremio() {
        return nombrePremio;
    }

    public int getAnio() {
        return anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

}
