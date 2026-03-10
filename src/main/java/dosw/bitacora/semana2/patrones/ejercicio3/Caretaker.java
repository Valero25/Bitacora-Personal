package dosw.bitacora.semana2.patrones.ejercicio3;

import java.util.List;
import java.util.ArrayList;

/**
 * Caretaker que maneja el historial
 */
public class Caretaker {
    private List<TextMemento> history = new ArrayList<>();

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