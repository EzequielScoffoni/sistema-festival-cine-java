package ui;

import javax.swing.*;
import java.awt.*;

public class VentanaFunciones extends JFrame {

    public VentanaFunciones () {

        setTitle("Sistema Festival de Cine");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("Gestion de funciones");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelMenu = new JPanel();
        JButton botonProgramarFuncion = new JButton("Programar funcion");
        JButton botonDisponibilidad = new JButton("Verificar disponibilidad");
        JButton botonMostrarFunciones = new JButton("Mostrar funciones");
        JButton botonOcupacion = new JButton("Consultar ocupacion");
        JButton botonPorcentajeOcupacion = new JButton("Consultar porcentaje de ocupacion");

        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));

        panelTitulo.add(titulo);
        panelMenu.add(botonProgramarFuncion);
        panelMenu.add(botonDisponibilidad);
        panelMenu.add(botonMostrarFunciones);
        panelMenu.add(botonOcupacion);
        panelMenu.add(botonPorcentajeOcupacion);

        add(panelTitulo, BorderLayout.NORTH);
        add(panelMenu, BorderLayout.WEST);
        setVisible(true);

    }

}
