package dosw.bitacora.semana3.repaso.base.adapter;

/** Adaptee: librería existente con interfaz incompatible */
public class ReproductorLegacy {
    public void playFile(String path) {
        System.out.println("[Legacy] Reproduciendo: " + path);
    }
}
