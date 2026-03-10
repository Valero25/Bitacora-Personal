package dosw.bitacora.semana3.patrones.ejercicio9;

/**
 * DefendCommand - Comando concreto del patrón Command
 * Encapsula la acción de defenderse del personaje
 */
public class DefendCommand implements Command {

    private GameCharacter character;

    public DefendCommand(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.defend();
    }
}
