package dosw.bitacora.semana3.patrones.ejercicio9;

import java.util.List;

/**
 * Ejercicio9 - Patrón Command
 * Un personaje de videojuego ejecuta acciones encapsuladas como comandos.
 * El GameController ejecuta cualquier acción sin conocer su implementación interna.
 */
public class Ejercicio9 {

    public static void main(String[] args) {

        GameCharacter character = new GameCharacter();
        GameController controller = new GameController();

        List<Command> actions = List.of(
                new WalkCommand(character),
                new JumpCommand(character),
                new AttackCommand(character),
                new DefendCommand(character)
        );

        actions.forEach(controller::pressButton);
    }
}
