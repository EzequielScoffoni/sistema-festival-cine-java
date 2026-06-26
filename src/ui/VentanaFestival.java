package ui;

import modelo.Edicion;
import modelo.Festival;
import pesistencia.EdicionCSV;
import pesistencia.FestivalCSV;
import servicios.SistemaFestival;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class VentanaFestival extends JFrame {

    private Set<Festival> festivales;
    private JPanel panelFormulario;
    private FestivalCSV festivalCSV;
    private EdicionCSV edicionCSV;

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

        Dimension tamañoBoton = new Dimension(170, 35);

        JButton[] botones = {botonCrearFestival, botonCrearEdicion, botonMostrarEdiciones};

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
        panelMenu.add(botonCrearFestival);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(botonCrearEdicion);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(botonMostrarEdiciones);

        festivalCSV = new FestivalCSV();
        edicionCSV = new EdicionCSV();
        festivales = SistemaFestival.getFestivales();

        botonCrearFestival.addActionListener(e -> {
            panelFormulario.removeAll();

            panelFormulario.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Datos del festival"), BorderFactory.createEmptyBorder(20, 20, 20, 20)));

            panelFormulario.setLayout(new FlowLayout());

            JLabel tituloCrear = new JLabel("Nombre del festival: ");
            JTextField datosFestival = new JTextField(20);
            JButton botonGuardar = new JButton("Guardar");
            JButton botonCancelar = new JButton("Cancelar");
            panelFormulario.add(tituloCrear);
            panelFormulario.add(datosFestival);
            panelFormulario.add(botonGuardar);
            panelFormulario.add(botonCancelar);

            botonGuardar.addActionListener(e1 -> {
                String nombreFestival = datosFestival.getText();

                if (nombreFestival.isBlank()) {
                    JOptionPane.showMessageDialog(
                            null, "Se debe ingresar un nombre de festival para poder guardar"
                    );
                } else {
                    Festival festival = new Festival(nombreFestival);
                    if (festivales.add(festival)) {
                        festivalCSV.guardarFestival(festival);
                        JOptionPane.showMessageDialog(
                                null, "Festival registrado correctamente"
                        );
                        datosFestival.setText("");
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "El festival ya existe"
                        );
                        datosFestival.setText("");
                    }
                }
            });

            botonCancelar.addActionListener(e1 -> {
                int opcion = JOptionPane.showConfirmDialog(
                        null, "¿Estas seguro que deseas cancelar?", "Confirmar cancelación", JOptionPane.YES_NO_OPTION
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

        botonCrearEdicion.addActionListener(e -> {
            if (festivales.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Se debe crear un festival antes de registrar una edición"
                );
            } else {
                panelFormulario.removeAll();

                panelFormulario.setLayout(new GridLayout(0, 2, 10,10));

                panelFormulario.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Datos de la edicion"), BorderFactory.createEmptyBorder(20, 20,20, 20)));


                JLabel nroEdicion = new JLabel("Numero de la edición: ");
                JTextField datoNroEdicion = new JTextField(5);
                JLabel ciudadEdicion = new JLabel("Ciudad: ");
                JTextField datoCiudadEdicion = new JTextField(15);
                JLabel fechaEdicion = new JLabel("Fecha de la edición (dd/mm/yyyy): ");
                JTextField datoFecha = new JTextField(15);
                JComboBox<Festival> comboFestival = new JComboBox<>();
                for (Iterator<Festival> i = festivales.iterator(); i.hasNext(); ) {
                    Festival festivalActual = i.next();
                    comboFestival.addItem(festivalActual);
                }
                JButton botonGuardar = new JButton("Guardar");
                JButton botonCancelar = new JButton("Cancelar");
                panelFormulario.add(nroEdicion);
                panelFormulario.add(datoNroEdicion);
                panelFormulario.add(ciudadEdicion);
                panelFormulario.add(datoCiudadEdicion);
                panelFormulario.add(fechaEdicion);
                panelFormulario.add(datoFecha);
                panelFormulario.add(new JLabel("Festival: "));
                panelFormulario.add(comboFestival);
                panelFormulario.add(botonGuardar);
                panelFormulario.add(botonCancelar);

                botonGuardar.addActionListener(e1 -> {
                    try {
                        String datoNro = datoNroEdicion.getText();
                        int nroEdicionP = Integer.parseInt(datoNro);
                        String datoCiudad = datoCiudadEdicion.getText();
                        String datoFechaEdicion = datoFecha.getText();
                        Festival festivalSeleccionado = (Festival) comboFestival.getSelectedItem();
                        if (datoCiudad.isBlank() || datoFechaEdicion.isBlank()){
                            JOptionPane.showMessageDialog(
                                    null, "Los campos de Ciudad y Fecha no pueden ir vacios"
                            );
                            return;
                        }

                        Edicion edicion = new Edicion(nroEdicionP, datoCiudad, datoFechaEdicion, festivalSeleccionado);

                        if (festivalSeleccionado.agregarEdicion(edicion)) {
                            edicionCSV.guardarEdicion(edicion);
                            JOptionPane.showMessageDialog(
                                    null, "Edicion agregada correctamente"
                            );
                            datoNroEdicion.setText("");
                            datoCiudadEdicion.setText("");
                            datoFecha.setText("");
                            comboFestival.setSelectedIndex(0);
                        } else {
                            JOptionPane.showMessageDialog(
                                    null, "La edición ya existe"
                            );
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(
                                null,
                                "El número de edición debe ser numérico."
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
            }
        });

        botonMostrarEdiciones.addActionListener(e -> {
            if (festivales.isEmpty()){
                JOptionPane.showMessageDialog(
                        null, "Debe crear un festival primero"
                );
                return;
            }
            panelFormulario.removeAll();

            panelFormulario.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

            panelFormulario.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Ediciones del festival"), BorderFactory.createEmptyBorder(20, 20, 20, 20)));

            JComboBox<Festival> comboFestival = new JComboBox<>();
            for (Iterator<Festival> i = festivales.iterator(); i.hasNext(); ) {
                Festival festivalActual = i.next();
                comboFestival.addItem(festivalActual);
            }
            JButton botonMostrar = new JButton("Mostrar");
            JTextArea areaEdiciones = new JTextArea(10, 30);

            panelFormulario.add(comboFestival);
            panelFormulario.add(botonMostrar);
            panelFormulario.add(areaEdiciones);

            botonMostrar.addActionListener(e1 -> {
                areaEdiciones.setText("");
                Festival festivalSeleccionado = (Festival) comboFestival.getSelectedItem();
                Set<Edicion> edicionesFestival = festivalSeleccionado.getEdicion();
                if (edicionesFestival.isEmpty()){
                    JOptionPane.showMessageDialog(
                            null, "El festival no tiene ediciones registradas."
                    );
                } else {
                    for (Iterator<Edicion> i = edicionesFestival.iterator(); i.hasNext(); ) {
                        Edicion edicionActual = i.next();
                        areaEdiciones.append(edicionActual + "\n");
                    }
                }
            });

            panelFormulario.revalidate();
            panelFormulario.repaint();
        });


        add(panelTitulo, BorderLayout.NORTH);
        add(panelMenu, BorderLayout.WEST);
        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));
        panelCentro.add(panelFormulario, BorderLayout.CENTER);
        add(panelCentro, BorderLayout.CENTER);
        setVisible(true);

    }


}
