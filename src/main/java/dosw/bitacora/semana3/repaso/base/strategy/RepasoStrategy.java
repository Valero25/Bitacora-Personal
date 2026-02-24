package dosw.bitacora.semana3.repaso.base.strategy;

public class RepasoStrategy {
    public static void main(String[] args) {
        Sorter sorter = new Sorter(new OrdenamientoBurbuja());
        sorter.ordenar(new int[]{5, 3, 1, 4, 2});

        sorter.setEstrategia(new OrdenamientoQuick());
        sorter.ordenar(new int[]{5, 3, 1, 4, 2});
    }
}
