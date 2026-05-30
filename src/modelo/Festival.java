package modelo;

import java.util.HashSet;
import java.util.Set;

public class Festival {

    private String nombreFestival;
    private Set<Edicion> ediciones;

    public Festival(String nombreFestival) {
        this.nombreFestival = nombreFestival;
        this.ediciones = new HashSet<>();
    }

    public String getNombreFestival() {
        return nombreFestival;
    }

    public Set<Edicion> getEdicion() {
        return ediciones;
    }

    public void setNombreFestival(String nombreFestival) {
        this.nombreFestival = nombreFestival;
    }

    public void setEdicion(Set<Edicion> edicion) {
        this.ediciones = edicion;
    }
}
