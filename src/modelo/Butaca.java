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

    @Override
    public String toString() {
        return "Butaca " + nroButaca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Butaca butaca = (Butaca) o;

        if (nroButaca != butaca.nroButaca) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(nroButaca);
    }

}
