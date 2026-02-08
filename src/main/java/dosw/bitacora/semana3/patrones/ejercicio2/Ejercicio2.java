package dosw.bitacora.semana3.patrones.ejercicio2;

/**
 * Ejercicio 2: Sistema de desarrollo de videojuegos para múltiples consolas
 * 
 * Patrón utilizado:
 * - Abstract Factory: Proporciona una interfaz para crear familias de objetos relacionados
 *   sin especificar sus clases concretas
 * 
 * Ventajas:
 * - El motor del juego no conoce las implementaciones concretas de los componentes
 * - Cada consola ofrece una familia de componentes compatibles entre sí
 * - Facilita agregar nuevas consolas sin modificar el código existente
 * - Garantiza que los componentes de una familia sean compatibles
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Desarrollo de Videojuegos ===\n");
        
        // Crear motor de juego para PlayStation
        ConsoleFactory factory = new PlayStationFactory();
        GameEngine psEngine = new GameEngine(factory);
        System.out.println("--- PlayStation ---");
        psEngine.run();
        
        System.out.println("\n--------------------\n");
        
        // Crear motor de juego para Xbox
        factory = new XboxFactory();
        GameEngine xboxEngine = new GameEngine(factory);
        System.out.println("--- Xbox ---");
        xboxEngine.run();
        
        System.out.println("\n=== Ejecución Completa ===");
    }
}
