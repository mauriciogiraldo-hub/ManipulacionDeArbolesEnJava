#  Sistema de Gestión de Inventario mediante Árbol Binario de Búsqueda (ABB)

Aplicación de consola en **Java** orientada a la gestión eficiente de un inventario de productos utilizando una estructura de datos jerárquica no lineal: **Árbol Binario de Búsqueda (ABB)**.

---

##  Enunciado del Proyecto

Desarrollar una aplicación de consola dividida strictly en tres clases, que gestione un inventario mediante un árbol:

1. **Clase `Producto.java` (El Nodo):**
   - Contiene los datos: `int id`, `String nombre`.
   - Contiene los punteros: `Producto izquierdo`, `Producto derecho`.

2. **Clase `ArbolInventario.java` (La Lógica):**
   - Debe contener el método **Insertar** (recursivo) para ubicar productos por ID.
   - Debe contener el método **Recorrido Inorden** (para listar el inventario ordenado de menor a mayor).
   - Debe contener el método **Buscar** (por ID).

3. **Clase `Main.java` (La Interfaz):**
   - Debe contener un menú interactivo (`switch-case`) con las siguientes opciones:
     1. **Registrar Producto:** Solicita ID y nombre.
     2. **Mostrar Inventario:** Ejecuta el recorrido inorden.
     3. **Buscar Producto:** Solicita un ID y confirma su existencia.
     0. **Salir.**

---

##  Arquitectura del Sistema

El proyecto sigue el principio de **separación de responsabilidades**, distribuyendo la aplicación en tres capas fundamentales:

```text
    +-------------------------------------------------------+
    |                      Main.java                        |
    |            (Interfaz / Menú Interactivo)             |
    +---------------------------+---------------------------+
                                |
                                v
    +-------------------------------------------------------+
    |                 ArbolInventario.java                  |
    |        (Lógica del ABB y Operaciones Recursivas)      |
    +---------------------------+---------------------------+
                                |
                                v
    +-------------------------------------------------------+
    |                    Producto.java                      |
    |               (Nodo / Estructura de Datos)            |
    +-------------------------------------------------------+
```

---

##  Descripción de las Clases

### 1. `Producto.java` (El Nodo)
Representa la unidad básica (nodo) dentro del árbol binario. 
* **Atributos de Datos:** 
  * `id` (`int`): Clave primaria de ordenamiento en el árbol.
  * `nombre` (`String`): Nombre o descripción del producto.
* **Atributos de Estructura:** 
  * `izquierdo` (`Producto`): Puntero al subárbol con claves menores.
  * `derecho` (`Producto`): Puntero al subárbol con claves mayores.

### 2. `ArbolInventario.java` (La Lógica del Árbol)
Contiene las reglas de negocio y los algoritmos recursivos sobre el ABB.
* **Patrón Envoltorio (Wrapper):** Expone métodos públicos limpios para la interfaz (`insertar`, `mostrarInorden`, `buscar`), mientras delega la ejecución real a métodos privados recursivos (`insertarRecursivo`, `inordenRecursivo`, `buscarRecursivo`).
* **Inserción Ordenada:** Mantiene la propiedad del ABB colocándolos de forma automática.
* **Recorrido Inorden:** Procesa en orden `Izquierda -> Raíz -> Derecha`, generando una lista ordenada ascendentemente por ID.
* **Búsqueda Logarítmica:** Permite localizar un producto descartando el 50% de los nodos en cada nivel de profundidad en un árbol balanceado.

### 3. `Main.java` (La Interfaz de Usuario)
Provee el menú interactivo guiado por consola.
* **Manejo de Excepciones:** Integra bloques `try-catch` para capturar errores de tipo de dato cuando el usuario ingresa letras en campos numéricos.
* **Gestión del Buffer:** Limpia el buffer de entrada del `Scanner` para evitar lecturas indeseadas entre valores numéricos y texto.

---

##  Conceptos Clave de Estructuras de Datos

1. **¿Por qué usar un Árbol Binario de Búsqueda (ABB) para un Inventario?**
   A diferencia de un arreglo o una lista enlazada simple, el ABB permite realizar búsquedas, inserciones y eliminaciones de manera eficiente, optimizando los tiempos de respuesta.

2. **Recorrido Inorden (Izquierda ➔ Raíz ➔ Derecha):**
   Al recorrer un ABB en **Inorden**, los elementos siempre se visitan en orden estrictamente ascendente (de menor a mayor según su ID).

3. **Garantía de Sin Duplicados:**
   El algoritmo de inserción valida las claves. Si se intenta registrar un ID que ya existe, se genera un mensaje de advertencia impidiendo la duplicidad de datos.

---

##  Requisitos y Ejecución

### Requisitos Previos
* **Java Development Kit (JDK):** Versión 8 o superior.
* IDE de preferencia (NetBeans, IntelliJ IDEA, Eclipse, VS Code) o consola de comandos/terminal.

### Pasos para Compilar y Ejecutar desde Consola

1. **Guardar los archivos** en la misma carpeta:
   * `Producto.java`
   * `ArbolInventario.java`
   * `Main.java`

2. **Abrir la terminal** en dicha carpeta y compilar las tres clases:
   ```bash
   javac Producto.java ArbolInventario.java Main.java
   ```

3. **Ejecutar la aplicación:**
   ```bash
   java Main
   ```

---

##  Ejemplo de Interacción por Consola

```text
===========================================
  SISTEMA DE GESTIÓN DE INVENTARIO (ABB) 
===========================================
1. Registrar Producto
2. Mostrar Inventario (Recorrido Inorden)
3. Buscar Producto por ID
0. Salir
Seleccione una opción: 1

--- REGISTRAR NUEVO PRODUCTO ---
Ingrese ID numérico del producto: 105
Ingrese el nombre del producto: Teclado Mecánico
 Proceso completado.

===========================================
  SISTEMA DE GESTIÓN DE INVENTARIO (ABB) 
===========================================
1. Registrar Producto
2. Mostrar Inventario (Recorrido Inorden)
3. Buscar Producto por ID
0. Salir
Seleccione una opción: 2

--- INVENTARIO ORDENADO POR ID (INORDEN) ---
  [ID: 101] -> Producto: Mouse Inalámbrico
  [ID: 105] -> Producto: Teclado Mecánico
  [ID: 200] -> Producto: Monitor 27 Pulgadas
```