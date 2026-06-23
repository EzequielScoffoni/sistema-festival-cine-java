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

    @Override
    public String toString() {
        return tipoCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Categoria categoria = (Categoria) o;

        return tipoCategoria.equals(categoria.tipoCategoria);
    }

    @Override
    public int hashCode() {
        return tipoCategoria.hashCode();
    }

}
