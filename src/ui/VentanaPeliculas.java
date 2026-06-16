package ui;

import javax.swing.*;
import java.awt.*;

public class VentanaPeliculas extends JFrame {

    public VentanaPeliculas () {
        setTitle("Sistema Festival de Cine");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("Gestion de peliculas");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelMenu = new JPanel();
        JButton botonRegistrarPelicula = new JButton("Registrar pelicula");
        JButton botonRegistrarDirector = new JButton("Registrar director");
        JButton botonRegistrarActor = new JButton("Registrar actor");
        JButton botonAsociarCat = new JButton("Asociar categoria");
        JButton botonMostrarPeliculas = new JButton("Mostrar peliculas");

        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));

        panelTitulo.add(titulo);
        panelMenu.add(botonRegistrarPelicula);
        panelMenu.add(botonRegistrarDirector);
        panelMenu.add(botonRegistrarActor);
        panelMenu.add(botonAsociarCat);
        panelMenu.add(botonMostrarPeliculas);

        add(panelTitulo, BorderLayout.NORTH);
        add(panelMenu, BorderLayout.WEST);
        setVisible(true);
    }

}
