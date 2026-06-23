package modelo;
import java.util.Date;

public abstract class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private String fechaNacimiento;
    private String sexo;

    public Persona(String nombre, String apellido, int edad, String fechaNacimiento, String sexo) {
        this.sexo = sexo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Persona persona = (Persona) o;

        return nombre.equals(persona.nombre) && apellido.equals(persona.apellido) && fechaNacimiento.equals(persona.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode() + apellido.hashCode() + fechaNacimiento.hashCode();
    }
}
