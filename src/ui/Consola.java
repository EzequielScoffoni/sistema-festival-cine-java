package ui;

import modelo.*;
import pesistencia.EspectadorCSV;
import pesistencia.FuncionCSV;
import pesistencia.PeliculaCSV;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

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
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un numero");
                scanner.nextLine();
                continue;
            }
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
                default:
                    System.out.println("Opcion invalida.");
                    break;
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
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un numero");
                scanner.nextLine();
                continue;
            }
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
                    System.out.println("Volviendo...");
                default:
                    System.out.println("Opcion invalida.");
                    break;
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
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un numero");
                scanner.nextLine();
                continue;
            }
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
                default:
                    System.out.println("Opcion invalida.");
                    break;
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
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un numero");
                scanner.nextLine();
                continue;
            }
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
                default:
                    System.out.println("Opcion invalida.");
                    break;
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
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un numero");
                scanner.nextLine();
                continue;
            }
            switch (opcion){
                case 1:
                    System.out.println("Ingresa el nombre del espectador: ");
                    String nombreEspectador = scanner.nextLine();
                    System.out.println("Ingresa el apellido del espectador: ");
                    String apellidoEspectador = scanner.nextLine();
                    System.out.println("Ingresa la edad del espectador: ");
                    int edadEspectador = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingresar la fecha de nacimiento del espectador: ");
                    String fechaNacimientoEspectador = scanner.nextLine();
                    System.out.println("Ingresar el sexo del espectador: ");
                    String sexoEspectador = scanner.nextLine();
                    System.out.println("Ingrese el dni del espectador: ");
                    int dniEspectador = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el email del espectador: ");
                    String emailEspectador = scanner.nextLine();
                    Espectador espectador = new Espectador(nombreEspectador, apellidoEspectador, edadEspectador, fechaNacimientoEspectador, sexoEspectador, dniEspectador, emailEspectador);
                    EspectadorCSV espectadorCSV = new EspectadorCSV();
                    espectadorCSV.guardarEspectador(espectador);
                    System.out.println("Espectador registrado correctamente");
                    break;
                case 2:
                    System.out.println("Ingresa el nombre del espectador: ");
                    String nombreEspectadorV = scanner.nextLine();
                    System.out.println("Ingresa el apellido del espectador: ");
                    String apellidoEspectadorV = scanner.nextLine();
                    System.out.println("Ingrese el dni del espectador: ");
                    int dniEspectadorV = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el email del espectador: ");
                    String emailEspectadorV = scanner.nextLine();
                    System.out.println("Ingrese el nro de la butaca que desea: ");
                    int nroButaca = scanner.nextInt();
                    System.out.println("Ingrese el nro de la fila que desea: ");
                    int nroFila = scanner.nextInt();
                    scanner.nextLine();
                    Espectador espectadorV = new Espectador(nombreEspectadorV, apellidoEspectadorV, 27, "30/06/1998", "masculino", dniEspectadorV, emailEspectadorV);
                    Festival festivalV = new Festival("Nuevo festival de cine");
                    Director director = new Director("Quentin", "Tarantino", 63, "27/03/1963", "masculino");
                    Pelicula pelicula = new Pelicula("Once Upon a Time in Hollywood", "Ficcion", 200, director);
                    Edicion edicion = new Edicion(1, "Buenos Aires", "30/06/2026", festivalV);
                    Set<Butaca> butacas = new HashSet<>();
                    Butaca butaca = new Butaca(nroButaca, nroFila, true);
                    butacas.add(butaca);
                    Sala sala = new Sala(1, butacas);
                    Funcion funcion = new Funcion("30/06/2026", "20:00", pelicula, edicion, sala, new HashSet<>());
                    Entrada entrada = new Entrada(espectadorV, funcion, butaca);
                    if (entrada.generarEntrada()){
                        System.out.println("Entrada vendida correctamente.");
                    } else {
                        System.out.println("No se pudo vender la entrada.");
                    }
                    break;
                case 3:
                    System.out.println("Las entradas se visualizan al momento de la venta.");
                    break;
                case 0:
                    System.out.println("Volviendo...");
                default:
                    System.out.println("Opcion invalida.");
                    break;
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
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un numero");
                scanner.nextLine();
                continue;
            }
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el nombre del jurado: ");
                    String nombreJurado = scanner.nextLine();
                    System.out.println("Ingrese el apellido del jurado: ");
                    String apellidoJurado = scanner.nextLine();
                    System.out.println("Ingrese el titulo de la pelicula: ");
                    String tituloPelicula = scanner.nextLine();
                    System.out.println("Ingrese el puntaje: ");
                    int puntaje = scanner.nextInt();
                    scanner.nextLine();
                    Jurado jurado = new Jurado(nombreJurado, apellidoJurado, 40, "01/06/1986", "masculino");
                    Director director = new Director("Christopher", "Nolan", 64, "23/05/1962", "masculino");
                    Pelicula pelicula = new Pelicula(tituloPelicula, "Ficcion", 200, director);
                    Evaluacion evaluacion = new Evaluacion(puntaje, pelicula, jurado);
                    if (jurado.hacerEvaluacion(evaluacion)){
                        pelicula.agregarEvaluacion(evaluacion);
                        System.out.println("Evaluacion registrada correctamente");
                    } else {
                        System.out.println("No se pudo registrar la evaluacion");
                    }
                    break;
                case 2:
                    Director directorP = new Director("Christopher", "Nolan", 64, "24/05/1962", "masculino");
                    Pelicula peliculaP = new Pelicula("Interestelar", "Ficcion", 240, directorP);
                    Jurado jurado1 = new Jurado("Ezequiel", "Scoffoni", 27, "30/06/1998", "masculino");
                    Jurado jurado2 = new Jurado("Juan", "Lopez", 27, "01/08/1998", "masculino");
                    Evaluacion evaluacion1 = new Evaluacion(7, peliculaP, jurado1);
                    Evaluacion evaluacion2 = new Evaluacion(10, peliculaP, jurado2);
                    peliculaP.agregarEvaluacion(evaluacion1);
                    peliculaP.agregarEvaluacion(evaluacion2);
                    double promedio = peliculaP.calcularPromedioEvaluaciones();
                    System.out.println("Promedio de las evaluaciones: " + promedio);
                    break;
                case 3:
                    Director directorA = new Director("Christopher", "Nolan", 64, "24/05/1962", "masculino");
                    Director directorB = new Director("Quentin", "Tarantino", 63, "27/03/1963", "masculino");
                    Pelicula peliculaA = new Pelicula("Interestelar", "Ficcion", 240, directorA);
                    Pelicula peliculaB = new Pelicula("Pulp Fuction", "Drama", 180, directorB);
                    Jurado juradoA = new Jurado("Juan", "Lopez", 27, "01/08/1998", "masculino");
                    Jurado juradoB = new Jurado("Ezequiel","Scoffoni", 27, "30/06/1998", "masculino");
                    Evaluacion evaluacionA = new Evaluacion(7, peliculaA, juradoA);
                    Evaluacion evaluacionB = new Evaluacion(10, peliculaA, juradoB);
                    Evaluacion evaluacionC = new Evaluacion(8, peliculaB, juradoA);
                    Evaluacion evaluacionD = new Evaluacion(6, peliculaB, juradoB);
                    peliculaA.agregarEvaluacion(evaluacionA);
                    peliculaA.agregarEvaluacion(evaluacionB);
                    peliculaB.agregarEvaluacion(evaluacionC);
                    peliculaB.agregarEvaluacion(evaluacionD);
                    double promedioA = peliculaA.calcularPromedioEvaluaciones();
                    double promedioB = peliculaB.calcularPromedioEvaluaciones();
                    if (promedioA > promedioB) {
                        System.out.println("La pelicula ganadora es: Interestelar");
                    } else if (promedioB > promedioA) {
                        System.out.println("La pelicula ganadora es: Pulp Fiction");
                    } else {
                        System.out.println("Hay un empate entre las peliculas.");
                    }
                    break;
                case 0:
                    System.out.println("Volviendo...");
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }
    }
}
