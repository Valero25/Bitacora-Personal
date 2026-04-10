package dosw.bitacora.corte2.semana3;

import java.util.List;

public class Matchmaking {
    private static final int RANGO_ELO_INICIAL = 100;
    private static final int RANGO_PODER_MAXIMO = 200;
    private static final int K_FACTOR = 32;

    public static Usuario buscarOponente(Usuario jugador, List<Usuario> jugadoresDisponibles) {
        Usuario mejorMatch = null;
        int menorDiferencia = Integer.MAX_VALUE;

        for (Usuario candidato : jugadoresDisponibles) {
            if (candidato.getId().equals(jugador.getId())) continue;

            int difElo = Math.abs(jugador.getElo() - candidato.getElo());
            int difPoder = Math.abs(jugador.getPoderTotal() - candidato.getPoderTotal());

            if (difElo <= RANGO_ELO_INICIAL && difPoder <= RANGO_PODER_MAXIMO) {
                int puntuacion = difElo + difPoder;
                if (puntuacion < menorDiferencia) {
                    menorDiferencia = puntuacion;
                    mejorMatch = candidato;
                }
            }
        }
        return mejorMatch;
    }

    public static int[] calcularCambioElo(int eloGanador, int eloPerdedor) {
        double expectativaGanador = 1.0 / (1.0 + Math.pow(10, (eloPerdedor - eloGanador) / 400.0));
        int cambioGanador = (int) Math.round(K_FACTOR * (1 - expectativaGanador));
        int cambioPerdedor = -cambioGanador;
        return new int[]{cambioGanador, cambioPerdedor};
    }
}
