package dosw.bitacora.semana3.repaso.base.bridge;

public class RendererVectorial implements Renderer {
    @Override public void renderCirculo(int r)    { System.out.println("[Vector] Circulo r=" + r); }
    @Override public void renderCuadrado(int lado){ System.out.println("[Vector] Cuadrado l=" + lado); }
}
