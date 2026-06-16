package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        setTitle("Sistema Festival de Cine");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("Sistema de gestion de festivales de cine");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelMenu = new JPanel();
        JButton botonFestival = new JButton("Festival");
        JButton botonPeliculas = new JButton("Peliculas");
        JButton botonFunciones = new JButton("Funciones");
        JButton botonEntradas = new JButton("Entradas");
        JButton botonEvaluaciones = new JButton("Evaluaciones");
        JButton botonSalir = new JButton("Salir");

        botonFestival.addActionListener(e -> {
            new VentanaFestival();
        });
        botonPeliculas.addActionListener(e -> {
            new VentanaPeliculas();
        });
        botonFunciones.addActionListener(e -> {
            new VentanaFunciones();
        });
        botonEntradas.addActionListener(e -> {
            new VentanaEntradas();
        });
        botonEvaluaciones.addActionListener(e -> {
            new VentanaEvaluaciones();
        });

        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));

        panelTitulo.add(titulo);
        panelMenu.add(botonFestival);
        panelMenu.add(botonPeliculas);
        panelMenu.add(botonFunciones);
        panelMenu.add(botonEntradas);
        panelMenu.add(botonEvaluaciones);
        panelMenu.add(botonSalir);

        add(panelTitulo, BorderLayout.NORTH);
        add(panelMenu, BorderLayout.WEST);

        setVisible(true);

    }

}
