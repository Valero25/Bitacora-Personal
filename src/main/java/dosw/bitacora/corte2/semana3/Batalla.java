package dosw.bitacora.corte2.semana3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Batalla {
    private Usuario jugador1;
    private Usuario jugador2;
    private Criatura criatura1;
    private Criatura criatura2;
    private List<String> log;
    private String resultado;
    private Random random;

    public Batalla(Usuario jugador1, Criatura criatura1, Usuario jugador2, Criatura criatura2, long seed) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.criatura1 = criatura1;
        this.criatura2 = criatura2;
        this.log = new ArrayList<>();
        this.random = new Random(seed); // seed para resultados deterministas (RF-06)
    }

    public String ejecutar() {
        log.add("=== BATALLA: " + jugador1.getNombre() + " vs " + jugador2.getNombre() + " ===");
        log.add(criatura1 + " VS " + criatura2);
        log.add("");

        criatura1.restaurarHp();
        criatura2.restaurarHp();

        int turno = 1;
        while (criatura1.estaVivo() && criatura2.estaVivo()) {
            log.add("--- Turno " + turno + " ---");

            if (criatura1.getVelocidad() >= criatura2.getVelocidad()) {
                ejecutarAtaque(criatura1, criatura2);
                if (criatura2.estaVivo()) {
                    ejecutarAtaque(criatura2, criatura1);
                }
            } else {
                ejecutarAtaque(criatura2, criatura1);
                if (criatura1.estaVivo()) {
                    ejecutarAtaque(criatura1, criatura2);
                }
            }

            log.add(criatura1.getNombre() + " HP:" + criatura1.getHp() + "/" + criatura1.getHpMax());
            log.add(criatura2.getNombre() + " HP:" + criatura2.getHp() + "/" + criatura2.getHpMax());
            log.add("");
            turno++;
        }

        Usuario ganador;
        Usuario perdedor;
        if (criatura1.estaVivo()) {
            ganador = jugador1;
            perdedor = jugador2;
            resultado = jugador1.getNombre() + " gana con " + criatura1.getNombre();
        } else {
            ganador = jugador2;
            perdedor = jugador1;
            resultado = jugador2.getNombre() + " gana con " + criatura2.getNombre();
        }

        int[] cambiosElo = Matchmaking.calcularCambioElo(ganador.getElo(), perdedor.getElo());
        ganador.actualizarElo(cambiosElo[0]);
        perdedor.actualizarElo(cambiosElo[1]);

        log.add("=== RESULTADO: " + resultado + " ===");
        log.add("ELO " + ganador.getNombre() + ": +" + cambiosElo[0]);
        log.add("ELO " + perdedor.getNombre() + ": " + cambiosElo[1]);

        return resultado;
    }

    private void ejecutarAtaque(Criatura atacante, Criatura defensor) {
        if (atacante.getHabilidades().isEmpty()) return;

        Habilidad habilidad = atacante.getHabilidades().get(random.nextInt(atacante.getHabilidades().size()));

        int tirada = random.nextInt(100) + 1;
        if (tirada > habilidad.getPrecision()) {
            log.add(atacante.getNombre() + " usa " + habilidad.getNombre() + "... ¡Falla!");
            return;
        }

        double multiplicadorTipo = atacante.getTipo().getMultiplicador(defensor.getTipo());
        int dano = (int) ((habilidad.getPoder() + atacante.getAtaque() - defensor.getDefensa() / 2) * multiplicadorTipo);
        dano = Math.max(1, dano);

        defensor.recibirDano(dano);
        String eficacia = multiplicadorTipo > 1.0 ? " ¡Muy eficaz!" : (multiplicadorTipo < 1.0 ? " No muy eficaz..." : "");
        log.add(atacante.getNombre() + " usa " + habilidad.getNombre() + " -> " + dano + " daño." + eficacia);
    }

    public List<String> getLog() { return log; }
    public String getResultado() { return resultado; }
}
