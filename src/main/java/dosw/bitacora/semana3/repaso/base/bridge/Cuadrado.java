package dosw.bitacora.semana3.repaso.base.bridge;

public class Cuadrado extends Forma {
    private int lado;

    public Cuadrado(Renderer renderer, int lado) {
        super(renderer);
        this.lado = lado;
    }

    @Override public void dibujar() { renderer.renderCuadrado(lado); }
}
