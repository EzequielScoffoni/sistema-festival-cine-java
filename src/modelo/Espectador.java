package modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Espectador extends Persona {

    private int dni;
    private String email;
    private Set<Promocion> promociones;

    public Espectador(String nombre, String apellido, int edad, String fechaNacimiento, String sexo, int dni, String email) {
        super(nombre, apellido, edad, fechaNacimiento, sexo);
        this.dni = dni;
        this.email = email;
        this.promociones = new HashSet<>();
    }

    public boolean comprarEntrada (Entrada entrada) {
        if (entrada.generarEntrada()){
            return true;
        }
        return false;
    }

    public int getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public Set<Promocion> getPromociones() {
        return promociones;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Espectador espectador = (Espectador) o;

        if (dni != espectador.dni){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(dni);
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido() + " - DNI: " + dni;
    }

}
