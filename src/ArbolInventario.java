/**
 * CLASE: ArbolInventario.java
 * ES EL CONTROLADOR DEL ÁRBOL BINARIO DE BÚSQUEDA (ABB)
 * 
 * Contiene toda la lógica algorítmica para operar sobre la estructura jerárquica.
 * Administra el punto de entrada principal (la raíz) y aplica el patrón
 * Wrapper / Envoltorio para ocultar la complejidad de la recursión hacia el exterior.
 * 
 */
public class ArbolInventario {
    private Producto raiz; // Punto de acceso principal a la estructura en memoria

    /**
     * Constructor que inicializa un árbol totalmente vacío.
     */
    public ArbolInventario() {
        this.raiz = null;
    }

    /**
     * Verifica si el árbol carece de elementos instalados.
     */
    public boolean estaVacio() {
        return raiz == null;
    }

    // =========================================================================
    // 1. INSERCIÓN DE PRODUCTOS (WRAPPER + MÉTODO RECURSIVO)
    // =========================================================================

    /**
     * Método público (Wrapper). Punto de entrada externo para registrar productos.
     * Oculta el nodo raíz a la interfaz de usuario.
     */
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    /**
     * Método privado recursivo para encontrar la posición correcta del nuevo nodo.
     */
    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        // Caso Base: Se encontró un punto nulo donde debe ser insertado el nuevo nodo
        if (actual == null) {
            return new Producto(id, nombre);
        }

        // Subárbol Izquierdo: El ID a insertar es MENOR que el ID del nodo actual
        if (id < actual.getId()) {
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), id, nombre));
        } 
        // Subárbol Derecho: El ID a insertar es MAYOR que el ID del nodo actual
        else if (id > actual.getId()) {
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), id, nombre));
        } 
        // Caso de Duplicidad: El ID ya existe en el árbol
        else {
            System.out.println(" Advertencia: El ID " + id + " ya existe en el inventario. No se admiten duplicados.");
        }

        return actual; // Retorna el nodo sin modificaciones para mantener el enlace del árbol
    }

    // =========================================================================
    // 2. RECORRIDO INORDEN (LISTADO ORDENADO DE MENOR A MAYOR)
    // =========================================================================

    /**
     * Método público (Wrapper) para imprimir el inventario en orden ascendente.
     */
    public void mostrarInorden() {
        if (estaVacio()) {
            System.out.println("(El inventario está completamente vacío)");
        } else {
            inordenRecursivo(raiz);
        }
    }

    /**
     * Método privado recursivo que aplica la regla Inorden: Izquierda -> Raíz -> Derecha.
     */
    private void inordenRecursivo(Producto actual) {
        if (actual != null) {
            inordenRecursivo(actual.getIzquierdo()); // 1. Recorrer rama izquierda
            System.out.println("  [ID: " + actual.getId() + "] -> Producto: " + actual.getNombre()); // 2. Visitar Raíz
            inordenRecursivo(actual.getDerecho());   // 3. Recorrer rama derecha
        }
    }

    // =========================================================================
    // 3. BÚSQUEDA DE PRODUCTO POR ID (RECURSIVA)
    // =========================================================================

    /**
     * Método público (Wrapper) para consultar la presencia de un producto por ID.
     */
    public void buscar(int id) {
        Producto resultado = buscarRecursivo(raiz, id);
        if (resultado != null) {
            System.out.println(" ¡PRODUCTO ENCONTRADO!");
            System.out.println("   ID: " + resultado.getId() + " | Nombre: " + resultado.getNombre());
        } else {
            System.out.println(" EL PRODUCTO CON ID [" + id + "] NO EXISTE EN EL INVENTARIO.");
        }
    }

    /**
     * Método privado recursivo para recorrer el árbol buscando coincidencia por ID.
     */
    private Producto buscarRecursivo(Producto actual, int id) {
        // Caso Base 1: No existe el elemento (null) o Caso Base 2: Se encontró la coincidencia exacta
        if (actual == null || actual.getId() == id) {
            return actual;
        }

        // Si el ID buscado es menor, la búsqueda continúa exclusivamente por la izquierda
        if (id < actual.getId()) {
            return buscarRecursivo(actual.getIzquierdo(), id);
        } 
        // Si el ID buscado es mayor, la búsqueda continúa exclusivamente por la derecha
        else {
            return buscarRecursivo(actual.getDerecho(), id);
        }
    }
}