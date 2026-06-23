package pesistencia;
import modelo.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FuncionCSV {

    public void guardarFuncion (Funcion funcion) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("funciones.csv", true));
            bw.write(funcion.getFechaFuncion() + ";" + funcion.getHoraFuncion() + ";" + funcion.getPelicula().getTitulo() + ";" + funcion.getSala().getNroSala() + ";" + funcion.getEdicion().getNroEdicion());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar la funcion: " + e.getMessage());
        }
    }

    public void leerFuncion () {
        try {
            BufferedReader br = new BufferedReader(new FileReader("funciones.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public void cargarFunciones(Set<Funcion> funciones, Set<Pelicula> peliculas, Set<Sala> salas, Set<Festival> festivales) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("funciones.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");

                String fecha = datos[0];
                String hora = datos[1];
                String tituloPelicula = datos[2];
                int nroSala = Integer.parseInt(datos[3]);
                int nroEdicion = Integer.parseInt(datos[4]);
                Pelicula peliculaEncontrada = null;
                for (Iterator<Pelicula> i = peliculas.iterator(); i.hasNext();) {
                    Pelicula peliculaActual = i.next();
                    if (peliculaActual.getTitulo().equals(tituloPelicula)) {
                        peliculaEncontrada = peliculaActual;
                        break;
                    }
                }
                Sala salaEncontrada = null;
                for (Iterator<Sala> i = salas.iterator(); i.hasNext();) {
                    Sala salaActual = i.next();
                    if (salaActual.getNroSala() == nroSala) {
                        salaEncontrada = salaActual;
                        break;
                    }
                }
                Edicion edicionEncontrada = null;
                for (Iterator<Festival> i = festivales.iterator(); i.hasNext();) {
                    Festival festivalActual = i.next();
                    for (Iterator<Edicion> j = festivalActual.getEdicion().iterator(); j.hasNext();) {
                        Edicion edicionActual = j.next();
                        if (edicionActual.getNroEdicion() == nroEdicion) {
                            edicionEncontrada = edicionActual;
                            break;
                        }
                    }
                    if (edicionEncontrada != null) {
                        break;
                    }
                }
                if (peliculaEncontrada != null && salaEncontrada != null && edicionEncontrada != null) {
                    Funcion funcion = new Funcion(fecha, hora, peliculaEncontrada, edicionEncontrada, salaEncontrada, new HashSet<>());
                    funciones.add(funcion);
                    salaEncontrada.asignarFuncion(funcion);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }

}
