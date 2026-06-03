package ui;

import modelo.*;
import pesistencia.FuncionCSV;
import pesistencia.PeliculaCSV;

import java.util.HashSet;
import java.util.Scanner;

public class Consola {
    public void iniciar () {

        Scanner scanner = new Scanner(System.in);

        int opcion = -1;

        while (opcion != 0){
            System.out.println("----- FESTIVAL DE CINE -----");
            System.out.println("1. Gestión festival");
            System.out.println("2. Gestión peliculas");
            System.out.println("3. Gestión funciones");
            System.out.println("4. Gestión entradas");
            System.out.println("5. Gestión evaluaciones");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    menuFestival(scanner);
                    break;
                case 2:
                    menuPeliculas(scanner);
                    break;
                case 3:
                    menuFunciones(scanner);
                    break;
                case 4:
                    menuEntradas(scanner);
                    break;
                case 5:
                    menuEvaluaciones(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
            }
        }
    }
    public void menuFestival (Scanner scanner) {
        int opcion = -1;

        while (opcion != 0){
            System.out.println("----- GESTION FESTIVAL -----");
            System.out.println("1. Crear festival");
            System.out.println("2. Crear edición");
            System.out.println("3. Mostrar ediciones");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Ingresa el nombre del festival: ");
                    String nombreFestival = scanner.nextLine();
                    Festival festival = new Festival(nombreFestival);
                    System.out.println("Festival registrado correctamente.");
                    break;
                case 2:
                    System.out.println("Ingresa el nro de la edición: ");
                    int nroEdicion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingresa la ciudad de la edición: ");
                    String ciudadFestival = scanner.nextLine();
                    System.out.println("Ingresa la fecha de la edición: ");
                    String fechaFestival = scanner.nextLine();
                    System.out.println("Ingresa el nombre del festival: ");
                    String nombreFestivalEdicion = scanner.nextLine();
                    Festival festivalEdicion = new Festival(nombreFestivalEdicion);
                    Edicion edicion = new Edicion(nroEdicion, ciudadFestival, fechaFestival, festivalEdicion);
                    System.out.println("Edición registrado correctamente.");
                    break;
                case 3:
                    System.out.println("Las ediciones se visualizan desde las funciones registradas.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
            }
        }
    }
    public void menuPeliculas (Scanner scanner) {
        int opcion = -1;

        while (opcion != 0){
            System.out.println("----- GESTION PELICULAS -----");
            System.out.println("1. Registrar pelicula");
            System.out.println("2. Registrar director");
            System.out.println("3. Registrar actor");
            System.out.println("4. Asociar categoria");
            System.out.println("5. Mostrar peliculas");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Ingresa el titulo de la pelicula:");
                    String titulo = scanner.nextLine();
                    System.out.println("Ingresa el genero de la pelicula: ");
                    String genero = scanner.nextLine();
                    System.out.println("Ingresa la duración de la pelicula: ");
                    int duracion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingresa el nombre del director: ");
                    String nombreDirector = scanner.nextLine();
                    System.out.println("Ingresa el apellido del director: ");
                    String apellidoDirector = scanner.nextLine();
                    System.out.println("Ingresa la edad del director: ");
                    int edadDirector = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingresar la fecha de nacimiento del director: ");
                    String fechaNacimientoDirector = scanner.nextLine();
                    System.out.println("Ingresar el sexo del director: ");
                    String sexoDirector = scanner.nextLine();
                    Director director = new Director(nombreDirector, apellidoDirector, edadDirector, fechaNacimientoDirector, sexoDirector);
                    Pelicula pelicula = new Pelicula(titulo, genero, duracion, director);
                    PeliculaCSV peliculaCSV = new PeliculaCSV();
                    peliculaCSV.guardarPelicula(pelicula);
                    System.out.println("Pelicula registrada correctamente.");
                    break;
                case 2:
                    System.out.println("Ingresa el nombre del director: ");
                    String nombreDirectorI = scanner.nextLine();
                    System.out.println("Ingresa el apellido del director: ");
                    String apellidoDirectorI = scanner.nextLine();
                    System.out.println("Ingresa la edad del director: ");
                    int edadDirectorI = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingresar la fecha de nacimiento del director: ");
                    String fechaNacimientoDirectorI = scanner.nextLine();
                    System.out.println("Ingresar el sexo del director: ");
                    String sexoDirectorI = scanner.nextLine();
                    Director directorI = new Director(nombreDirectorI, apellidoDirectorI, edadDirectorI, fechaNacimientoDirectorI, sexoDirectorI);
                    System.out.println("Director registrado correctamente.");
                    break;
                case 3:
                    System.out.println("Ingresa el nombre del actor: ");
                    String nombreActor = scanner.nextLine();
                    System.out.println("Ingresa el apellido del actor: ");
                    String apellidoActor = scanner.nextLine();
                    System.out.println("Ingresa la edad del actor: ");
                    int edadActor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingresar la fecha de nacimiento del actor: ");
                    String fechaNacimientoActor = scanner.nextLine();
                    System.out.println("Ingresar el sexo del actor: ");
                    String sexoActor = scanner.nextLine();
                    Actor actor = new Actor(nombreActor, apellidoActor, edadActor, fechaNacimientoActor, sexoActor);
                    System.out.println("Actor registrado correctamente.");
                    break;
                case 4:
                    System.out.println("Ingresa el tipo de categoria: ");
                    String tipoCategoria = scanner.nextLine();
                    System.out.println("Ingresa la descripción de la categoría: ");
                    String descripcion = scanner.nextLine();
                    Categoria categoria = new Categoria(tipoCategoria, descripcion);
                    System.out.println("La categoria se asocio correctamente.");
                    break;
                case 5:
                    PeliculaCSV peliculaCSVMostrar = new PeliculaCSV();
                    peliculaCSVMostrar.leerPelicula();
                    break;
                case 0:
                    System.out.println("Volviendo...");
            }
        }
    }
    public void menuFunciones (Scanner scanner) {
        int opcion = -1;

        while (opcion != 0){
            System.out.println("----- GESTION FUNCIONES -----");
            System.out.println("1. Programar funcion");
            System.out.println("2. Verificar disponibilidad");
            System.out.println("3. Mostrar funciones");
            System.out.println("4. Consultar ocupación");
            System.out.println("5. Consultar porcentaje ocupación");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Ingresa la fecha de la función: ");
                    String fechaFuncion = scanner.nextLine();
                    System.out.println("Ingresa la hora de la función: ");
                    String horaFuncion = scanner.nextLine();
                    System.out.println("----- DATOS PELICULA -----");
                    System.out.println("Ingresa el titulo de la pelicula: ");
                    String tituloPelicula = scanner.nextLine();
                    System.out.println("Ingresar el genero de la pelicula: ");
                    String generoPelicula = scanner.nextLine();
                    System.out.println("Ingresar la duracion de la pelicula: ");
                    int duracionPelicula = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("----- DATOS DIRECTOR -----");
                    System.out.println("Ingresa el nombre del director: ");
                    String nombreDirectorI = scanner.nextLine();
                    System.out.println("Ingresa el apellido del director: ");
                    String apellidoDirectorI = scanner.nextLine();
                    System.out.println("Ingresa la edad del director: ");
                    int edadDirectorI = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingresar la fecha de nacimiento del director: ");
                    String fechaNacimientoDirectorI = scanner.nextLine();
                    System.out.println("Ingresar el sexo del director: ");
                    String sexoDirectorI = scanner.nextLine();
                    System.out.println("----- DATOS FESTIVAL -----");
                    System.out.println("Ingresar el nombre del festival: ");
                    String nombreFestival = scanner.nextLine();
                    System.out.println("Ingresa el nro de la edición: ");
                    int nroEdicion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingresa la ciudad de la edición:");
                    String ubicacionEdicion = scanner.nextLine();
                    System.out.println("Ingresa la fecha de la edición:");
                    String fechaEdicion = scanner.nextLine();
                    System.out.println("Ingresa el nro de la sala: ");
                    int nroSala = scanner.nextInt();
                    scanner.nextLine();
                    Director director = new Director(nombreDirectorI, apellidoDirectorI, edadDirectorI, fechaNacimientoDirectorI, sexoDirectorI);
                    Pelicula pelicula = new Pelicula(tituloPelicula, generoPelicula, duracionPelicula, director);
                    Festival festival = new Festival(nombreFestival);
                    Sala sala = new Sala(nroSala, new HashSet<>());
                    Edicion edicion = new Edicion(nroEdicion, ubicacionEdicion, fechaEdicion, festival);
                    Funcion funcion = new Funcion(fechaFuncion, horaFuncion, pelicula, edicion, sala, new HashSet<>());
                    FuncionCSV funcionCSV = new FuncionCSV();
                    funcionCSV.guardarFuncion(funcion);
                    System.out.println("Función registrada correctamente.");
                    break;
                case 2:
                    System.out.println("Ingresa la capacidad de la sala: ");
                    int capacidadSala = scanner.nextInt();
                    System.out.println("Ingresa la cantidad de entradas vendidas: ");
                    int entradasVendidas = scanner.nextInt();
                    scanner.nextLine();
                    if (entradasVendidas < capacidadSala) {
                        System.out.println("Hay disponibilidad.");
                    } else {
                        System.out.println("No hay disponibilidad.");
                    }
                    break;
                case 3:
                    FuncionCSV funcionCSVMostrar = new FuncionCSV();
                    funcionCSVMostrar.leerFuncion();
                    break;
                case 4:
                    System.out.println("Ingresa la capacidad de la sala: ");
                    int capacidadSalaOcupacion = scanner.nextInt();
                    System.out.println("Ingresa la cantidad de entradas vendidas: ");
                    int entradasVendidasOcupacion = scanner.nextInt();
                    scanner.nextLine();
                    int disponibles = capacidadSalaOcupacion - entradasVendidasOcupacion;
                    System.out.println("Asientos ocupados: " + entradasVendidasOcupacion);
                    System.out.println("Asientos disponibles: " + disponibles);
                    break;
                case 5:
                    System.out.println("Ingresa la capacidad de la sala: ");
                    int capacidadSalaPorcentaje = scanner.nextInt();
                    System.out.println("Ingresa la cantidad de entradas vendidas: ");
                    int entradasVendidasPorcentaje = scanner.nextInt();
                    scanner.nextLine();
                    double porcentaje = (entradasVendidasPorcentaje * 100.0) / capacidadSalaPorcentaje;
                    System.out.println("El porcentaje de ocupación es: " + porcentaje);
                    break;
                case 0:
                    System.out.println("Volviendo...");
            }
        }
    }
    public void menuEntradas (Scanner scanner) {
        int opcion = -1;

        while (opcion != 0){
            System.out.println("----- GESTION ENTRADAS -----");
            System.out.println("1. Registrar espectador");
            System.out.println("2. Vender entrada");
            System.out.println("3. Mostrar entradas");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Saliendo...");
            }
        }
    }
    public void menuEvaluaciones(Scanner scanner) {
        int opcion = -1;

        while (opcion != 0){
            System.out.println("----- GESTION EVALUACIONES -----");
            System.out.println("1. Registrar evaluación");
            System.out.println("2. Calcular promedio pelicula");
            System.out.println("3. Mostrar pelicula ganadora");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Saliendo...");
            }
        }
    }
}
