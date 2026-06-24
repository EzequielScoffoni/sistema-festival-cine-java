package ui;

import modelo.*;
import pesistencia.FuncionCSV;
import pesistencia.SalaCSV;
import servicios.SistemaFestival;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class VentanaFunciones extends JFrame {

    private JPanel panelFormulario;
    private Set<Sala> salas;
    private SalaCSV salaCSV;
    private Set<Funcion> funciones;
    private FuncionCSV funcionCSV;
    private Set<Pelicula> peliculas;
    private Set<Festival> festivales;

    public VentanaFunciones () {

        setTitle("Sistema Festival de Cine");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("Gestion de funciones");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelMenu = new JPanel();
        JButton botonRegistrarSala = new JButton("Registrar sala");
        JButton botonProgramarFuncion = new JButton("Programar funcion");
        JButton botonDisponibilidad = new JButton("Verificar disponibilidad");
        JButton botonMostrarFunciones = new JButton("Mostrar funciones");
        JButton botonOcupacion = new JButton("Consultar ocupacion");
        JButton botonPorcentajeOcupacion = new JButton("Porcentaje ocupacion");

        Dimension tamañoBoton = new Dimension(170, 35);

        JButton[] botones = {botonRegistrarSala, botonProgramarFuncion, botonDisponibilidad, botonMostrarFunciones, botonOcupacion, botonPorcentajeOcupacion};

        for (int i = 0; i < botones.length; i++) {
            botones[i].setMaximumSize(
                    tamañoBoton
            );
        }

        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));

        panelFormulario = new JPanel();

        panelTitulo.add(Box.createVerticalStrut(60));
        panelTitulo.add(titulo);
        panelMenu.add(Box.createVerticalStrut(5));
        panelMenu.add(botonRegistrarSala);
        panelMenu.add(Box.createVerticalStrut(5));
        panelMenu.add(botonProgramarFuncion);
        panelMenu.add(Box.createVerticalStrut(5));
        panelMenu.add(botonDisponibilidad);
        panelMenu.add(Box.createVerticalStrut(5));
        panelMenu.add(botonMostrarFunciones);
        panelMenu.add(Box.createVerticalStrut(5));
        panelMenu.add(botonOcupacion);
        panelMenu.add(Box.createVerticalStrut(5));
        panelMenu.add(botonPorcentajeOcupacion);

        peliculas = SistemaFestival.getPeliculas();
        festivales = SistemaFestival.getFestivales();
        salas = SistemaFestival.getSalas();
        funciones = SistemaFestival.getFunciones();

        salaCSV = new SalaCSV();
        funcionCSV = new FuncionCSV();


        botonRegistrarSala.addActionListener(e -> {
            System.out.println("Boton registrar sala presionado");
            panelFormulario.removeAll();

            JLabel nroSala = new JLabel("Número de sala: ");
            JTextField datosSala = new JTextField(10);
            JLabel cantidadButacas = new JLabel("Cantidad de butacas: ");
            JTextField datosButacas = new JTextField(10);
            JButton botonGuardar = new JButton("Guardar");
            JButton botonCancelar = new JButton("Cancelar");
            panelFormulario.add(nroSala);
            panelFormulario.add(datosSala);
            panelFormulario.add(cantidadButacas);
            panelFormulario.add(datosButacas);
            panelFormulario.add(botonGuardar);
            panelFormulario.add(botonCancelar);

            botonGuardar.addActionListener(e1 -> {
                try {
                    String nroSalaT = datosSala.getText();
                    String datosButacasT = datosButacas.getText();

                    if (nroSalaT.isBlank() || datosButacasT.isBlank()){
                        JOptionPane.showMessageDialog(
                                null, "Todos los campos deben estar completados."
                        );
                        return;
                    }

                    int nroSalaP = Integer.parseInt(nroSalaT);
                    int datosButacasP = Integer.parseInt(datosButacasT);

                    if (nroSalaP <= 0 || datosButacasP <= 0) {
                        JOptionPane.showMessageDialog(
                                null, "Los valores deben ser mayores a 0."
                        );
                        return;
                    }

                    Set<Butaca> butacas = new HashSet<>();
                    for (int i = 1; i <= datosButacasP; i++) {
                        Butaca butaca = new Butaca(i, 1, true);
                        butacas.add(butaca);
                    }
                    Sala sala = new Sala(nroSalaP, butacas);

                    if (salas.add(sala)) {
                        salaCSV.guardarSala(sala);
                        JOptionPane.showMessageDialog(
                                null, "Sala registrada correctamente."
                        );
                        datosSala.setText("");
                        datosButacas.setText("");
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "La sala ya existe."
                        );
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null, "Los campos deben ser numericos."
                    );
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

        botonProgramarFuncion.addActionListener(e -> {
            System.out.println("Boton programar funcion presionado.");
            if (peliculas.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Debe registrar una pelicula primero."
                );
                return;
            }
            if (salas.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Debe registrar una sala primero."
                );
                return;
            }
            if (festivales.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Debe registrar un festival y una edicion primero."
                );
                return;
            }
            panelFormulario.removeAll();

            JLabel fechaFuncion = new JLabel("Fecha de la funcion (dd/mm/yyyy): ");
            JTextField datoFecha = new JTextField(15);
            JLabel horaFucion = new JLabel("Hora de la funcion (hh:mm)");
            JTextField datoHora = new JTextField(15);
            JComboBox<Pelicula> comboPelicula = new JComboBox<>();
            for (Iterator<Pelicula> i = peliculas.iterator(); i.hasNext();) {
                comboPelicula.addItem(i.next());
            }
            JComboBox<Sala> comboSala = new JComboBox<>();
            for (Iterator<Sala> i = salas.iterator(); i.hasNext();) {
                comboSala.addItem(i.next());
            }
            JComboBox<Edicion> comboEdicion = new JComboBox<>();
            for (Iterator<Festival> i = festivales.iterator(); i.hasNext();) {
                Festival festivalActual = i.next();
                for (Iterator<Edicion> j = festivalActual.getEdicion().iterator(); j.hasNext();) {
                    comboEdicion.addItem(j.next());
                }
            }
            JButton botonGuardar = new JButton("Guardar");
            JButton botonCancelar = new JButton("Cancelar");

            panelFormulario.add(fechaFuncion);
            panelFormulario.add(datoFecha);
            panelFormulario.add(horaFucion);
            panelFormulario.add(datoHora);
            panelFormulario.add(new JLabel("Película: "));
            panelFormulario.add(comboPelicula);
            panelFormulario.add(new JLabel("Edición: "));
            panelFormulario.add(comboEdicion);
            panelFormulario.add(new JLabel("Sala: "));
            panelFormulario.add(comboSala);
            panelFormulario.add(botonGuardar);
            panelFormulario.add(botonCancelar);

            botonGuardar.addActionListener(e1 -> {
                String fecha = datoFecha.getText();
                String hora = datoHora.getText();

                Pelicula peliculaSeleccionada = (Pelicula) comboPelicula.getSelectedItem();
                Edicion edicionSeleccionada = (Edicion) comboEdicion.getSelectedItem();
                Sala salaSeleccionada = (Sala) comboSala.getSelectedItem();

                if (fecha.isBlank() || hora.isBlank()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Todos los campos deben estar completos."
                    );
                    return;
                }
                Funcion funcion = new Funcion(fecha, hora, peliculaSeleccionada, edicionSeleccionada, salaSeleccionada, new HashSet<>());

                if (salaSeleccionada.asignarFuncion(funcion)) {
                    if (funciones.add(funcion)) {
                        funcionCSV.guardarFuncion(funcion);
                        JOptionPane.showMessageDialog(
                                null, "Función registrada correctamente."
                        );
                        datoFecha.setText("");
                        datoHora.setText("");
                        comboPelicula.setSelectedIndex(0);
                        comboEdicion.setSelectedIndex(0);
                        comboSala.setSelectedIndex(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            null, "La sala ya tiene una función programada en esa fecha y hora."
                    );
                }
            });

            botonCancelar.addActionListener(e1 -> {
                int opcion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Estas seguro que deseas cancelar?", "Confirmar cancelación", JOptionPane.YES_NO_OPTION
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

        botonDisponibilidad.addActionListener(e -> {
            System.out.println("Boton verificar disponibilidad presionado.");
            if (funciones.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "No hay funciones registradas."
                );
                return;
            }
            panelFormulario.removeAll();

            JComboBox<Funcion> comboFuncion = new JComboBox<>();
            for (Iterator<Funcion> i = funciones.iterator(); i.hasNext();) {
                comboFuncion.addItem(i.next());
            }
            JButton botonConsultar = new JButton("Consultar");
            JButton botonCancelar = new JButton("Cancelar");

            panelFormulario.add(new JLabel("Función:"));
            panelFormulario.add(comboFuncion);
            panelFormulario.add(botonConsultar);
            panelFormulario.add(botonCancelar);

            botonConsultar.addActionListener(e1 -> {

                Funcion funcionSeleccionada = (Funcion) comboFuncion.getSelectedItem();
                if (funcionSeleccionada.verificarDisponibilidad()) {
                    JOptionPane.showMessageDialog(
                            null, "La función tiene lugares disponibles."
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null, "La función está completa."
                    );
                }
            });

            botonCancelar.addActionListener(e1 -> {
                int opcion =
                        JOptionPane.showConfirmDialog(
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

        botonMostrarFunciones.addActionListener(e -> {
            System.out.println("Boton mostrar funciones presionado");
            if (funciones.isEmpty()){
                JOptionPane.showMessageDialog(
                        null, "No hay funciones registradas"
                );
                return;
            }
            panelFormulario.removeAll();

            JTextArea areaFunciones = new JTextArea(15, 40);
            areaFunciones.setEditable(false);
            JScrollPane scroll = new JScrollPane(areaFunciones);
            for (Iterator<Funcion> i = funciones.iterator(); i.hasNext();) {
                Funcion funcionActual = i.next();
                areaFunciones.append(funcionActual.obtenerInformacion() + "\n\n----------------------------------\n\n");
            }

            panelFormulario.add(scroll);

            panelFormulario.revalidate();
            panelFormulario.repaint();
        });

        botonOcupacion.addActionListener(e -> {
            System.out.println("Boton consultar ocupación presionado.");
            if (funciones.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "No hay funciones registradas."
                );
                return;
            }
            panelFormulario.removeAll();

            JComboBox<Funcion> comboFuncion = new JComboBox<>();
            for (Iterator<Funcion> i = funciones.iterator(); i.hasNext();) {
                comboFuncion.addItem(i.next());
            }
            JButton botonObtener = new JButton("Obtener");
            JButton botonCancelar = new JButton("Cancelar");

            panelFormulario.add(new JLabel("Función:"));
            panelFormulario.add(comboFuncion);
            panelFormulario.add(botonObtener);
            panelFormulario.add(botonCancelar);

            botonObtener.addActionListener(e1 -> {
                Funcion funcionSeleccionada = (Funcion) comboFuncion.getSelectedItem();
                JOptionPane.showMessageDialog(
                        null, "La función tiene " + funcionSeleccionada.obtenerOcupacion() + " entradas vendidas."
                );
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

        botonPorcentajeOcupacion.addActionListener(e -> {
            System.out.println("Boton porcentaje ocupación presionado.");
            if (funciones.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "No hay funciones registradas."
                );
                return;
            }
            panelFormulario.removeAll();

            JComboBox<Funcion> comboFuncion = new JComboBox<>();
            for (Iterator<Funcion> i = funciones.iterator(); i.hasNext();) {
                comboFuncion.addItem(i.next());
            }
            JButton botonObtener = new JButton("Obtener");
            JButton botonCancelar = new JButton("Cancelar");

            panelFormulario.add(new JLabel("Función:"));
            panelFormulario.add(comboFuncion);
            panelFormulario.add(botonObtener);
            panelFormulario.add(botonCancelar);

            botonObtener.addActionListener(e1 -> {
                Funcion funcionSeleccionada = (Funcion) comboFuncion.getSelectedItem();
                double porcentaje = funcionSeleccionada.obtenerPorcentajeOcupacion();
                JOptionPane.showMessageDialog(
                        null, "La función tiene un " + porcentaje + " % de ocupación."
                );
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

        add(panelTitulo, BorderLayout.NORTH);
        add(panelMenu, BorderLayout.WEST);
        add(panelFormulario, BorderLayout.CENTER);
        setVisible(true);

    }

}
