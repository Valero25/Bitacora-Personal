package dosw.bitacora.semana3.repaso.combinaciones.combo3;

import java.util.ArrayList;
import java.util.List;

/** Invocador: graba y reproduce la macro con su propio iterador */
public class MacroGrabador {
    private List<Accion> historial = new ArrayList<>();

    public void grabar(Accion accion) { historial.add(accion); }

    public IteradorAcciones iterador() { return new HistorialIterador(historial); }
}
