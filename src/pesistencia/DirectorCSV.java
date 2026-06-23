package pesistencia;

import modelo.Director;
import modelo.Pelicula;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class DirectorCSV {

    public void guardarDirector (Director director) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("directores.csv", true));
            bw.write(director.getNombre() + ";" + director.getApellido() + ";" + director.getEdad() + ";" + director.getFechaNacimiento() + ";" + director.getSexo());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el director: " + e.getMessage());
        }
    }

    public void leerDirectores() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("directores.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public Set<Director> cargarDirectores() {
        Set<Director> directores = new LinkedHashSet<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("directores.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                String nombre = datos[0];
                String apellido = datos[1];
                int edad = Integer.parseInt(datos[2]);
                String fechaNacimiento = datos[3];
                String sexo = datos[4];

                Director director = new Director(nombre, apellido, edad, fechaNacimiento, sexo);

                directores.add(director);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        return directores;
    }

}
