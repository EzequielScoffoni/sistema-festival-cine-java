package pesistencia;

import modelo.Edicion;
import modelo.Festival;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EdicionCSV {

    public void guardarEdicion (Edicion edicion) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("ediciones.csv", true));
            bw.write(edicion.getNroEdicion() + ";" + edicion.getCiudad() + ";" + edicion.getFecha() + ";" + edicion.getFestival().getNombreFestival());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar la edición: " + e.getMessage());
        }
    }

    public void leerEdicion () {
        try {
            BufferedReader br = new BufferedReader(new FileReader("ediciones.csv"));
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void cargarEdiciones(Set<Festival> festivales) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("ediciones.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                int nroEdicion = Integer.parseInt(datos[0]);
                String ciudad = datos[1];
                String fecha = datos[2];
                String nombreFestival = datos[3];
                Festival festivalEncontrado = null;
                for (Iterator<Festival> i = festivales.iterator(); i.hasNext(); ) {
                    Festival festivalActual = i.next();
                    if (festivalActual.getNombreFestival().equals(nombreFestival)) {
                        festivalEncontrado = festivalActual;
                        break;
                    }
                }
                if (festivalEncontrado != null) {
                    Edicion edicion = new Edicion(nroEdicion, ciudad, fecha, festivalEncontrado);
                    festivalEncontrado.agregarEdicion(edicion);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }

}
