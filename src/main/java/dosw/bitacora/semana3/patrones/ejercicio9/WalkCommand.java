package dosw.bitacora.semana3.patrones.ejercicio9;

/**
 * WalkCommand - Comando concreto del patrón Command
 * Encapsula la acción de caminar del personaje
 */
public class WalkCommand implements Command {

    private GameCharacter character;

    public WalkCommand(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.walk();
    }
}
