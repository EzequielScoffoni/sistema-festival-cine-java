package pesistencia;
import modelo.Espectador;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class EspectadorCSV {

    public void guardarEspectador (Espectador espectador) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("espectadores.csv", true));
            bw.write(espectador.getNombre() + ";" + espectador.getApellido() + ";" + espectador.getEdad() + ";" + espectador.getFechaNacimiento() + ";" + espectador.getSexo() + ";" + espectador.getDni() + ";" + espectador.getEmail());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar al espectador: " + e.getMessage());
        }
    }

    public void leerEspectador () {
        try {
            BufferedReader br = new BufferedReader(new FileReader("espectadores.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public Set<Espectador> cargarEspectadores() {
        Set<Espectador> espectadores = new LinkedHashSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("espectadores.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                String nombre = datos[0];
                String apellido = datos[1];
                int edad = Integer.parseInt(datos[2]);
                String fechaNacimiento = datos[3];
                String sexo = datos[4];
                int dni = Integer.parseInt(datos[5]);
                String email = datos[6];

                Espectador espectador = new Espectador(nombre, apellido, edad, fechaNacimiento, sexo, dni, email);
                espectadores.add(espectador);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        return espectadores;
    }
}
