package modelo;

import java.util.Date;

public class Jurado extends Persona {

    public Jurado(String nombre, String apellido, int edad, String fechaNacimiento, String sexo) {
        super(nombre, apellido, edad, fechaNacimiento, sexo);
    }

    public boolean hacerEvaluacion (Evaluacion evaluacion) {
        if (evaluacion.registrarEvaluacion()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Jurado jurado = (Jurado) o;

        if (!getNombre().equals(jurado.getNombre())) {
            return false;
        } else {
            return getApellido().equals(jurado.getApellido());
        }
    }
    @Override
    public int hashCode() {
        return getNombre().hashCode() + getApellido().hashCode();
    }

}
