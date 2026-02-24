package dosw.bitacora.semana3.repaso.base.bridge;

public class Circulo extends Forma {
    private int radio;

    public Circulo(Renderer renderer, int radio) {
        super(renderer);
        this.radio = radio;
    }

    @Override public void dibujar() { renderer.renderCirculo(radio); }
}
