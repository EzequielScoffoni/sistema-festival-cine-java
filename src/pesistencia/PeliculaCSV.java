package pesistencia;
import modelo.Director;
import modelo.Edicion;
import modelo.Festival;
import modelo.Pelicula;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class PeliculaCSV {

    public void guardarPelicula(Pelicula pelicula) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("peliculas.csv", true));
            bw.write(pelicula.getTitulo() + ";" + pelicula.getGenero() + ";" + pelicula.getDuracion() + ";" + pelicula.getDirector().getNombre() + ";" + pelicula.getDirector().getApellido() + ";" + pelicula.getDirector().getEdad() + ";" + pelicula.getDirector().getFechaNacimiento() + ";" + pelicula.getDirector().getSexo());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar la pelicula: " + e.getMessage());
        }
    }

    public void leerPelicula() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("peliculas.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public Set<Pelicula> cargarPeliculas() {
        Set<Pelicula> peliculas = new LinkedHashSet<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("peliculas.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                String titulo = datos[0];
                String genero = datos[1];
                int duracion = Integer.parseInt(datos[2]);
                String nombre = datos[3];
                String apellido = datos[4];
                int edad = Integer.parseInt(datos[5]);
                String fechaNacimiento = datos[6];
                String sexo = datos[7];

                Director director = new Director(nombre, apellido, edad, fechaNacimiento, sexo);
                Pelicula pelicula = new Pelicula(titulo, genero, duracion, director);
                peliculas.add(pelicula);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        return peliculas;
    }
}
