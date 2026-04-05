package dosw.bitacora.semana3.patrones.ejercicio9;

/**
 * AttackCommand - Comando concreto del patrón Command
 * Encapsula la acción de atacar del personaje
 */
public class AttackCommand implements Command {

    private GameCharacter character;

    public AttackCommand(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.attack();
    }
}
