package modelo;

import java.util.Date;

public class Espectador extends Persona {

    private int dni;
    private String email;

    public Espectador(String nombre, String apellido, int edad, Date fechaNacimiento, String sexo, int dni, String email) {
        super(nombre, apellido, edad, fechaNacimiento, sexo);
        this.dni = dni;
        this.email = email;
    }

    public int getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
