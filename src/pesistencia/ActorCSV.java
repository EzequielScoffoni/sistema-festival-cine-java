package pesistencia;

import modelo.Actor;
import modelo.Director;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class ActorCSV {

    public void guardarActor (Actor actor) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("actores.csv", true));
            bw.write(actor.getNombre() + ";" + actor.getApellido() + ";" + actor.getEdad() + ";" + actor.getFechaNacimiento() + ";" + actor.getSexo());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el actor: " + e.getMessage());
        }
    }

    public void leerActores() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("actores.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public Set<Actor> cargarActores() {
        Set<Actor> actores = new LinkedHashSet<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("actores.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                String nombre = datos[0];
                String apellido = datos[1];
                int edad = Integer.parseInt(datos[2]);
                String fechaNacimiento = datos[3];
                String sexo = datos[4];

                Actor actor = new Actor(nombre, apellido, edad, fechaNacimiento, sexo);

                actores.add(actor);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        return actores;
    }

}
