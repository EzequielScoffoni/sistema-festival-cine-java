package ui;

import modelo.*;
import pesistencia.*;
import servicios.SistemaFestival;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class VentanaPeliculas extends JFrame {

    private Set<Pelicula> peliculas;
    private PeliculaCSV peliculaCSV;
    private Set<Director> directores;
    private DirectorCSV directorCSV;
    private Set<Actor> actores;
    private ActorCSV actorCSV;
    private Set<Categoria> categorias;
    private CategoriaCSV categoriaCSV;
    private ActorPeliculaCSV actorPeliculaCSV;
    private JPanel panelFormulario;

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
        JButton botonAsociarActor = new JButton("Asociar actor a pelicula");
        JButton botonAsociarCat = new JButton("Asociar categoria");
        JButton botonMostrarPeliculas = new JButton("Mostrar peliculas");

        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));

        panelFormulario = new JPanel();

        panelTitulo.add(titulo);
        panelMenu.add(botonRegistrarPelicula);
        panelMenu.add(botonRegistrarDirector);
        panelMenu.add(botonRegistrarActor);
        panelMenu.add(botonAsociarActor);
        panelMenu.add(botonAsociarCat);
        panelMenu.add(botonMostrarPeliculas);

        peliculaCSV = new PeliculaCSV();
        peliculas = SistemaFestival.getPeliculas();
        peliculas.addAll(peliculaCSV.cargarPeliculas());

        directorCSV = new DirectorCSV();
        directores = SistemaFestival.getDirectores();
        directores.addAll(directorCSV.cargarDirectores());

        actorCSV = new ActorCSV();
        actores = SistemaFestival.getActores();
        actores.addAll(actorCSV.cargarActores());

        categoriaCSV = new CategoriaCSV();
        categoriaCSV.cargarCategorias(peliculas);

        actorPeliculaCSV = new ActorPeliculaCSV();
        peliculas.addAll(peliculaCSV.cargarPeliculas());
        actores.addAll(actorCSV.cargarActores());
        actorPeliculaCSV.cargarActoresPeliculas(peliculas, actores);

        botonRegistrarPelicula.addActionListener(e -> {
            System.out.println("Boton crear pelicula presionado");
            panelFormulario.removeAll();

            JLabel tituloPelicula = new JLabel("Titulo de la pelicula: ");
            JTextField datoTitulo = new JTextField(20);
            JLabel genero = new JLabel("Genero de la pelicula: ");
            JTextField datoGenero = new JTextField(20);
            JLabel duracion = new JLabel("Duración de la pelicula: ");
            JTextField datoDuracion = new JTextField(20);
            JLabel nombreDirector = new JLabel("Nombre del director de la pelicula: ");
            JTextField datoNombreDirector = new JTextField(20);
            JLabel apellidoDirector = new JLabel("Apellido del director de la pelicula: ");
            JTextField datoApellidoDirector = new JTextField(20);
            JLabel edadDirector = new JLabel("Edad del director de la pelicula: ");
            JTextField datoEdadDirector = new JTextField(20);
            JLabel fechaNacimientoDirector = new JLabel("Fecha de nacimiento del director de la pelicula: ");
            JTextField datoFechaNacimiento = new JTextField(20);
            JLabel sexo = new JLabel("Sexo del director de la pelicula: ");
            JTextField datoSexo = new JTextField(20);
            JButton botonGuardar = new JButton("Guardar");
            JButton botonCancelar = new JButton("Cancelar");
            panelFormulario.add(tituloPelicula);
            panelFormulario.add(datoTitulo);
            panelFormulario.add(genero);
            panelFormulario.add(datoGenero);
            panelFormulario.add(duracion);
            panelFormulario.add(datoDuracion);
            panelFormulario.add(nombreDirector);
            panelFormulario.add(datoNombreDirector);
            panelFormulario.add(apellidoDirector);
            panelFormulario.add(datoApellidoDirector);
            panelFormulario.add(edadDirector);
            panelFormulario.add(datoEdadDirector);
            panelFormulario.add(fechaNacimientoDirector);
            panelFormulario.add(datoFechaNacimiento);
            panelFormulario.add(sexo);
            panelFormulario.add(datoSexo);
            panelFormulario.add(botonGuardar);
            panelFormulario.add(botonCancelar);

            botonGuardar.addActionListener(e1 -> {
                try {
                    String tituloP = datoTitulo.getText();
                    String generoP = datoGenero.getText();
                    String nombreDirectorP = datoNombreDirector.getText();
                    String apellidoDirectorP = datoApellidoDirector.getText();
                    String fechaNacimiento = datoFechaNacimiento.getText();
                    String sexoP = datoSexo.getText();
                    if (tituloP.isBlank() || generoP.isBlank() || nombreDirectorP.isBlank() || apellidoDirectorP.isBlank() || fechaNacimiento.isBlank() || sexoP.isBlank()){
                        JOptionPane.showMessageDialog(
                                null, "Todos los campos deben estar completos."
                        );
                        return;
                    }

                    int duracionP = Integer.parseInt(datoDuracion.getText());
                    int edadDirectorP = Integer.parseInt(datoEdadDirector.getText());

                    if (duracionP <= 0 || edadDirectorP <= 0) {
                        JOptionPane.showMessageDialog(
                                null, "La duración y la edad deben ser mayores a 0."
                        );
                        return;
                    }
                    Director director = new Director(nombreDirectorP, apellidoDirectorP, edadDirectorP, fechaNacimiento, sexoP);
                    Pelicula pelicula = new Pelicula(tituloP, generoP, duracionP, director);

                    if (peliculas.add(pelicula)) {
                        peliculaCSV.guardarPelicula(pelicula);
                        JOptionPane.showMessageDialog(
                                null, "Pelicula registrada correctamente."
                        );
                        datoTitulo.setText("");
                        datoGenero.setText("");
                        datoDuracion.setText("");
                        datoNombreDirector.setText("");
                        datoApellidoDirector.setText("");
                        datoEdadDirector.setText("");
                        datoFechaNacimiento.setText("");
                        datoSexo.setText("");
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "La pelicula ya existe"
                        );
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "La duracion y la edad del director debe ser numérico."
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

        botonRegistrarDirector.addActionListener(e -> {
            System.out.println("Boton crear director presionado");
            panelFormulario.removeAll();

            JLabel nombreDirector = new JLabel("Nombre del director de la pelicula: ");
            JTextField datoNombreDirector = new JTextField(20);
            JLabel apellidoDirector = new JLabel("Apellido del director de la pelicula: ");
            JTextField datoApellidoDirector = new JTextField(20);
            JLabel edadDirector = new JLabel("Edad del director de la pelicula: ");
            JTextField datoEdadDirector = new JTextField(20);
            JLabel fechaNacimientoDirector = new JLabel("Fecha de nacimiento del director de la pelicula: ");
            JTextField datoFechaNacimiento = new JTextField(20);
            JLabel sexo = new JLabel("Sexo del director de la pelicula: ");
            JTextField datoSexo = new JTextField(20);
            JButton botonGuardar = new JButton("Guardar");
            JButton botonCancelar = new JButton("Cancelar");
            panelFormulario.add(nombreDirector);
            panelFormulario.add(datoNombreDirector);
            panelFormulario.add(apellidoDirector);
            panelFormulario.add(datoApellidoDirector);
            panelFormulario.add(edadDirector);
            panelFormulario.add(datoEdadDirector);
            panelFormulario.add(fechaNacimientoDirector);
            panelFormulario.add(datoFechaNacimiento);
            panelFormulario.add(sexo);
            panelFormulario.add(datoSexo);
            panelFormulario.add(botonGuardar);
            panelFormulario.add(botonCancelar);

            botonGuardar.addActionListener(e1 -> {
                try {
                    String nombreDirectorP = datoNombreDirector.getText();
                    String apellidoDirectorP = datoApellidoDirector.getText();
                    String fechaNacimiento = datoFechaNacimiento.getText();
                    String sexoP = datoSexo.getText();
                    if (nombreDirectorP.isBlank() || apellidoDirectorP.isBlank() || fechaNacimiento.isBlank() || sexoP.isBlank()){
                        JOptionPane.showMessageDialog(
                                null, "Todos los campos deben estar completos."
                        );
                        return;
                    }

                    int edadDirectorP = Integer.parseInt(datoEdadDirector.getText());

                    if (edadDirectorP <= 0) {
                        JOptionPane.showMessageDialog(
                                null, "La edad deben ser mayores a 0."
                        );
                        return;
                    }
                    Director director = new Director(nombreDirectorP, apellidoDirectorP, edadDirectorP, fechaNacimiento, sexoP);

                    if (directores.add(director)) {
                        directorCSV.guardarDirector(director);
                        JOptionPane.showMessageDialog(
                                null, "Director registrado correctamente."
                        );
                        datoNombreDirector.setText("");
                        datoApellidoDirector.setText("");
                        datoEdadDirector.setText("");
                        datoFechaNacimiento.setText("");
                        datoSexo.setText("");
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "El director ya existe"
                        );
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "La edad del director debe ser numérico."
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

        botonRegistrarActor.addActionListener(e -> {
            System.out.println("Boton crear actor presionado");
            panelFormulario.removeAll();

            JLabel nombreActor = new JLabel("Nombre del actor: ");
            JTextField datoNombreActor = new JTextField(20);
            JLabel apellidoActor = new JLabel("Apellido del actor: ");
            JTextField datoApellidoActor = new JTextField(20);
            JLabel edadActor = new JLabel("Edad del actor: ");
            JTextField datoEdadActor = new JTextField(20);
            JLabel fechaNacimientoActor = new JLabel("Fecha de nacimiento del actor: ");
            JTextField datoFechaNacimiento = new JTextField(20);
            JLabel sexo = new JLabel("Sexo del actor: ");
            JTextField datoSexo = new JTextField(20);
            JButton botonGuardar = new JButton("Guardar");
            JButton botonCancelar = new JButton("Cancelar");
            panelFormulario.add(nombreActor);
            panelFormulario.add(datoNombreActor);
            panelFormulario.add(apellidoActor);
            panelFormulario.add(datoApellidoActor);
            panelFormulario.add(edadActor);
            panelFormulario.add(datoEdadActor);
            panelFormulario.add(fechaNacimientoActor);
            panelFormulario.add(datoFechaNacimiento);
            panelFormulario.add(sexo);
            panelFormulario.add(datoSexo);
            panelFormulario.add(botonGuardar);
            panelFormulario.add(botonCancelar);

            botonGuardar.addActionListener(e1 -> {
                try {
                    String nombreA = datoNombreActor.getText();
                    String apellidoA = datoApellidoActor.getText();
                    String fechaNacimientoA = datoFechaNacimiento.getText();
                    String sexoA = datoSexo.getText();
                    if (nombreA.isBlank() || apellidoA.isBlank() || fechaNacimientoA.isBlank() || sexoA.isBlank()){
                        JOptionPane.showMessageDialog(
                                null, "Todos los campos deben estar completos."
                        );
                        return;
                    }

                    int edadA = Integer.parseInt(datoEdadActor.getText());

                    if (edadA <= 0) {
                        JOptionPane.showMessageDialog(
                                null, "La edad deben ser mayor a 0."
                        );
                        return;
                    }
                    Actor actor = new Actor(nombreA, apellidoA, edadA, fechaNacimientoA, sexoA);

                    if (actores.add(actor)) {
                        actorCSV.guardarActor(actor);
                        JOptionPane.showMessageDialog(
                                null, "Actor registrado correctamente."
                        );
                        datoNombreActor.setText("");
                        datoApellidoActor.setText("");
                        datoEdadActor.setText("");
                        datoFechaNacimiento.setText("");
                        datoSexo.setText("");
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "El actor ya existe"
                        );
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "La edad del director debe ser numérico."
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

        botonAsociarActor.addActionListener(e -> {
            System.out.println("Boton asociar actor presionado");

            if (peliculas.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Se debe crear una película antes de asociar un actor"
                );
                return;
            }
            if (actores.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Se debe registrar un actor antes de asociarlo"
                );
                return;
            }

            panelFormulario.removeAll();

            JComboBox<Pelicula> comboPelicula = new JComboBox<>();
            for (Iterator<Pelicula> i = peliculas.iterator(); i.hasNext();) {
                comboPelicula.addItem(i.next());
            }
            JComboBox<Actor> comboActor = new JComboBox<>();
            for (Iterator<Actor> i = actores.iterator(); i.hasNext();) {
                comboActor.addItem(i.next());
            }
            JButton botonGuardar = new JButton("Guardar");
            JButton botonCancelar = new JButton("Cancelar");

            panelFormulario.add(new JLabel("Película: "));
            panelFormulario.add(comboPelicula);
            panelFormulario.add(new JLabel("Actor: "));
            panelFormulario.add(comboActor);
            panelFormulario.add(botonGuardar);
            panelFormulario.add(botonCancelar);

            botonGuardar.addActionListener(e1 -> {
                Pelicula peliculaSeleccionada = (Pelicula) comboPelicula.getSelectedItem();
                Actor actorSeleccionado = (Actor) comboActor.getSelectedItem();

                if (peliculaSeleccionada.agregarActor(actorSeleccionado)) {
                    actorPeliculaCSV.guardarActorPelicula(peliculaSeleccionada, actorSeleccionado);
                    JOptionPane.showMessageDialog(
                            null,
                            "Actor asociado correctamente."
                    );
                    comboPelicula.setSelectedIndex(0);
                    comboActor.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "La película ya tiene asociado ese actor."
                    );
                }
            });

            botonCancelar.addActionListener(e1 -> {
                int opcion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Estas seguro que deseas cancelar?",
                        "Confirmar cancelación",
                        JOptionPane.YES_NO_OPTION
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

        botonAsociarCat.addActionListener(e -> {
            System.out.println("Boton Crear edicion presionado");
            if (peliculas.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Se debe crear una pelicula antes de asociar una categoria"
                );
                return;
            } else {
                panelFormulario.removeAll();

                JComboBox<Pelicula> comboPelicula = new JComboBox<>();
                for (Iterator<Pelicula> i = peliculas.iterator(); i.hasNext(); ) {
                    Pelicula peliculaActual = i.next();
                    comboPelicula.addItem(peliculaActual);
                }
                JLabel categoria = new JLabel("Categoria de la película: ");
                JTextField datoCategoria = new JTextField(5);
                JLabel descripcion = new JLabel("Descripción: ");
                JTextField datoDescripcion = new JTextField(15);
                JButton botonGuardar = new JButton("Guardar");
                JButton botonCancelar = new JButton("Cancelar");

                panelFormulario.add(new JLabel("Película: "));
                panelFormulario.add(comboPelicula);
                panelFormulario.add(categoria);
                panelFormulario.add(datoCategoria);
                panelFormulario.add(descripcion);
                panelFormulario.add(datoDescripcion);
                panelFormulario.add(botonGuardar);
                panelFormulario.add(botonCancelar);

                botonGuardar.addActionListener(e1 -> {

                    String categoriaP = datoCategoria.getText();
                    String descripcionP = datoDescripcion.getText();
                    Pelicula peliculaSeleccionada = (Pelicula) comboPelicula.getSelectedItem();
                    if (categoriaP.isBlank() || descripcionP.isBlank()){
                        JOptionPane.showMessageDialog(
                                null, "Los campos no pueden ir vacios"
                        );
                        return;
                    }
                    Categoria categoria1 = new Categoria(categoriaP, descripcionP);

                    if (peliculaSeleccionada.agregarCategoria(categoria1)) {
                        categoriaCSV.guardarCategoria(categoria1, peliculaSeleccionada);
                        JOptionPane.showMessageDialog(
                                null, "Categoria asociada correctamente."
                        );
                        datoCategoria.setText("");
                        datoDescripcion.setText("");
                        comboPelicula.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "La pelicula ya tiene esa categoria"
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

            };

                panelFormulario.revalidate();
                panelFormulario.repaint();
        });

        botonMostrarPeliculas.addActionListener(e -> {
            System.out.println("Boton mostrar peliculas presionado");
            if (peliculas.isEmpty()){
                JOptionPane.showMessageDialog(
                        null, "No hay películas registradas"
                );
                return;
            }
            panelFormulario.removeAll();

            JTextArea areaPeliculas = new JTextArea(15, 40);
            areaPeliculas.setEditable(false);
            JScrollPane scroll = new JScrollPane(areaPeliculas);
            for (Iterator<Pelicula> i = peliculas.iterator(); i.hasNext();) {
                Pelicula peliculaActual = i.next();
                areaPeliculas.append(peliculaActual.obtenerInformacion() + "\n\n----------------------------------\n\n");
            }

            panelFormulario.add(scroll);

            panelFormulario.revalidate();
            panelFormulario.repaint();
        });

        add(panelTitulo, BorderLayout.NORTH);
        add(panelMenu, BorderLayout.WEST);
        add(panelFormulario, BorderLayout.CENTER);
        setVisible(true);
    }

}
