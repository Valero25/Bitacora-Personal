package dosw.bitacora.semana3.repaso.base.iterator;

public class RepasoIterator {
    public static void main(String[] args) {
        ListaNumeros lista = new ListaNumeros(10, 20, 30, 40, 50);
        Iterador<Integer> it = lista.crearIterador();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
