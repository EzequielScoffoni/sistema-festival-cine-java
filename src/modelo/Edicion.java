package modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Edicion {

    private int nroEdicion;
    private String ciudad;
    private String fecha;
    private Festival festival;
    private Set<Funcion> funciones;

    public Edicion(int nroEdicion, String ciudad, String fecha, Festival festival) {
        this.nroEdicion = nroEdicion;
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.festival = festival;
        this.funciones = new HashSet<>();
    }

    public boolean agregarFuncion (Funcion funcion) {
        return funciones.add(funcion);
    }

    public int getNroEdicion() {
        return nroEdicion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public Festival getFestival() {
        return festival;
    }

    public Set<Funcion> getFunciones() {
        return funciones;
    }

    public void setNroEdicion(int nroEdicion) {
        this.nroEdicion = nroEdicion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public void setFunciones(Set<Funcion> funciones) {
        this.funciones = funciones;
    }
}
