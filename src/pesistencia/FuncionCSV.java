package pesistencia;
import modelo.Funcion;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

}
