package modelo;

public class Premio {

    private String nombrePremio;
    private int anio;
    private String descripcion;
    private Categoria categoria;

    public Premio(String nombrePremio, int anio, String descripcion, Categoria categoria) {
        this.nombrePremio = nombrePremio;
        this.anio = anio;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public String getNombrePremio() {
        return nombrePremio;
    }

    public int getAnio() {
        return anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setNombrePremio(String nombrePremio) {
        this.nombrePremio = nombrePremio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
