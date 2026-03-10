package dosw.bitacora.semana3.patrones.ejercicio11;

/**
 * FastestRoute - Estrategia concreta del patrón Strategy
 * Calcula la ruta más rápida
 */
public class FastestRoute implements RouteStrategy {

    @Override
    public void calculateRoute() {
        System.out.println("[FastestRoute] Calculando la ruta más rápida.");
    }
}
