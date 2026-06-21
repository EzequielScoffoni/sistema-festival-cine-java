package modelo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Festival {

    private String nombreFestival;
    private Set<Edicion> ediciones;

    public Festival(String nombreFestival) {
        this.nombreFestival = nombreFestival;
        this.ediciones = new HashSet<>();
    }

    public boolean agregarEdicion (Edicion edicion) {
        return ediciones.add(edicion);
    }

    public Set<Funcion> obtenerFunciones () {
        Set<Funcion> funciones;
        funciones = new HashSet<>();
        for(Iterator<Edicion> i = ediciones.iterator(); i.hasNext(); ) {
            Edicion edicionActual = i.next();
            funciones.addAll(edicionActual.getFunciones());
        }
        return funciones;
    }

    public String getNombreFestival() {
        return nombreFestival;
    }

    public Set<Edicion> getEdicion() {
        return ediciones;
    }

    @Override
    public String toString() {
        return nombreFestival;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Festival festival = (Festival) o;

        if (!nombreFestival.equals(festival.nombreFestival)){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode(){
        return nombreFestival.hashCode();
    }

}
