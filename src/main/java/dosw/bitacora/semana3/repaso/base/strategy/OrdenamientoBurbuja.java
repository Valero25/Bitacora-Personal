package dosw.bitacora.semana3.repaso.base.strategy;

import java.util.Arrays;

public class OrdenamientoBurbuja implements Ordenamiento {
    @Override
    public void ordenar(int[] datos) {
        System.out.println("[Burbuja] " + Arrays.toString(datos));
    }
}
