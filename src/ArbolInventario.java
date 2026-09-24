public class ArbolInventario {
    private Producto raiz; // Raíz del árbol

    public ArbolInventario() {
        this.raiz = null;
    }

    // Método auxiliar para saber si el árbol está vacío
    public boolean estaVacio() {
        return raiz == null;
    }

    // ==========================================
    // 1. REGISTRAR / INSERTAR (RECURSIVO)
    // ==========================================
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        // Caso base: se encontró la posición nula donde va el nuevo producto
        if (actual == null) {
            return new Producto(id, nombre);
        }

        // Si el ID nuevo es menor, va a la izquierda
        if (id < actual.getId()) {
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), id, nombre));
        } 
        // Si el ID nuevo es mayor, va a la derecha
        else if (id > actual.getId()) {
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), id, nombre));
        } 
        // Si el ID es igual, evitamos duplicados
        else {
            System.out.println("⚠️ El ID " + id + " ya existe en el inventario. No se permiten duplicados.");
        }

        return actual;
    }

    // ==========================================
    // 2. RECORRIDO INORDEN (LISTAR ORDENADO)
    // ==========================================
    // Visita: Izquierda -> Raíz -> Derecha (Muestra los IDs de menor a mayor)
    public void mostrarInorden() {
        if (estaVacio()) {
            System.out.println("El inventario está vacío.");
        } else {
            inordenRecursivo(raiz);
        }
    }

    private void inordenRecursivo(Producto actual) {
        if (actual != null) {
            inordenRecursivo(actual.getIzquierdo());
            System.out.println("  ID: " + actual.getId() + " | Producto: " + actual.getNombre());
            inordenRecursivo(actual.getDerecho());
        }
    }

    // ==========================================
    // 3. BUSCAR PRODUCTO POR ID (RECURSIVO)
    // ==========================================
    public void buscar(int id) {
        Producto encontrado = buscarRecursivo(raiz, id);
        if (encontrado != null) {
            System.out.println("✅ Producto Encontrado: ID = " + encontrado.getId() + " | Nombre = " + encontrado.getNombre());
        } else {
            System.out.println("❌ El producto con ID " + id + " NO existe en el inventario.");
        }
    }

    private Producto buscarRecursivo(Producto actual, int id) {
        // Caso base: no existe (null) o se encontró la coincidencia
        if (actual == null || actual.getId() == id) {
            return actual;
        }

        // Si el ID buscado es menor, busca en la izquierda
        if (id < actual.getId()) {
            return buscarRecursivo(actual.getIzquierdo(), id);
        } 
        // Si el ID buscado es mayor, busca en la derecha
        else {
            return buscarRecursivo(actual.getDerecho(), id);
        }
    }
}