package dosw.bitacora.semana3.patrones.ejercicio11;

/**
 * Ejercicio11 - Patrón Strategy
 * Una aplicación de navegación calcula rutas de distintas maneras.
 * El algoritmo de cálculo puede cambiar en tiempo de ejecución sin modificar la app.
 */
public class Ejercicio11 {

    public static void main(String[] args) {

        NavigationApp app = new NavigationApp(new FastestRoute());
        app.startNavigation();

        app.setRouteStrategy(new ScenicRoute());
        app.startNavigation();

        app.setRouteStrategy(new CheapestRoute());
        app.startNavigation();
    }
}
