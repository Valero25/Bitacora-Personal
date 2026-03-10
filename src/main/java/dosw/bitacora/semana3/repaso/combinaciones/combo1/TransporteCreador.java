package dosw.bitacora.semana3.repaso.combinaciones.combo1;

/**
 * Creador abstracto con Factory Method: crearEstrategia().
 * El contexto delega el cálculo a la estrategia producida por la fábrica.
 */
public abstract class TransporteCreador {
    protected abstract TransporteStrategy crearEstrategia();

    public void navegar(String origen, String destino) {
        TransporteStrategy estrategia = crearEstrategia(); // Factory Method
        estrategia.calcularRuta(origen, destino);           // Strategy
    }
}
