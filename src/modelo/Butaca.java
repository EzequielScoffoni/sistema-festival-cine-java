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

    public int getNroButaca() {
        return nroButaca;
    }

    public int getNroFila() {
        return nroFila;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setNroButaca(int nroButaca) {
        this.nroButaca = nroButaca;
    }

    public void setNroFila(int nroFila) {
        this.nroFila = nroFila;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
