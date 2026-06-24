package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        setTitle("Sistema Festival de Cine");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("Sistema de gestion de festivales de cine");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel subtitulo = new JLabel("Seleccione un módulo para comenzar: ");
        subtitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel panelMenu = new JPanel();
        JButton botonFestival = new JButton("Festival");
        JButton botonPeliculas = new JButton("Peliculas");
        JButton botonFunciones = new JButton("Funciones");
        JButton botonEntradas = new JButton("Entradas");
        JButton botonEvaluaciones = new JButton("Evaluaciones");
        JButton botonSalir = new JButton("Salir");

        Dimension tamañoBoton = new Dimension(130, 35);

        JButton[] botones = {botonFestival, botonPeliculas, botonFunciones, botonEntradas, botonEvaluaciones, botonSalir};

        for (int i = 0; i < botones.length; i++) {
            botones[i].setMaximumSize(
                    tamañoBoton
            );
        }

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
        botonSalir.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(
                            null, "¿Está seguro que desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION
                    );
            if (opcion == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));

        panelMenu.add(subtitulo);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 14));
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panelTitulo.add(Box.createVerticalStrut(60));
        panelTitulo.add(titulo);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(botonFestival);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(botonPeliculas);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(botonFunciones);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(botonEntradas);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(botonEvaluaciones);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(botonSalir);

        add(panelTitulo, BorderLayout.NORTH);
        add(panelMenu, BorderLayout.WEST);


        setVisible(true);

    }

}
