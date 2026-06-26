package ui;

import modelo.*;
import pesistencia.EntradaCSV;
import pesistencia.EspectadorCSV;
import servicios.SistemaFestival;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class VentanaEntradas extends JFrame {

    private JPanel panelFormulario;
    private Set<Entrada> entradas;
    private EntradaCSV entradaCSV;
    private Set<Espectador> espectadores;
    private EspectadorCSV espectadorCSV;
    private Set<Funcion> funciones;

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

        Dimension tamañoBoton = new Dimension(170, 35);

        JButton[] botones = {botonEspectador, botonVentaEntrada, botonMostrarEntradas};

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
        panelMenu.add(botonEspectador);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(botonVentaEntrada);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(botonMostrarEntradas);

        espectadorCSV = new EspectadorCSV();
        espectadores = SistemaFestival.getEspectadores();

        funciones = SistemaFestival.getFunciones();

        entradaCSV = new EntradaCSV();
        entradas = SistemaFestival.getEntradas();

        botonEspectador.addActionListener(e -> {
            panelFormulario.removeAll();

            panelFormulario.setLayout(new GridLayout(0, 2, 10,10));

            panelFormulario.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Datos del espectador"), BorderFactory.createEmptyBorder(20, 20,20, 20)));

            JLabel nombreEspectador = new JLabel("Nombre: ");
            JTextField datoNombreEspec = new JTextField(20);
            JLabel apellidoEspectador = new JLabel("Apellido: ");
            JTextField datoApellidoEspec = new JTextField(20);
            JLabel edadEspec = new JLabel("Edad: ");
            JTextField datoEdadEspec = new JTextField(20);
            JLabel fechaNacimientoEspec = new JLabel("Fecha de nacimiento: ");
            JTextField datoFechaNacimientoEspec = new JTextField(20);
            JLabel sexoEspec = new JLabel("Sexo: ");
            JTextField datoSexo = new JTextField(20);
            JLabel dniEspec = new JLabel("DNI: ");
            JTextField datoDni = new JTextField(20);
            JLabel emailEspec = new JLabel("Email: ");
            JTextField datoEmail = new JTextField(20);
            JButton botonGuardar = new JButton("Guardar");
            JButton botonCancelar = new JButton("Cancelar");
            panelFormulario.add(nombreEspectador);
            panelFormulario.add(datoNombreEspec);
            panelFormulario.add(apellidoEspectador);
            panelFormulario.add(datoApellidoEspec);
            panelFormulario.add(edadEspec);
            panelFormulario.add(datoEdadEspec);
            panelFormulario.add(fechaNacimientoEspec);
            panelFormulario.add(datoFechaNacimientoEspec);
            panelFormulario.add(sexoEspec);
            panelFormulario.add(datoSexo);
            panelFormulario.add(dniEspec);
            panelFormulario.add(datoDni);
            panelFormulario.add(emailEspec);
            panelFormulario.add(datoEmail);
            panelFormulario.add(botonGuardar);
            panelFormulario.add(botonCancelar);

            botonGuardar.addActionListener(e1 -> {
                try {
                    String nombreE = datoNombreEspec.getText();
                    String apellidoE = datoApellidoEspec.getText();
                    String fechaNacimientoE = datoFechaNacimientoEspec.getText();
                    String sexoE = datoSexo.getText();
                    String email = datoEmail.getText();
                    if (nombreE.isBlank() || apellidoE.isBlank() || fechaNacimientoE.isBlank() || sexoE.isBlank() || email.isBlank()) {
                        JOptionPane.showMessageDialog(
                                null, "Todos los campos deben estar completos."
                        );
                        return;
                    }

                    int edadE = Integer.parseInt(datoEdadEspec.getText());
                    int dni = Integer.parseInt(datoDni.getText());

                    if (edadE <= 0 || dni <= 0) {
                        JOptionPane.showMessageDialog(
                                null, "La edad y el dni deben ser mayor a 0."
                        );
                        return;
                    }
                    Espectador espectador = new Espectador(nombreE, apellidoE, edadE, fechaNacimientoE, sexoE, dni, email);

                    if (espectadores.add(espectador)) {
                        espectadorCSV.guardarEspectador(espectador);
                        JOptionPane.showMessageDialog(
                                null, "Espectador registrado correctamente."
                        );
                        datoNombreEspec.setText("");
                        datoApellidoEspec.setText("");
                        datoEdadEspec.setText("");
                        datoFechaNacimientoEspec.setText("");
                        datoSexo.setText("");
                        datoDni.setText("");
                        datoEmail.setText("");
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "El espectador ya existe"
                        );
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "La edad y el dni del espectador debe ser numéricos."
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

        botonVentaEntrada.addActionListener(e -> {
            if (funciones.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Debe registrar una función primero."
                );
                return;
            }

            if (espectadores.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Debe registrar un espectador primero."
                );
                return;
            }
            panelFormulario.removeAll();

            panelFormulario.setLayout(new GridLayout(0, 2, 10,10));

            panelFormulario.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Venta de entrada"), BorderFactory.createEmptyBorder(20, 20,20, 20)));

            JComboBox<Funcion> comboFuncion = new JComboBox<>();
            for (Iterator<Funcion> i = funciones.iterator(); i.hasNext(); ) {
                comboFuncion.addItem(i.next());
            }
            JComboBox<Espectador> comboEspectador = new JComboBox<>();
            for (Iterator<Espectador> i = espectadores.iterator(); i.hasNext(); ) {
                comboEspectador.addItem(i.next());
            }
            JComboBox<Butaca> comboButaca = new JComboBox<>();
            Funcion funcionSeleccionada = (Funcion) comboFuncion.getSelectedItem();
            if (funcionSeleccionada != null) {
                for (Iterator<Butaca> i = funcionSeleccionada.getSala().getButacas().iterator(); i.hasNext(); ) {
                    Butaca butaca = i.next();
                    if (butaca.isDisponibilidad()) {
                        comboButaca.addItem(butaca);
                    }
                }
            }
            comboFuncion.addActionListener(e1 -> {
                comboButaca.removeAllItems();
                Funcion funcion = (Funcion) comboFuncion.getSelectedItem();
                if (funcion != null) {
                    for (Iterator<Butaca> i = funcion.getSala().getButacas().iterator(); i.hasNext(); ) {
                        Butaca butaca = i.next();
                        if (butaca.isDisponibilidad()) {
                            comboButaca.addItem(butaca);
                        }
                    }
                }
            });
            JButton botonGuardar = new JButton("Guardar");
            JButton botonCancelar = new JButton("Cancelar");
            panelFormulario.add(new JLabel("Función: "));
            panelFormulario.add(comboFuncion);
            panelFormulario.add(new JLabel("Espectador: "));
            panelFormulario.add(comboEspectador);
            panelFormulario.add(new JLabel("Butaca: "));
            panelFormulario.add(comboButaca);
            panelFormulario.add(botonGuardar);
            panelFormulario.add(botonCancelar);

            botonGuardar.addActionListener(e1 -> {
                Funcion funcion = (Funcion) comboFuncion.getSelectedItem();
                Espectador espectador = (Espectador) comboEspectador.getSelectedItem();
                Butaca butaca = (Butaca) comboButaca.getSelectedItem();
                if (butaca == null) {
                    JOptionPane.showMessageDialog(
                            null, "No hay butacas disponibles."
                    );
                    return;
                }
                Entrada entrada = new Entrada(espectador, funcion, butaca);
                if (espectador.comprarEntrada(entrada)) {
                    funcion.registrarEntrada(entrada);
                    entradas.add(entrada);
                    entradaCSV.guardarEntrada(entrada);
                    JOptionPane.showMessageDialog(
                            null, "Entrada vendida correctamente."
                    );
                    comboButaca.removeItem(butaca);
                    comboFuncion.setSelectedIndex(0);
                    comboEspectador.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(
                            null, "No fue posible vender la entrada."
                    );
                }
            });

            botonCancelar.addActionListener(e1 -> {
                int opcion = JOptionPane.showConfirmDialog(
                        null, "¿Estas seguro que deseas cancelar?", "Confirmar cancelación", JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {
                    panelFormulario.removeAll();
                    panelFormulario.revalidate();
                    panelFormulario.repaint();
                }
            });

            panelFormulario.revalidate();
            panelFormulario.repaint();

        });

        botonMostrarEntradas.addActionListener(e -> {
            if (funciones.isEmpty()){
                JOptionPane.showMessageDialog(
                        null, "No hay funciones registradas"
                );
                return;
            }
            panelFormulario.removeAll();

            panelFormulario.setLayout(new BorderLayout());

            panelFormulario.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Entradas registradas"), BorderFactory.createEmptyBorder(15, 15, 15, 15)));

            JTextArea areaEntradas = new JTextArea(15, 40);
            areaEntradas.setEditable(false);
            areaEntradas.setLineWrap(true);
            areaEntradas.setWrapStyleWord(true);

            for (Iterator<Entrada> i = entradas.iterator(); i.hasNext();) {
                Entrada entradaActual = i.next();
                areaEntradas.append(
                        entradaActual.obtenerInformacion()
                                + "\n\n-------------------------------------------------------\n\n"
                );}

            JScrollPane scroll = new JScrollPane(areaEntradas);

            panelFormulario.add(scroll, BorderLayout.CENTER);

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
