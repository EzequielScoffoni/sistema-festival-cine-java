package modelo;

import java.util.Objects;

public class Entrada {

    private Espectador espectador;
    private Funcion funcion;
    private Butaca butaca;

    public Entrada(Espectador espectador, Funcion funcion, Butaca butaca) {
        this.espectador = espectador;
        this.funcion = funcion;
        this.butaca = butaca;
    }

    public boolean validarEntrada () {
        if (funcion.verificarDisponibilidad() && butaca.verificarDisponibilidad()) {
            return true;
        }
        return false;
    }

    public boolean generarEntrada () {
        if (validarEntrada()) {
            butaca.seleccionarButaca();
            return true;
        }
        return false;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public Butaca getButaca() {
        return butaca;
    }

    @Override
    public String toString() {
        return espectador.getNombre() + " " + espectador.getApellido() + " - " + funcion.getPelicula().getTitulo();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Entrada entrada = (Entrada) o;

        if (!funcion.equals(entrada.funcion)) {
            return false;
        }

        if (!butaca.equals(entrada.butaca)) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(funcion, butaca);
    }
    public String obtenerInformacion() {
        return "Espectador: " + espectador.getNombre() + " " + espectador.getApellido() + "\nPelícula: " + funcion.getPelicula().getTitulo() + "\nFecha: " + funcion.getFechaFuncion() + "\nHora: " + funcion.getHoraFuncion() + "\nButaca: " + butaca.getNroButaca();
    }

}
