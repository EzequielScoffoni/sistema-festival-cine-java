package pesistencia;

import modelo.Butaca;
import modelo.Sala;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SalaCSV {

    public void guardarSala(Sala sala) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("salas.csv", true));

            bw.write(sala.getNroSala() + ";" + sala.getButacas().size());

            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.out.println("Error al guardar la sala: " + e.getMessage());
        }
    }
    public void leerSala() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("salas.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public Set<Sala> cargarSalas() {

        Set<Sala> salas = new LinkedHashSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("salas.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                int nroSala = Integer.parseInt(datos[0]);
                int cantidadButacas = Integer.parseInt(datos[1]);
                Set<Butaca> butacas = new HashSet<>();
                for (int i = 1; i <= cantidadButacas; i++) {
                    Butaca butaca = new Butaca(i, 1, true);
                    butacas.add(butaca);
                }
                Sala sala = new Sala(nroSala, butacas);
                salas.add(sala);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        return salas;
    }
}
