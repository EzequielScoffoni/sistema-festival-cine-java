package ui;

import modelo.Actor;
import modelo.Evaluacion;
import modelo.Jurado;
import modelo.Pelicula;
import pesistencia.EvaluacionCSV;
import pesistencia.JuradoCSV;
import servicios.SistemaFestival;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class VentanaEvaluaciones extends JFrame {

    private JPanel panelFormulario;
    private JuradoCSV juradoCSV;
    private Set<Jurado> jurados;
    private EvaluacionCSV evaluacionCSV;
    private Set<Evaluacion> evaluaciones;
    private Set<Pelicula> peliculas;

    public VentanaEvaluaciones () {

        setTitle("Sistema Festival de Cine");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("Gestion de evaluaciones");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelMenu = new JPanel();
        JButton botonJurado = new JButton("Registrar jurado");
        JButton botonEvaluacion = new JButton("Registrar evaluacion");
        JButton botonPromedio = new JButton("Calcular promedio pelicula");
        JButton botonPeliculaGanadora = new JButton("Mostrar pelicula ganadora");

        Dimension tamañoBoton = new Dimension(200, 35);

        JButton[] botones = {botonJurado, botonEvaluacion, botonPromedio, botonPeliculaGanadora};

        for (int i = 0; i < botones.length; i++) {
            botones[i].setMaximumSize(
                    tamañoBoton
            );
        }

        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));

        panelFormulario = new JPanel();

        panelTitulo.add(Box.createVerticalStrut(60));
        panelTitulo.add(titulo);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(botonJurado);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(botonEvaluacion);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(botonPromedio);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(botonPeliculaGanadora);

        juradoCSV = new JuradoCSV();
        evaluacionCSV = new EvaluacionCSV();

        jurados = SistemaFestival.getJurados();
        evaluaciones = SistemaFestival.getEvaluaciones();
        peliculas = SistemaFestival.getPeliculas();

        botonJurado.addActionListener(e -> {
            System.out.println("Boton crear jurado presionado");
            panelFormulario.removeAll();

            JLabel nombreJurado = new JLabel("Nombre del jurado: ");
            JTextField datoNombreJurado = new JTextField(20);
            JLabel apellidoJurado = new JLabel("Apellido del jurado: ");
            JTextField datoApellidoJurado = new JTextField(20);
            JLabel edadJurado = new JLabel("Edad del jurado: ");
            JTextField datoEdadJurado = new JTextField(20);
            JLabel fechaNacimientoJurado = new JLabel("Fecha de nacimiento del jurado: ");
            JTextField datoFechaNacimiento = new JTextField(20);
            JLabel sexoJurado = new JLabel("Sexo del jurado: ");
            JTextField datoSexo = new JTextField(20);
            JButton botonGuardar = new JButton("Guardar");
            JButton botonCancelar = new JButton("Cancelar");
            panelFormulario.add(nombreJurado);
            panelFormulario.add(datoNombreJurado);
            panelFormulario.add(apellidoJurado);
            panelFormulario.add(datoApellidoJurado);
            panelFormulario.add(edadJurado);
            panelFormulario.add(datoEdadJurado);
            panelFormulario.add(fechaNacimientoJurado);
            panelFormulario.add(datoFechaNacimiento);
            panelFormulario.add(sexoJurado);
            panelFormulario.add(datoSexo);
            panelFormulario.add(botonGuardar);
            panelFormulario.add(botonCancelar);

            botonGuardar.addActionListener(e1 -> {
                try {
                    String nombreJ = datoNombreJurado.getText();
                    String apellidoJ = datoApellidoJurado.getText();
                    String fechaNacimientoJ = datoFechaNacimiento.getText();
                    String sexoJ = datoSexo.getText();
                    if (nombreJ.isBlank() || apellidoJ.isBlank() || fechaNacimientoJ.isBlank() || sexoJ.isBlank()){
                        JOptionPane.showMessageDialog(
                                null, "Todos los campos deben estar completos."
                        );
                        return;
                    }

                    int edadJ = Integer.parseInt(datoEdadJurado.getText());

                    if (edadJ <= 0) {
                        JOptionPane.showMessageDialog(
                                null, "La edad deben ser mayor a 0."
                        );
                        return;
                    }
                    Jurado jurado = new Jurado(nombreJ, apellidoJ, edadJ, fechaNacimientoJ, sexoJ);

                    if (jurados.add(jurado)) {
                        juradoCSV.guardarJurado(jurado);
                        JOptionPane.showMessageDialog(
                                null, "Jurado registrado correctamente."
                        );
                        datoNombreJurado.setText("");
                        datoApellidoJurado.setText("");
                        datoEdadJurado.setText("");
                        datoFechaNacimiento.setText("");
                        datoSexo.setText("");
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "El jurado ya existe"
                        );
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "La edad del jurado debe ser numérico."
                    );
                }
            });

            botonCancelar.addActionListener(e1 -> {
                int opcion = JOptionPane.showConfirmDialog(
                        null,"¿Estas seguro que deseas cancelar?","Confirmar cancelación", JOptionPane.YES_NO_OPTION
                );
                if (opcion == JOptionPane.YES_OPTION) {
                    panelFormulario.removeAll();
                    panelFormulario.revalidate();
                    panelFormulario.repaint();
                }
            });

            panelFormulario.revalidate();
            panelFormulario.repaint();
        });

        botonEvaluacion.addActionListener(e -> {
            if (peliculas.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Debe registrar una película primero."
                );
                return;
            }

            if (jurados.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Debe registrar un jurado primero."
                );
                return;
            }
            panelFormulario.removeAll();

            JComboBox<Pelicula> comboPelicula = new JComboBox<>();
            for (Iterator<Pelicula> i = peliculas.iterator(); i.hasNext();) {
                comboPelicula.addItem(i.next());
            }
            JComboBox<Jurado> comboJurado = new JComboBox<>();
            for (Iterator<Jurado> i = jurados.iterator(); i.hasNext();) {
                comboJurado.addItem(i.next());
            }
            JLabel puntaje = new JLabel("Puntaje (1-10): ");
            JTextField datoPuntaje = new JTextField(5);
            JButton botonGuardar = new JButton("Guardar");
            JButton botonCancelar = new JButton("Cancelar");
            panelFormulario.add(new JLabel("Película: "));
            panelFormulario.add(comboPelicula);
            panelFormulario.add(new JLabel("Jurado: "));
            panelFormulario.add(comboJurado);
            panelFormulario.add(puntaje);
            panelFormulario.add(datoPuntaje);
            panelFormulario.add(botonGuardar);
            panelFormulario.add(botonCancelar);

            botonGuardar.addActionListener(e1 -> {
                try {
                    int puntajeP = Integer.parseInt(datoPuntaje.getText());
                    if (puntajeP <= 0 || puntajeP > 10) {
                        JOptionPane.showMessageDialog(
                                null, "El puntaje debe estar entre 1 y 10."
                        );
                        return;
                    }
                    Pelicula pelicula = (Pelicula) comboPelicula.getSelectedItem();
                    Jurado jurado = (Jurado) comboJurado.getSelectedItem();
                    Evaluacion evaluacion = new Evaluacion(puntajeP, pelicula, jurado);
                    if (jurado.hacerEvaluacion(evaluacion)) {
                        if (pelicula.agregarEvaluacion(evaluacion)) {
                            evaluaciones.add(evaluacion);
                            evaluacionCSV.guardarEvaluacion(evaluacion);
                            JOptionPane.showMessageDialog(
                                    null, "Evaluación registrada correctamente."
                            );
                            datoPuntaje.setText("");
                            comboPelicula.setSelectedIndex(0);
                            comboJurado.setSelectedIndex(0);
                        } else {
                            JOptionPane.showMessageDialog(
                                    null, "El jurado ya evaluó esta película."
                            );
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null, "El puntaje debe ser numérico.");
                }
            });

            botonCancelar.addActionListener(e1 -> {
                int opcion = JOptionPane.showConfirmDialog(
                        null,"¿Estas seguro que deseas cancelar?","Confirmar cancelación", JOptionPane.YES_NO_OPTION
                );
                if (opcion == JOptionPane.YES_OPTION) {
                    panelFormulario.removeAll();
                    panelFormulario.revalidate();
                    panelFormulario.repaint();
                }
            });

            panelFormulario.revalidate();
            panelFormulario.repaint();
        });

        botonPromedio.addActionListener(e -> {
            System.out.println("Boton promedio presionado");
            if (peliculas.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "No hay películas registradas."
                );
                return;
            }
            panelFormulario.removeAll();

            JComboBox<Pelicula> comboPelicula = new JComboBox<>();
            for (Iterator<Pelicula> i = peliculas.iterator(); i.hasNext();) {
                comboPelicula.addItem(i.next());
            }
            JButton botonObtener = new JButton("Obtener promedio");
            JButton botonCancelar = new JButton("Cancelar");
            panelFormulario.add(new JLabel("Película: "));
            panelFormulario.add(comboPelicula);
            panelFormulario.add(botonObtener);
            panelFormulario.add(botonCancelar);

            botonObtener.addActionListener(e1 -> {
                Pelicula pelicula = (Pelicula) comboPelicula.getSelectedItem();
                double promedio = pelicula.calcularPromedioEvaluaciones();
                JOptionPane.showMessageDialog(
                        null, "El promedio de la película es: " + promedio);
            });

            botonCancelar.addActionListener(e1 -> {
                int opcion = JOptionPane.showConfirmDialog(
                        null,"¿Estas seguro que deseas cancelar?","Confirmar cancelación", JOptionPane.YES_NO_OPTION
                );
                if (opcion == JOptionPane.YES_OPTION) {
                    panelFormulario.removeAll();
                    panelFormulario.revalidate();
                    panelFormulario.repaint();
                }
            });

            panelFormulario.revalidate();
            panelFormulario.repaint();

        });

        botonPeliculaGanadora.addActionListener(e -> {
            System.out.println("Boton pelicula ganadora presionado");

            if (peliculas.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "No hay películas registradas."
                );
                return;
            }

            Pelicula peliculaGanadora = null;
            double mejorPromedio = -1;

            for (Iterator<Pelicula> i = peliculas.iterator(); i.hasNext();) {
                Pelicula peliculaActual = i.next();
                double promedio = peliculaActual.calcularPromedioEvaluaciones();
                if (promedio > mejorPromedio) {
                    mejorPromedio = promedio;
                    peliculaGanadora = peliculaActual;
                }
            }

            if (peliculaGanadora == null || mejorPromedio == 0) {
                JOptionPane.showMessageDialog(
                        null, "No hay evaluaciones registradas."
                );
                return;
            }
            JOptionPane.showMessageDialog(
                    null,
                    "La película ganadora es:\n"
                            + peliculaGanadora.getTitulo()
                            + "\nPromedio: "
                            + mejorPromedio
            );
        });

        add(panelTitulo, BorderLayout.NORTH);
        add(panelMenu, BorderLayout.WEST);
        add(panelFormulario, BorderLayout.CENTER);
        setVisible(true);

    }

}
