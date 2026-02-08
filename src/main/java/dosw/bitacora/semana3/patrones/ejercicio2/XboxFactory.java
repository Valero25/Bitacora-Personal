package dosw.bitacora.semana3.patrones.ejercicio2;

/**
 * Fábrica concreta para crear componentes de Xbox
 */
public class XboxFactory extends ConsoleFactory {
    @Override
    public Controller createController() {
        return new XboxController();
    }
    
    @Override
    public Game createGame() {
        return new XboxGame();
    }
    
    @Override
    public UI createUI() {
        return new XboxUI();
    }
}
