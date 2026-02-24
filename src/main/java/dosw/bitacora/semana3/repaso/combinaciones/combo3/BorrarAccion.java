package dosw.bitacora.semana3.repaso.combinaciones.combo3;

public class BorrarAccion implements Accion {
    private Documento doc;

    public BorrarAccion(Documento doc) { this.doc = doc; }

    @Override public void ejecutar() { doc.borrarUltima(); }
}
