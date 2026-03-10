package dosw.bitacora.semana3.patrones.ejercicio2;

/**
 * Abstract Factory - Fábrica abstracta para crear familias de componentes de consolas
 */
public abstract class ConsoleFactory {
    public abstract Controller createController();
    public abstract Game createGame();
    public abstract UI createUI();
}
