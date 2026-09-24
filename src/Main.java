import java.util.Scanner;

/**
 * ==========================================================================================
 * ENUNCIADO DEL EJERCICIO:
 * ==========================================================================================
 * Deben desarrollar una aplicación de consola dividida estrictamente en tres clases, 
 * que gestione un inventario mediante un árbol:
 * 
 * 1. Clase Producto.java (El Nodo):
 *    - Contiene los datos: int id, String nombre.
 *    - Contiene los punteros: Producto izquierdo, Producto derecho.
 * 
 * 2. Clase ArbolInventario.java (La Lógica):
 *    - Debe contener el método Insertar (recursivo) para ubicar productos por ID.
 *    - Debe contener el método Recorrido Inorden (para listar el inventario ordenado).
 *    - Debe contener el método Buscar (por ID).
 * 
 * 3. Clase Main.java (La Interfaz):
 *    - Debe contener un menú interactivo (switch-case) con las siguientes opciones:
 *      1. Registrar Producto: Solicita ID y nombre.
 *      2. Mostrar Inventario: Ejecuta el recorrido inorden.
 *      3. Buscar Producto: Solicita un ID y dice si existe o no.
 *      0. Salir.
 * ==========================================================================================
 * 
 * CLASE: Main.java
 * ROL EN LA ESTRUCTURA: INTERFAZ DE USUARIO Y CONTROLADOR DE FLUJO
 * 
 * Aqui se despliega el menú interactivamente usando una estructura de control do-while/while 
 * y un switch-case. Integra mecanismos de captura de excepciones (try-catch) para 
 * evitar que el sistema falle cuando el usuario ingrese tipos de datos erróneos por consola.
 */
public class Main {
    public static void main(String[] args) {
        // Instancia del árbol para gestionar la información
        ArbolInventario miInventario = new ArbolInventario();
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        // Bucle interactivo principal
        while (opcion != 0) {
            System.out.println("\n===========================================");
            System.out.println("  SISTEMA DE GESTIÓN DE INVENTARIO (ABB) ");
            System.out.println("===========================================");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario (Recorrido Inorden)");
            System.out.println("3. Buscar Producto por ID");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // Validación de ingreso para evitar caídas si se digita texto en vez de entero
            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                System.out.println("⚠️ Error de entrada: Debe ingresar un número entero válido.");
                sc.next(); // Limpia el buffer del Scanner
                continue;  // Regresa al inicio del bucle
            }

            // Manejo de la opción seleccionada
            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR NUEVO PRODUCTO ---");
                    System.out.print("Ingrese ID numérico del producto: ");
                    try {
                        int id = sc.nextInt();
                        sc.nextLine(); // Limpieza del buffer del salto de línea (\n)
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = sc.nextLine();

                        miInventario.insertar(id, nombre);
                        System.out.println("✅ Proceso completado.");
                    } catch (Exception e) {
                        System.out.println(" Error: El ID ingresado debe ser un número entero.");
                        sc.next(); // Limpia el buffer en caso de fallo
                    }
                    break;

                case 2:
                    System.out.println("\n--- INVENTARIO ORDENADO POR ID (INORDEN) ---");
                    miInventario.mostrarInorden();
                    break;

                case 3:
                    System.out.println("\n--- CONSULTAR PRODUCTO ---");
                    System.out.print("Ingrese el ID del producto que desea buscar: ");
                    try {
                        int idBuscar = sc.nextInt();
                        miInventario.buscar(idBuscar);
                    } catch (Exception e) {
                        System.out.println(" Error: El ID de búsqueda debe ser un entero válido.");
                        sc.next(); // Limpia el buffer
                    }
                    break;

                case 0:
                    System.out.println("\nFinalizando la sesión. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println(" Opción no válida. Por favor seleccione un número del menú.");
            }
        }

        sc.close(); // Cierra el recurso Scanner al terminar la aplicación
    }
}