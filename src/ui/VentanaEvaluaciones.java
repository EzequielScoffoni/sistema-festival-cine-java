package ui;

import javax.swing.*;
import java.awt.*;

public class VentanaEvaluaciones extends JFrame {

    public VentanaEvaluaciones () {

        setTitle("Sistema Festival de Cine");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("Gestion de evaluaciones");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelMenu = new JPanel();
        JButton botonEvaluacion = new JButton("Registrar evaluacion");
        JButton botonPromedio = new JButton("Calcular promedio pelicula");
        JButton botonPeliculaGanadora = new JButton("Mostrar pelicula ganadora");

        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));

        panelTitulo.add(titulo);
        panelMenu.add(botonEvaluacion);
        panelMenu.add(botonPromedio);
        panelMenu.add(botonPeliculaGanadora);

        add(panelTitulo, BorderLayout.NORTH);
        add(panelMenu, BorderLayout.WEST);
        setVisible(true);

    }

}
