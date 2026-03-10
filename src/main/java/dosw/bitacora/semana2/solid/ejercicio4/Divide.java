package dosw.bitacora.semana2.solid.ejercicio4;

/**
 * Operación de división
 */
public class Divide implements Operation {
    @Override
    public double execute(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return a / b;
    }
}