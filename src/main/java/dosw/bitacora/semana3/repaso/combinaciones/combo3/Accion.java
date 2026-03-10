package dosw.bitacora.semana3.repaso.combinaciones.combo3;

/**
 * COMBO 3: Command + Iterator
 * ────────────────────────────
 * Problema: Un editor de texto necesita grabar acciones del usuario
 * (Command) y luego reproducirlas en orden (Iterator) — una macro.
 *
 * Command  → cada acción (escribir, borrar) se encapsula como objeto.
 * Iterator → recorre el historial de comandos para ejecutarlos en secuencia.
 */
public interface Accion {
    void ejecutar();
}
