public class Producto {
    private int id;              // Clave primaria para ordenar en el árbol
    private String nombre;       // Nombre o descripción del producto
    private Producto izquierdo;  // Hijo menor (IDs menores que el actual)
    private Producto derecho;    // Hijo mayor (IDs mayores que el actual)

    // Constructor: inicializa el producto con sus punteros vacíos (null)
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Producto izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Producto getDerecho() {
        return derecho;
    }

    public void setDerecho(Producto derecho) {
        this.derecho = derecho;
    }
}