package dosw.bitacora.semana2.patrones;

/**
 * Ejercicio 2: Patrón Estructural (Adapter)
 * Adapter para impresoras.
 */

// Interfaz común que el sistema espera
interface Printer {
    void print(String message);
}

// Clase A: Impresora simple
class SimplePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("Imprimiendo mensaje: " + message);
    }
}

// Clase B: Impresora detallada
class DetailedPrinter {
    public void print(String message, String author, String date) {
        System.out.println("Mensaje: " + message + " | Autor: " + author + " | Fecha: " + date);
    }
}

// Adapter que hace que DetailedPrinter se comporte como Printer
class DetailedPrinterAdapter implements Printer {
    private DetailedPrinter detailedPrinter;
    private String author;
    private String date;

    public DetailedPrinterAdapter(String author, String date) {
        this.detailedPrinter = new DetailedPrinter();
        this.author = author;
        this.date = date;
    }

    @Override
    public void print(String message) {
        detailedPrinter.print(message, author, date);
    }
}

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
