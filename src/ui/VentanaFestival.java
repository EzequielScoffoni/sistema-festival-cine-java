package ui;

import javax.swing.*;
import java.awt.*;

public class VentanaFestival extends JFrame {

    public VentanaFestival () {
        setTitle("Sistema Festival de Cine");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("Gestion de festivales");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelMenu = new JPanel();
        JButton botonCrearFestival = new JButton("Crear festival");
        JButton botonCrearEdicion = new JButton("Crear edición");
        JButton botonMostrarEdiciones = new JButton("Mostrar ediciones");

        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));

        panelTitulo.add(titulo);
        panelMenu.add(botonCrearFestival);
        panelMenu.add(botonCrearEdicion);
        panelMenu.add(botonMostrarEdiciones);

        add(panelTitulo, BorderLayout.NORTH);
        add(panelMenu, BorderLayout.WEST);
        setVisible(true);

    }

}
