package dosw.bitacora.semana3.patrones.ejercicio11;

/**
 * ScenicRoute - Estrategia concreta del patrón Strategy
 * Calcula la ruta más panorámica
 */
public class ScenicRoute implements RouteStrategy {

    @Override
    public void calculateRoute() {
        System.out.println("[ScenicRoute] Calculando la ruta más panorámica.");
    }
}
