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

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPromociones(Set<Promocion> promociones) {
        this.promociones = promociones;
    }
}
