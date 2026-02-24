package dosw.bitacora.semana3.repaso.base.composite;

/**
 * ============================================================
 * PATRÓN: Composite  (Estructural)
 * ============================================================
 * PROBLEMA QUE RESUELVE:
 *   Cuando tienes una estructura árbol (parte-todo) y quieres tratar
 *   objetos individuales (hojas) y grupos (nodos) de forma uniforme.
 *   Sin el patrón, el cliente necesita saber si algo es hoja o nodo.
 *
 * CÓMO LEER ESTE EJERCICIO:
 *   1. Componente (interfaz) define la operación común: mostrar(String indent).
 *   2. Archivo (hoja/leaf) es un nodo sin hijos — simplemente se muestra.
 *   3. Carpeta (composite) contiene una lista de Componentes.
 *      Su mostrar() itera hijos y llama mostrar() en cada uno → recursión.
 *   4. El cliente llama raiz.mostrar("") y el árbol entero se imprime
 *      sin que el cliente sepa qué es hoja y qué es carpeta.
 *
 * SEÑAL PARA USARLO:
 *   Sistemas de archivos, menús con submenús, organigramas,
 *   expresiones matemáticas con sub-expresiones.
 *
 * ANALOGÍA EN LA VIDA REAL:
 *   El explorador de archivos de tu OS: una carpeta y un archivo
 *   tienen la misma operación "copiar", aunque internamente difieran.
 *
 * DIAGRAMA MENTAL:
 *   Componente (interfaz: mostrar)
 *       ├── Archivo     (hoja — sin hijos)
 *       └── Carpeta     (compuesto — List<Componente>)
 *                └── puede contener Archivos y otras Carpetas
 * ============================================================
 */
public class RepasoComposite {
    public static void main(String[] args) {
        Carpeta raiz = new Carpeta("raiz");
        raiz.agregar(new Archivo("readme.txt"));

        Carpeta src = new Carpeta("src");
        src.agregar(new Archivo("Main.java"));
        src.agregar(new Archivo("App.java"));

        raiz.agregar(src);
        raiz.mostrar("");
    }
}
