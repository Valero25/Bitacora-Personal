package dosw.bitacora.semana3.repaso.base.strategy;

/**
 * Contexto: delega el algoritmo a la estrategia.
 * Se puede cambiar en tiempo de ejecución con setEstrategia().
 */
public class Sorter {
    private Ordenamiento estrategia;

    public Sorter(Ordenamiento estrategia) { this.estrategia = estrategia; }

    public void setEstrategia(Ordenamiento estrategia) { this.estrategia = estrategia; }

    public void ordenar(int[] datos) { estrategia.ordenar(datos); }
}
