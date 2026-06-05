package modelo;

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

}
