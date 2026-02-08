package dosw.bitacora.semana2.patrones.ejercicio3;

/**
 * Clase principal para el Ejercicio 3: Patrón de Comportamiento (Memento)
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor("Texto inicial");
        Caretaker caretaker = new Caretaker();

        System.out.println("Texto inicial: " + editor.getText());

        // Modificar y guardar
        editor.setText("Texto modificado 1");
        caretaker.addMemento(editor.save());
        System.out.println("Después de modificación 1: " + editor.getText());

        // Modificar y guardar
        editor.setText("Texto modificado 2");
        caretaker.addMemento(editor.save());
        System.out.println("Después de modificación 2: " + editor.getText());

        // Restaurar al primer estado
        editor.restore(caretaker.getMemento(0));
        System.out.println("Después de restaurar: " + editor.getText());
    }
}