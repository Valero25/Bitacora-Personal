package dosw.bitacora.semana3.patrones.ejercicio9;

/**
 * GameCharacter - Receptor del patrón Command
 * Implementa las acciones concretas del personaje de videojuego
 */
public class GameCharacter {

    public void walk() {
        System.out.println("[GameCharacter] El personaje está caminando.");
    }

    public void jump() {
        System.out.println("[GameCharacter] El personaje saltó.");
    }

    public void attack() {
        System.out.println("[GameCharacter] El personaje atacó.");
    }

    public void defend() {
        System.out.println("[GameCharacter] El personaje se está defendiendo.");
    }
}
