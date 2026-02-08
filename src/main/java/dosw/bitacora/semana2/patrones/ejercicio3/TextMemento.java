package dosw.bitacora.semana2.patrones.ejercicio3;

/**
 * Memento que guarda el estado
 */
public class TextMemento {
    private String state;

    public TextMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}