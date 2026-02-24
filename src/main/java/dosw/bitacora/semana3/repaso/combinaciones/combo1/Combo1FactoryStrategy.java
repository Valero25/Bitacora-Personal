package dosw.bitacora.semana3.repaso.combinaciones.combo1;

import java.util.List;

public class Combo1FactoryStrategy {
    public static void main(String[] args) {
        List<TransporteCreador> creadores = List.of(
            new AutoCreador(),
            new BiciCreador(),
            new BusCreador()
        );

        for (TransporteCreador creador : creadores) {
            creador.navegar("Casa", "Trabajo");
        }
    }
}
