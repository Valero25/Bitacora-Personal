package dosw.bitacora.semana3.patrones.ejercicio9;

/**
 * GameController - Invocador del patrón Command
 * Ejecuta cualquier comando sin conocer su implementación interna
 */
public class GameController {

    public void pressButton(Command command) {
        command.execute();
    }
}
