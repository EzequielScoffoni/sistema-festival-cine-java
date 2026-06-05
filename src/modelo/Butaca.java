package modelo;

public class Butaca {

    private int nroButaca;
    private int nroFila;
    private boolean disponibilidad;

    public Butaca(int nroButaca, int nroFila, boolean disponibilidad) {
        this.nroButaca = nroButaca;
        this.nroFila = nroFila;
        this.disponibilidad = disponibilidad;
    }

    public boolean verificarDisponibilidad () {
        if (disponibilidad){
            return true;
        } else {
            return false;
        }
    }

    public boolean seleccionarButaca () {
        if (verificarDisponibilidad()){
            disponibilidad = false;
            return true;
        }
        return false;
    }

    public int getNroButaca() {
        return nroButaca;
    }

    public int getNroFila() {
        return nroFila;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

}
