SISTEMA DE GESTIÓN DE FESTIVAL DE CINE

Supuestos realizados:

* Se asumió que los datos ingresados por el usuario son válidos para el funcionamiento general del sistema.
* Para simplificar y por temas de tiempos de entrega la implementación, algunas entidades se generan mediante datos precargados en determinados casos de uso.
* La visualización de ediciones y entradas se realiza de manera simplificada mediante los casos de uso relacionados.
* Se asumió que cada evaluación corresponde a una película y a un jurado específico.
* El sistema de promociones y descuentos fue implementado como extensión de la Etapa 1 mediante las clases Promocion y Pago.

Decisiones relevantes de implementación

* El proyecto fue organizado en paquetes (modelo, servicios, excepciones, persistencia, ui y app) para separar responsabilidades y mejorar la organización del código.
* Se aplicó herencia mediante la clase abstracta Persona y sus especializaciones Actor, Director, Jurado y Espectador.
* Se utilizaron colecciones Set para evitar duplicados y representar relaciones entre objetos.
* La persistencia se implementó para las entidades consideradas principales: Película, Función y Espectador.
* Se incorporó manejo de excepciones mediante try-catch para controlar errores de ingreso por consola.
* Se priorizó el encapsulamiento utilizando atributos privados y métodos específicos para gestionar el comportamiento de las entidades.
* Las relaciones entre entidades se gestionan mediante métodos como agregarActor(), agregarCategoria(), agregarFuncion(), agregarEvaluacion() y registrarEntrada().
* La extensión de promociones permite validar promociones vigentes y calcular descuentos aplicados a pagos.
