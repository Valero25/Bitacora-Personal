package dosw.bitacora.semana3.patrones.ejercicio9;

/**
 * JumpCommand - Comando concreto del patrón Command
 * Encapsula la acción de saltar del personaje
 */
public class JumpCommand implements Command {

    private GameCharacter character;

    public JumpCommand(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.jump();
    }
}
