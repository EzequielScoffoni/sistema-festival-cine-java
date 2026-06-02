package pesistencia;
import modelo.Espectador;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
}
