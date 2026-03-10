package dosw.bitacora.semana3.patrones.ejercicio2;

/**
 * Fábrica concreta para crear componentes de PlayStation
 */
public class PlayStationFactory extends ConsoleFactory {
    @Override
    public Controller createController() {
        return new PlayStationController();
    }
    
    @Override
    public Game createGame() {
        return new PlayStationGame();
    }
    
    @Override
    public UI createUI() {
        return new PlayStationUI();
    }
}
