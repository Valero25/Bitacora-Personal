package dosw.bitacora.semana2.solid.ejercicio4;

/**
 * Operación de suma
 */
public class Add implements Operation {
    @Override
    public double execute(double a, double b) {
        return a + b;
    }
}