package dosw.bitacora.semana3.repaso.combinaciones.combo3;

public class EscribirAccion implements Accion {
    private Documento doc;
    private String palabra;

    public EscribirAccion(Documento doc, String palabra) {
        this.doc = doc;
        this.palabra = palabra;
    }

    @Override public void ejecutar() { doc.escribir(palabra); }
}
