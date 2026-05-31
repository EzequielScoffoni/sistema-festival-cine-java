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

    public void asignarPuntaje (int puntaje) {
        if ((puntaje > 0) && (puntaje <= 10) ){
            this.puntaje = puntaje;
        } else {
            System.out.println("Se genero un error en el puntaje.");
        }
    }

    public boolean registrarEvaluacion () {
        if (puntaje > 0 && puntaje <= 10){
            return true;
        }
        return false;
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
