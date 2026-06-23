package pesistencia;

import modelo.Actor;
import modelo.Categoria;
import modelo.Pelicula;

import java.io.*;
import java.util.Iterator;
import java.util.Set;

public class ActorPeliculaCSV {

    public void guardarActorPelicula(Pelicula pelicula, Actor actor) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("peliculas_actores.csv", true));
            bw.write(pelicula.getTitulo() + ";" + actor.getNombre() + ";" + actor.getApellido());

            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.out.println("Error al guardar la asociación: " + e.getMessage());
        }
    }

    public void cargarActoresPeliculas(Set<Pelicula> peliculas, Set<Actor> actores) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("peliculas_actores.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                String tituloPelicula = datos[0];
                String nombreActor = datos[1];
                String apellidoActor = datos[2];
                Pelicula peliculaEncontrada = null;
                for (Iterator<Pelicula> i = peliculas.iterator(); i.hasNext(); ) {
                    Pelicula peliculaActual = i.next();
                    if (peliculaActual.getTitulo().equals(tituloPelicula)) {
                        peliculaEncontrada = peliculaActual;
                        break;
                    }
                }
                Actor actorEncontrado = null;
                for (Iterator<Actor> i = actores.iterator(); i.hasNext(); ) {
                    Actor actorActual = i.next();
                    if (actorActual.getNombre().equals(nombreActor) && actorActual.getApellido().equals(apellidoActor)) {
                        actorEncontrado = actorActual;
                        break;
                    }
                }

                if (peliculaEncontrada != null && actorEncontrado != null) {
                    peliculaEncontrada.agregarActor(actorEncontrado);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }

}
