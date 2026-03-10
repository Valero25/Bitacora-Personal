package dosw.bitacora.semana3.patrones.ejercicio11;

/**
 * CheapestRoute - Estrategia concreta del patrón Strategy
 * Calcula la ruta más económica
 */
public class CheapestRoute implements RouteStrategy {

    @Override
    public void calculateRoute() {
        System.out.println("[CheapestRoute] Calculando la ruta más económica.");
    }
}
