package dosw.bitacora.semana3.repaso.combinaciones.combo3;

/**
 * ============================================================
 * COMBO 3: Command + Iterator
 * ============================================================
 * ESCENARIO:
 *   Un editor de texto permite grabar secuencias de acciones del
 *   usuario (macros) y luego reproducirlas. Cada acción debe ser
 *   un objeto almacenable (Command) y la reproducción debe recorrer
 *   ese historial en orden (Iterator).
 *
 * POR QUÉ ESTOS DOS JUNTOS:
 *   Command  → convierte cada acción (escribir, borrar) en un objeto
 *              que se puede guardar, encolar y reproducir.
 *   Iterator → ofrece una forma uniforme de recorrer el historial
 *              de comandos sin exponer cómo está almacenado.
 *
 * ROL DE CADA CLASE:
 *   Accion          (Command interfaz)    → ejecutar()
 *   Documento       (receptor)            → sabe escribir y borrar
 *   EscribirAccion  (comando concreto)    → llama doc.escribir(palabra)
 *   BorrarAccion    (comando concreto)    → llama doc.borrarUltima()
 *   MacroGrabador   (invocador/colección) → graba acciones y
 *                                           expone su iterador
 *   HistorialIterador (iterador concreto) → recorre la List<Accion>
 *
 * CÓMO LEER ESTE EJERCICIO:
 *   1. Durante la "grabación", macro.grabar(accion) guarda objetos Command.
 *      Nadie ejecuta nada todavía — las acciones están como objetos en memoria.
 *   2. Al reproducir, macro.iterador() devuelve un HistorialIterador.
 *   3. El while(it.hasNext()) recorre cada Command y llama ejecutar() —
 *      el Iterator no sabe qué hace cada Command; el Command no sabe
 *      nada del Iterator. Están desacoplados.
 *
 * EXTENSIÓN NATURAL:
 *   Agrega deshacer() en la interfaz Accion → tienes un sistema de undo/redo
 *   recorriendo el historial con un Iterator en sentido inverso.
 * ============================================================
 */
public class Combo3CommandIterator {
    public static void main(String[] args) {
        Documento doc = new Documento();
        MacroGrabador macro = new MacroGrabador();

        // Grabamos la macro (Command)
        macro.grabar(new EscribirAccion(doc, "Hola"));
        macro.grabar(new EscribirAccion(doc, "mundo"));
        macro.grabar(new EscribirAccion(doc, "ERROR"));
        macro.grabar(new BorrarAccion(doc));
        macro.grabar(new EscribirAccion(doc, "Java"));

        System.out.println("\n--- Reproduciendo macro ---");
        // Iterator recorre y ejecuta los comandos
        IteradorAcciones it = macro.iterador();
        while (it.hasNext()) {
            it.next().ejecutar();
        }
    }
}
