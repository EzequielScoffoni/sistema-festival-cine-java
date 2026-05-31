package modelo;

import java.util.HashSet;
import java.util.Set;

public class Sala {

    private int nroSala;
    private Set<Butaca> butacas;
    private Set<Funcion> funciones;

    public Sala(int nroSala, Set<Butaca> butacas) {
        this.nroSala = nroSala;
        this.butacas = butacas;
        this.funciones = new HashSet<>();
    }

    public boolean asignarFuncion (Funcion funcion) {
        return funciones.add(funcion);
    }

    public int getNroSala() {
        return nroSala;
    }

    public Set<Butaca> getButacas() {
        return butacas;
    }

    public void setNroSala(int nroSala) {
        this.nroSala = nroSala;
    }

    public void setButacas(Set<Butaca> butacas) {
        this.butacas = butacas;
    }
}
