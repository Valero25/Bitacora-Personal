package dosw.bitacora.semana3.repaso.combinaciones.combo1;

/**
 * COMBO 1: Factory Method + Strategy
 * ──────────────────────────────────
 * Problema: Una app de transporte debe calcular rutas de forma diferente
 * según el medio (auto, bici, bus). Queremos que la forma de calcular sea
 * intercambiable (Strategy) y que cada medio se cree a través de un método
 * fábrica (Factory Method) sin exponer las clases concretas.
 *
 * Factory Method → crea el TransporteStrategy correcto.
 * Strategy       → cada TransporteStrategy encapsula el algoritmo de ruta.
 */
public interface TransporteStrategy {
    void calcularRuta(String origen, String destino);
}
