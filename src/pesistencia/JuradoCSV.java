package pesistencia;

import modelo.Jurado;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class JuradoCSV {

    public void guardarJurado(Jurado jurado) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("jurados.csv", true));
            bw.write(jurado.getNombre() + ";" + jurado.getApellido() + ";" + jurado.getEdad() + ";" + jurado.getFechaNacimiento() + ";" + jurado.getSexo());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el jurado: " + e.getMessage());
        }
    }

    public Set<Jurado> cargarJurados() {
        Set<Jurado> jurados = new LinkedHashSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("jurados.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                String nombre = datos[0];
                String apellido = datos[1];
                int edad = Integer.parseInt(datos[2]);
                String fecha = datos[3];
                String sexo = datos[4];
                Jurado jurado = new Jurado(nombre, apellido, edad, fecha, sexo);
                jurados.add(jurado);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        return jurados;
    }

}
