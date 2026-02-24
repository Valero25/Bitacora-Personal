package dosw.bitacora.semana3.repaso.combinaciones.combo1;

import java.util.List;

/**
 * ============================================================
 * COMBO 1: Factory Method + Strategy
 * ============================================================
 * ESCENARIO:
 *   Una app de transporte urbano necesita calcular rutas. Cada medio
 *   de transporte (auto, bici, bus) calcula la ruta de forma diferente
 *   (Strategy), y la app no quiere saber qué clase concreta instanciar
 *   (Factory Method).
 *
 * POR QUÉ ESTOS DOS JUNTOS:
 *   Factory Method → decide QUÉ estrategia crear según el tipo de transporte.
 *   Strategy       → define CÓMO calcular la ruta para ese medio.
 *   Resultado: el cliente pide navegar(origen, destino) sin saber ni
 *   qué creador ni qué algoritmo se ejecutó.
 *
 * CÓMO LEER ESTE EJERCICIO:
 *   1. TransporteCreador (abstract) tiene el Factory Method crearEstrategia()
 *      y el método navegar() que lo usa internamente.
 *   2. AutoCreador, BiciCreador, BusCreador sobreescriben crearEstrategia()
 *      devolviendo la Strategy adecuada para cada medio.
 *   3. RutaAuto, RutaBici, RutaBus (strategies) encapsulan el algoritmo
 *      de cálculo de ruta para su medio de transporte.
 *   4. En main, el for recorre los creadores y llama navegar() —
 *      cada uno instancia su propia estrategia internamente.
 *
 * PUNTO DE UNIÓN:
 *   crearEstrategia() es Factory Method → produce una TransporteStrategy.
 *   calcularRuta() es Strategy         → usa esa TransporteStrategy.
 * ============================================================
 */
public class Combo1FactoryStrategy {
    public static void main(String[] args) {
        List<TransporteCreador> creadores = List.of(
            new AutoCreador(),
            new BiciCreador(),
            new BusCreador()
        );

        for (TransporteCreador creador : creadores) {
            creador.navegar("Casa", "Trabajo");
        }
    }
}
