package dosw.bitacora.semana2.patrones.ejercicio2;

/**
 * Clase principal para el Ejercicio 2: Patrón Estructural (Adapter)
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        // Usar impresora simple
        Printer simple = new SimplePrinter();
        simple.print("Mensaje simple");

        // Usar impresora detallada a través del adapter
        Printer detailed = new DetailedPrinterAdapter("Juan", "2023-10-01");
        detailed.print("Mensaje detallado");
    }
}