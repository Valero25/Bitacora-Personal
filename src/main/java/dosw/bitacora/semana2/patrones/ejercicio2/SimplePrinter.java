package dosw.bitacora.semana2.patrones.ejercicio2;

/**
 * Clase A: Impresora simple
 */
public class SimplePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("Imprimiendo mensaje: " + message);
    }
}