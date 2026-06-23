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

    public String obtenerInformacion() {
        return "Película: " + pelicula.getTitulo() + "\nJurado: " + jurado + "\nPuntaje: " + puntaje;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Evaluacion evaluacion = (Evaluacion) o;

        if (!pelicula.equals(evaluacion.pelicula)) {
            return false;
        } else {
            return jurado.equals(evaluacion.jurado);
        }
    }
    @Override
    public int hashCode() {
        return pelicula.hashCode() + jurado.hashCode();
    }

}
