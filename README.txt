SISTEMA DE GESTIÓN DE FESTIVAL DE CINE

Etapa 2:

Supuestos realizados:

* Se asumió que los datos ingresados por el usuario son válidos para el funcionamiento general del sistema.
* Para simplificar la implementación y ajustarse a los tiempos de entrega, algunas entidades se generan mediante datos precargados en determinados casos de uso.
* La visualización de ediciones y entradas se realiza de manera simplificada mediante los casos de uso relacionados.
* Se asumió que cada evaluación corresponde a una película y a un jurado específico.
* El sistema de promociones y descuentos fue implementado como extensión de la Etapa 1 mediante las clases Promocion y Pago.

Decisiones relevantes de implementación:

* El proyecto fue organizado en paquetes (modelo, servicios, excepciones, persistencia, ui y app) para separar responsabilidades y mejorar la organización del código.
* Se aplicó herencia mediante la clase abstracta Persona y sus especializaciones Actor, Director, Jurado y Espectador.
* Se utilizaron colecciones Set para evitar duplicados y representar relaciones entre objetos.
* La persistencia se implementó para las entidades consideradas principales: Película, Función y Espectador.
* Se incorporó manejo de excepciones mediante try-catch para controlar errores de ingreso por consola.
* Se priorizó el encapsulamiento utilizando atributos privados y métodos específicos para gestionar el comportamiento de las entidades.
* Las relaciones entre entidades se gestionan mediante métodos como agregarActor(), agregarCategoria(), agregarFuncion(), agregarEvaluacion() y registrarEntrada().
* La extensión de promociones permite validar promociones vigentes y calcular descuentos aplicados a pagos.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Etapa 3:

Supuestos realizados:

* Se mantuvo la lógica de negocio desarrollada en la Etapa 2, incorporando únicamente una interfaz gráfica utilizando Java Swing.
* Se asumió que el usuario interactúa con la aplicación exclusivamente mediante la interfaz gráfica, reemplazando completamente la versión por consola.
* Se conservaron los mecanismos de persistencia implementados previamente, permitiendo mantener la información almacenada entre ejecuciones de la aplicación.

Decisiones relevantes de implementación:

* Se desarrolló una ventana principal desde la cual es posible acceder a todos los módulos del sistema: festivales, películas, funciones, entradas y evaluaciones.
* La interfaz fue implementada utilizando componentes de Java Swing como JFrame, JPanel, JButton, JLabel, JTextField, JComboBox, JTextArea, JScrollPane, JOptionPane y JProgressBar.
* Se mantuvo la separación entre la interfaz gráfica y la lógica de negocio, delegando las operaciones a las clases del modelo y los servicios correspondientes.
* Se incorporaron validaciones sobre los datos ingresados mediante la interfaz gráfica, informando los errores y operaciones exitosas mediante cuadros de diálogo.
* Se implementó confirmación antes de cancelar operaciones para evitar la pérdida accidental de información ingresada.
* Se reorganizó la presentación visual de los formularios para mantener un diseño uniforme y mejorar la experiencia de usuario mediante bordes, distribución consistente de componentes y áreas de visualización con desplazamiento cuando corresponde.
* Se reutilizó la estructura de paquetes existente (modelo, servicios, persistencia, excepciones, ui y app), manteniendo una adecuada separación de responsabilidades.
