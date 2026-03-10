package dosw.bitacora.semana3.patrones.ejercicio11;

/**
 * NavigationApp - Contexto del patrón Strategy
 * Delega el cálculo de ruta a la estrategia configurada, sin acoplarse a ninguna implementación
 */
public class NavigationApp {

    private RouteStrategy routeStrategy;

    public NavigationApp(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void startNavigation() {
        routeStrategy.calculateRoute();
    }
}
