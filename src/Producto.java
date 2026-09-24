/**
 * CLASE: Producto.java
 * NODO DE UN ÁRBOL BINARIO DE BÚSQUEDA (ABB)
 * 
 * Esta clase actúa como el nodo individual dentro de la estructura de datos.
 * Cada instancia de Producto contiene la información del elemento (su ID único 
 * y su nombre) y las referencias a sus dos nodos hijos (izquierdo y derecho).
 * 
 */
public class Producto {
    // Atributos de datos (Encapsulamiento)
    private int id;              // Identificador único (clave primaria de ordenamiento)
    private String nombre;       // Nombre o descripción del producto
    
    // Punteros estructurales de un árbol binario
    private Producto izquierdo;  // Apunta al hijo menor (rama izquierda)
    private Producto derecho;    // Apunta al hijo mayor (rama derecha)

    /**
     * Constructor de la clase Producto.
     * Crea un nodo hoja por defecto: se asignan los datos y las ramas
     * izquierda y derecha nacen apuntando a null (sin hijos todavía).
     * 
     */
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }

    // =======================================================
    // MÉTODOS GETTERS Y SETTERS (Acceso y Modificación)
    // =======================================================

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