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

    public Espectador getEspectador() {
        return espectador;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public Butaca getButaca() {
        return butaca;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }
}
