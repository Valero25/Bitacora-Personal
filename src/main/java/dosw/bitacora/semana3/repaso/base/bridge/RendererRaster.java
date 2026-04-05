package dosw.bitacora.semana3.repaso.base.bridge;

public class RendererRaster implements Renderer {
    @Override public void renderCirculo(int r)    { System.out.println("[Raster] Circulo r=" + r); }
    @Override public void renderCuadrado(int lado){ System.out.println("[Raster] Cuadrado l=" + lado); }
}
