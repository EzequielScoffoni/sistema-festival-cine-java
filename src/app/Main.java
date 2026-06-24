package app;
import modelo.*;
import pesistencia.FuncionCSV;
import pesistencia.PeliculaCSV;

import java.util.HashSet;

import servicios.SistemaFestival;
import ui.Consola;
import ui.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {

        /*Consola consola = new Consola();
        consola.iniciar();*/

        SistemaFestival.cargarDatos();

        new VentanaPrincipal();

    }
}





