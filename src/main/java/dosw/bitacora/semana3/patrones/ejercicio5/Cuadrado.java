package dosw.bitacora.semana3.patrones.ejercicio5;

/**
 * Cuadrado - Abstracción refinada de Forma
 */
public class Cuadrado extends Forma {
    
    public Cuadrado(Color color) {
        super(color);
    }
    
    @Override
    public void dibujar() {
        System.out.println("Dibujando Cuadrado de color " + color.getColor());
    }
}
