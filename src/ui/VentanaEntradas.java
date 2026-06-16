package ui;

import javax.swing.*;
import java.awt.*;

public class VentanaEntradas extends JFrame {

    public VentanaEntradas () {

        setTitle("Sistema Festival de Cine");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("Gestion de entradas");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelMenu = new JPanel();
        JButton botonEspectador = new JButton("Registrar espectador");
        JButton botonVentaEntrada = new JButton("Vender entrada");
        JButton botonMostrarEntradas = new JButton("Mostrar entradas");

        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));

        panelTitulo.add(titulo);
        panelMenu.add(botonEspectador);
        panelMenu.add(botonVentaEntrada);
        panelMenu.add(botonMostrarEntradas);

        add(panelTitulo, BorderLayout.NORTH);
        add(panelMenu, BorderLayout.WEST);
        setVisible(true);

    }

}
