# Introducción

Este proyecto es la resolución de una prueba técnica generada con chatGPT para fines didácticos.

# Prueba técnica

Aquí tienes un escenario de prueba técnica que involucra Spring Boot, PostgreSQL y la aplicación de patrones de diseño,
principios SOLID y pruebas unitarias:

**Escenario**

Estás desarrollando una aplicación de gestión de pedidos para una tienda en línea. Cada pedido tiene una lista de
productos, una dirección de envío y un estado de procesamiento. Debes implementar la funcionalidad de agregar un nuevo
pedido, procesar los pedidos pendientes y obtener estadísticas de los pedidos.

**Requerimientos**

1. Utiliza Spring Boot y PostgreSQL para el desarrollo de la aplicación.
2. Aplica el patrón de diseño DAO para abstraer el acceso a los datos de los pedidos.
3. Implementa el patrón de diseño Strategy para manejar los diferentes estados de procesamiento de los pedidos (por
   ejemplo, "pendiente", "en proceso", "completado").
4. Aplica los principios SOLID en el diseño de tu código, asegurándote de que tus clases sean cohesivas, tengan una
   única responsabilidad y sean fáciles de extender.
5. Escribe pruebas unitarias utilizando un marco de pruebas como JUnit y Mockito para verificar el funcionamiento
   correcto de tu aplicación.

**Tareas a realizar**

1. Crea una entidad Pedido que represente la estructura de datos de un pedido, incluyendo la lista de productos, la
   dirección de envío y el estado de procesamiento.
2. Implementa un DAO llamado PedidoDao que abstraiga el acceso a los datos de los pedidos, proporcionando métodos para
   agregar, actualizar y obtener pedidos por ID y estado.
3. Define una interfaz EstadoPedido que represente los diferentes estados de procesamiento y define métodos como
   procesar y completar que deben ser implementados por las clases concretas de estados.
4. Implementa las clases concretas de estados de procesamiento como PedidoPendienteEstado, PedidoEnProcesoEstado,
   PedidoCompletadoEstado, aplicando el patrón de diseño Strategy. Cada clase debe implementar los métodos definidos en
   la interfaz EstadoPedido.
5. Diseña una clase GestorPedido que gestione la lógica principal de la aplicación, como agregar un nuevo pedido,
   cambiar el estado de procesamiento y obtener estadísticas de los pedidos.
6. Escribe pruebas unitarias para cada componente de la aplicación, verificando su comportamiento y asegurando su
   correcto funcionamiento. Utiliza Mockito para simular dependencias externas, como el DAO de pedidos.

Al implementar este escenario, estarás aplicando varios patrones de diseño, como DAO y Strategy, así como principios
SOLID para lograr una arquitectura modular y mantenible. Además, las pruebas unitarias te ayudarán a garantizar que la
aplicación funcione correctamente y a detectar posibles problemas o errores.

