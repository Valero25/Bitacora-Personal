package dosw.bitacora.semana3.patrones.ejercicio5;

/**
 * Circulo - Abstracción refinada de Forma
 */
public class Circulo extends Forma {
    
    public Circulo(Color color) {
        super(color);
    }
    
    @Override
    public void dibujar() {
        System.out.println("Dibujando Círculo de color " + color.getColor());
    }
}
