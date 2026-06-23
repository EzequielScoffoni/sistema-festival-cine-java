package modelo;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

public class Funcion {

    private String fechaFuncion;
    private String horaFuncion;
    private Pelicula pelicula;
    private Edicion edicion;
    private Sala sala;
    private Set<Entrada> entradas;

    public Funcion(String fechaFuncion, String horaFuncion, Pelicula pelicula, Edicion edicion, Sala sala, Set<Entrada> entradas) {
        this.fechaFuncion = fechaFuncion;
        this.horaFuncion = horaFuncion;
        this.pelicula = pelicula;
        this.edicion = edicion;
        this.sala = sala;
        this.entradas = entradas;
    }

    public boolean verificarDisponibilidad () {
        if (entradas.size() < sala.getButacas().size()){
            return true;
        } else {
            return false;
        }
    }

    public boolean registrarEntrada (Entrada entrada) {
        if (verificarDisponibilidad()) {
            entradas.add(entrada);
            return true;
        }
        return false;
    }

    public int obtenerOcupacion () {
        return entradas.size();
    }

    public double obtenerPorcentajeOcupacion () {
        return obtenerOcupacion() * 100 / sala.getButacas().size();
    }

    public String getFechaFuncion() {
        return fechaFuncion;
    }

    public String getHoraFuncion() {
        return horaFuncion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Edicion getEdicion() {
        return edicion;
    }

    public Sala getSala() {
        return sala;
    }

    public Set<Entrada> getEntradas() {
        return entradas;
    }

    public String obtenerInformacion() {
        return "Película: " + pelicula.getTitulo() + "\nFecha: " + fechaFuncion + "\nHora: " + horaFuncion + "\nSala: " + sala.getNroSala() + "\nEdición: " + edicion.getNroEdicion();
    }

    @Override
    public String toString() {
        return pelicula.getTitulo() + " - " + fechaFuncion + " " + horaFuncion + " - Sala " + sala.getNroSala();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Funcion funcion = (Funcion) o;

        return fechaFuncion.equals(funcion.fechaFuncion) && horaFuncion.equals(funcion.horaFuncion) && pelicula.equals(funcion.pelicula) && sala.equals(funcion.sala);
    }

    @Override
    public int hashCode() {
        return (fechaFuncion + horaFuncion + pelicula.getTitulo() + sala.getNroSala()).hashCode();
    }


}
