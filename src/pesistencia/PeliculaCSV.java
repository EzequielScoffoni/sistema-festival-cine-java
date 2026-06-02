package pesistencia;
import modelo.Pelicula;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PeliculaCSV {

    public void guardarPelicula (Pelicula pelicula) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("peliculas.csv", true));
            bw.write(pelicula.getTitulo() + ";" + pelicula.getGenero() + ";" + pelicula.getDuracion());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar la pelicula: " + e.getMessage());
        }
    }

    public void leerPelicula () {
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
}
