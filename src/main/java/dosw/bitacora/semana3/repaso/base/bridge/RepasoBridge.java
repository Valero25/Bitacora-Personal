package dosw.bitacora.semana3.repaso.base.bridge;

public class RepasoBridge {
    public static void main(String[] args) {
        Forma c1 = new Circulo(new RendererVectorial(), 5);
        Forma c2 = new Circulo(new RendererRaster(), 5);
        Forma q1 = new Cuadrado(new RendererVectorial(), 10);

        c1.dibujar();
        c2.dibujar();
        q1.dibujar();
    }
}
