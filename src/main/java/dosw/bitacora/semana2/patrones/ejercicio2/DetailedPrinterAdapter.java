package dosw.bitacora.semana2.patrones.ejercicio2;

/**
 * Adapter que hace que DetailedPrinter se comporte como Printer
 */
public class DetailedPrinterAdapter implements Printer {
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