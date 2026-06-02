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

}
