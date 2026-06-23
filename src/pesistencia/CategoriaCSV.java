package pesistencia;

import modelo.Categoria;
import modelo.Edicion;
import modelo.Festival;
import modelo.Pelicula;

import java.io.*;
import java.util.Iterator;
import java.util.Set;

public class CategoriaCSV {

    public void guardarCategoria (Categoria categoria, Pelicula pelicula) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("categorias.csv", true));
            bw.write(categoria.getTipoCategoria() + ";" + categoria.getDescripcion() + ";" + pelicula.getTitulo());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar la categoria: " + e.getMessage());
        }
    }

    public void leerCategoria () {
        try {
            BufferedReader br = new BufferedReader(new FileReader("categorias.csv"));
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void cargarCategorias(Set<Pelicula> peliculas) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("categorias.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                String categoriaPelicula = datos[0];
                String descripcionPelicula = datos[1];
                String nombrePelicula = datos[2];
                Pelicula peliculaEncontrada = null;
                for (Iterator<Pelicula> i = peliculas.iterator(); i.hasNext(); ) {
                    Pelicula peliculaActual = i.next();
                    if (peliculaActual.getTitulo().equals(nombrePelicula)) {
                        peliculaEncontrada = peliculaActual;
                        break;
                    }
                }
                if (peliculaEncontrada != null) {
                    Categoria categoria = new Categoria(categoriaPelicula, descripcionPelicula);
                    peliculaEncontrada.agregarCategoria(categoria);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }


}
