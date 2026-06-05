package modelo;

public class Categoria {

    private String tipoCategoria;
    private String descripcion;

    public Categoria(String tipoCategoria, String descripcion) {
        this.tipoCategoria = tipoCategoria;
        this.descripcion = descripcion;
    }

    public String mostrarCategoria () {
        return "La categoria es: " + " " + tipoCategoria + "Su descripcion: " + " " + descripcion;
    }

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
