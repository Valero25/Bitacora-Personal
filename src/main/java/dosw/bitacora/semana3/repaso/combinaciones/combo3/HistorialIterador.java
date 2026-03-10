package dosw.bitacora.semana3.repaso.combinaciones.combo3;

import java.util.List;

public class HistorialIterador implements IteradorAcciones {
    private List<Accion> historial;
    private int index = 0;

    public HistorialIterador(List<Accion> historial) { this.historial = historial; }

    @Override public boolean hasNext() { return index < historial.size(); }
    @Override public Accion next()     { return historial.get(index++); }
}
