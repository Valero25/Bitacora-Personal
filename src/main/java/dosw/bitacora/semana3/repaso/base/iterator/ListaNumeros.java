package dosw.bitacora.semana3.repaso.base.iterator;

public class ListaNumeros implements Coleccion<Integer> {
    private int[] datos;

    public ListaNumeros(int... datos) { this.datos = datos; }

    @Override
    public Iterador<Integer> crearIterador() {
        return new NumerosIterador(datos);
    }
}
