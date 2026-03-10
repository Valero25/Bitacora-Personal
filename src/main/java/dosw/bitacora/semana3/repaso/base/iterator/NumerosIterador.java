package dosw.bitacora.semana3.repaso.base.iterator;

public class NumerosIterador implements Iterador<Integer> {
    private int[] datos;
    private int index = 0;

    public NumerosIterador(int[] datos) { this.datos = datos; }

    @Override public boolean hasNext() { return index < datos.length; }
    @Override public Integer next()    { return datos[index++]; }
}
