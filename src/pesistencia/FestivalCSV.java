package pesistencia;
import modelo.Festival;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class FestivalCSV {
    public void guardarFestival (Festival festival) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("festivales.csv", true));
            bw.write(festival.getNombreFestival());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el festival: " + e.getMessage());
        }
    }

    public void leerFestival () {
        try {
            BufferedReader br = new BufferedReader(new FileReader("festivales.csv"));
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public Set<Festival> cargarFestivales () {
        Set<Festival> festivales = new LinkedHashSet<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("festivales.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                Festival festival = new Festival(line);
                festivales.add(festival);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        return festivales;
    }

}
