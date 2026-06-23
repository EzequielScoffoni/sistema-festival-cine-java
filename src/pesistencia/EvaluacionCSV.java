package pesistencia;

import modelo.Evaluacion;
import modelo.Jurado;
import modelo.Pelicula;

import java.io.*;
import java.util.Iterator;
import java.util.Set;

public class EvaluacionCSV {

    public void guardarEvaluacion(Evaluacion evaluacion) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("evaluaciones.csv", true));
            bw.write(evaluacion.getPuntaje() + ";" + evaluacion.getPelicula().getTitulo() + ";" + evaluacion.getJurado().getNombre() + ";" + evaluacion.getJurado().getApellido());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar la evaluación: " + e.getMessage());
        }
    }
    public void cargarEvaluaciones(Set<Evaluacion> evaluaciones, Set<Pelicula> peliculas, Set<Jurado> jurados) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("evaluaciones.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                int puntaje = Integer.parseInt(datos[0]);
                String titulo = datos[1];
                String nombreJurado = datos[2];
                String apellidoJurado = datos[3];
                Pelicula peliculaEncontrada = null;
                for (Iterator<Pelicula> i = peliculas.iterator(); i.hasNext();) {
                    Pelicula peliculaActual = i.next();
                    if (peliculaActual.getTitulo().equals(titulo)) {
                        peliculaEncontrada = peliculaActual;
                        break;
                    }
                }
                Jurado juradoEncontrado = null;
                for (Iterator<Jurado> i = jurados.iterator(); i.hasNext();) {
                    Jurado juradoActual = i.next();
                    if (juradoActual.getNombre().equals(nombreJurado) && juradoActual.getApellido().equals(apellidoJurado)) {
                        juradoEncontrado = juradoActual;
                        break;
                    }
                }
                if (peliculaEncontrada != null && juradoEncontrado != null) {
                    Evaluacion evaluacion = new Evaluacion(puntaje, peliculaEncontrada, juradoEncontrado);
                    evaluaciones.add(evaluacion);
                    peliculaEncontrada.agregarEvaluacion(evaluacion);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }
}
