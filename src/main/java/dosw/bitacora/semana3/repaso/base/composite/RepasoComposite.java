package dosw.bitacora.semana3.repaso.base.composite;

public class RepasoComposite {
    public static void main(String[] args) {
        Carpeta raiz = new Carpeta("raiz");
        raiz.agregar(new Archivo("readme.txt"));

        Carpeta src = new Carpeta("src");
        src.agregar(new Archivo("Main.java"));
        src.agregar(new Archivo("App.java"));

        raiz.agregar(src);
        raiz.mostrar("");
    }
}
