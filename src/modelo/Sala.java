package modelo;

import java.util.HashSet;
import java.util.Iterator;
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
        for (Iterator<Funcion> i = funciones.iterator(); i.hasNext();) {
            Funcion funcionActual = i.next();
            if (funcionActual.getFechaFuncion().equals(funcion.getFechaFuncion()) && funcionActual.getHoraFuncion().equals(funcion.getHoraFuncion())) {
                return false;
            }
        }
        funciones.add(funcion);
        return true;
    }

    public boolean agregarButuca (Butaca butaca) {
        return butacas.add(butaca);
    }

    public int getNroSala() {
        return nroSala;
    }

    public Set<Butaca> getButacas() {
        return butacas;
    }

    @Override
    public String toString() {
        return "Sala " + nroSala;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Sala sala = (Sala) o;

        return nroSala == sala.nroSala;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(nroSala);
    }

}
