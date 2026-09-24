import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolInventario inventario = new ArbolInventario();
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n=================================");
            System.out.println("    GESTIÓN DE INVENTARIO (ABB)  ");
            System.out.println("=================================");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario (Inorden)");
            System.out.println("3. Buscar Producto por ID");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // Validación de la opción elegida
            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                System.out.println("⚠️ Entrada inválida. Debe ingresar un número entero.");
                sc.next(); // Limpia el buffer
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID del producto: ");
                    try {
                        int id = sc.nextInt();
                        sc.nextLine(); // Limpia el salto de línea sobrante
                        System.out.print("Ingrese nombre del producto: ");
                        String nombre = sc.nextLine();

                        inventario.insertar(id, nombre);
                        System.out.println("✅ Producto registrado con éxito.");
                    } catch (Exception e) {
                        System.out.println("⚠️ Error: El ID debe ser un número entero válido.");
                        sc.next(); // Limpia el buffer
                    }
                    break;

                case 2:
                    System.out.println("\n--- LISTADO DE PRODUCTOS (INORDEN) ---");
                    inventario.mostrarInorden();
                    break;

                case 3:
                    System.out.print("Ingrese el ID a buscar: ");
                    try {
                        int idBuscar = sc.nextInt();
                        inventario.buscar(idBuscar);
                    } catch (Exception e) {
                        System.out.println("⚠️ Error: El ID debe ser un número entero válido.");
                        sc.next(); // Limpia el buffer
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema de inventario...");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida. Intente de nuevo.");
            }
        }

        sc.close();
    }
}