package dosw.bitacora.semana2.patrones.ejercicio3;

import java.util.List;
import java.util.ArrayList;

/**
 * Editor de texto
 */
public class TextEditor {
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