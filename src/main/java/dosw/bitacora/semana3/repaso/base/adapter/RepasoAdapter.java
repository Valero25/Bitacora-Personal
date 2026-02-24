package dosw.bitacora.semana3.repaso.base.adapter;

public class RepasoAdapter {
    public static void main(String[] args) {
        Reproductor r = new ReproductorAdapter(new ReproductorLegacy());
        r.reproducir("cancion.mp3");
    }
}
