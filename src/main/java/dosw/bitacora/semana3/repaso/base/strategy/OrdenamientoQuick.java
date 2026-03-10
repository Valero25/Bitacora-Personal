package dosw.bitacora.semana3.repaso.base.strategy;

import java.util.Arrays;

public class OrdenamientoQuick implements Ordenamiento {
    @Override
    public void ordenar(int[] datos) {
        Arrays.sort(datos);
        System.out.println("[QuickSort] " + Arrays.toString(datos));
    }
}
