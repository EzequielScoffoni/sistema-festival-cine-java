package pesistencia;

import modelo.Butaca;
import modelo.Entrada;
import modelo.Espectador;
import modelo.Funcion;

import java.io.*;
import java.util.Iterator;
import java.util.Set;

public class EntradaCSV {

    public void guardarEntrada(Entrada entrada) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("entradas.csv", true));
            bw.write(entrada.getEspectador().getDni() + ";" + entrada.getFuncion().getPelicula().getTitulo() + ";" + entrada.getFuncion().getFechaFuncion() + ";" + entrada.getFuncion().getHoraFuncion() + ";" + entrada.getButaca().getNroButaca());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar la entrada: " + e.getMessage());
        }
    }
    public void leerEntradas() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("entradas.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(
                    "Error al leer el archivo: "
                            + e.getMessage()
            );
        }
    }
    public void cargarEntradas(Set<Entrada> entradas, Set<Espectador> espectadores, Set<Funcion> funciones) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("entradas.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                int dni = Integer.parseInt(datos[0]);
                String titulo = datos[1];
                String fecha = datos[2];
                String hora = datos[3];
                int nroButaca = Integer.parseInt(datos[4]);
                Espectador espectadorEncontrado = null;
                for (Iterator<Espectador> i = espectadores.iterator(); i.hasNext();) {
                    Espectador espectadorActual = i.next();
                    if (espectadorActual.getDni() == dni) {
                        espectadorEncontrado = espectadorActual;
                        break;
                    }
                }
                Funcion funcionEncontrada = null;
                for (Iterator<Funcion> i = funciones.iterator(); i.hasNext();) {
                    Funcion funcionActual = i.next();
                    if (funcionActual.getPelicula().getTitulo().equals(titulo) && funcionActual.getFechaFuncion().equals(fecha) && funcionActual.getHoraFuncion().equals(hora)) {
                        funcionEncontrada = funcionActual;
                        break;
                    }
                }
                Butaca butacaEncontrada = null;
                if (funcionEncontrada != null) {
                    for (Iterator<Butaca> i = funcionEncontrada.getSala().getButacas().iterator(); i.hasNext();) {
                        Butaca butacaActual = i.next();
                        if (butacaActual.getNroButaca() == nroButaca) {
                            butacaEncontrada = butacaActual;
                            break;
                        }
                    }
                }
                if (espectadorEncontrado != null && funcionEncontrada != null && butacaEncontrada != null) {
                    Entrada entrada = new Entrada(espectadorEncontrado, funcionEncontrada, butacaEncontrada);
                    entradas.add(entrada);
                    funcionEncontrada.getEntradas().add(entrada);
                    butacaEncontrada.seleccionarButaca();
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }

    }

}
