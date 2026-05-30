package modelo;

public class Evaluacion {

    private int puntaje;
    private Pelicula pelicula;
    private Jurado jurado;

    public Evaluacion(int puntaje, Pelicula pelicula, Jurado jurado) {
        this.puntaje = puntaje;
        this.pelicula = pelicula;
        this.jurado = jurado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Jurado getJurado() {
        return jurado;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setJurado(Jurado jurado) {
        this.jurado = jurado;
    }
}
