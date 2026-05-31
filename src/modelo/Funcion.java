package modelo;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

public class Funcion {

    private Date fechaFuncion;
    private Time horaFuncion;
    private Pelicula pelicula;
    private Edicion edicion;
    private Sala sala;
    private Set<Entrada> entradas;

    public Funcion(Date fechaFuncion, Time horaFuncion, Pelicula pelicula, Edicion edicion, Sala sala, Set<Entrada> entradas) {
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

    public Date getFechaFuncion() {
        return fechaFuncion;
    }

    public Time getHoraFuncion() {
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

    public void setFechaFuncion(Date fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    public void setHoraFuncion(Time horaFuncion) {
        this.horaFuncion = horaFuncion;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setEdicion(Edicion edicion) {
        this.edicion = edicion;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setEntradas(Set<Entrada> entradas) {
        this.entradas = entradas;
    }
}
