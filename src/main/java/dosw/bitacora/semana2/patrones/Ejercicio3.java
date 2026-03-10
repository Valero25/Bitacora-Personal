package dosw.bitacora.semana2.patrones;

/**
 * Ejercicio 3: Patrón de Comportamiento (Memento)
 * Memento para editor de texto.
 */

// Memento que guarda el estado
class TextMemento {
    private String state;

    public TextMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Editor de texto
class TextEditor {
    private String text;

    public TextEditor(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // Crear memento
    public TextMemento save() {
        return new TextMemento(text);
    }

    // Restaurar desde memento
    public void restore(TextMemento memento) {
        this.text = memento.getState();
    }
}

// Caretaker que maneja el historial
class Caretaker {
    private java.util.List<TextMemento> history = new java.util.ArrayList<>();

    public void addMemento(TextMemento memento) {
        history.add(memento);
    }

    public TextMemento getMemento(int index) {
        return history.get(index);
    }

    public int getHistorySize() {
        return history.size();
    }
}

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
