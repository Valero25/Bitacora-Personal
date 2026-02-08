package dosw.bitacora.semana3.patrones.ejercicio2;

/**
 * Motor del juego que usa la fábrica para crear componentes
 * No conoce las implementaciones concretas de los componentes
 */
public class GameEngine {
    private Controller controller;
    private Game game;
    private UI ui;
    
    public GameEngine(ConsoleFactory factory) {
        this.controller = factory.createController();
        this.game = factory.createGame();
        this.ui = factory.createUI();
    }
    
    public void run() {
        controller.connect();
        game.start();
        ui.render();
    }
}
