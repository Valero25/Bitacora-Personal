package dosw.bitacora.corte2.semana3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║   Plataforma de Batallas Bakugan - Prototipo    ║");
        System.out.println("║   Análisis de Requerimientos (Parte 1)          ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        // --- Crear habilidades ---
        Habilidad llamarada = new Habilidad("Llamarada", Tipo.FUEGO, 40, 3, 90);
        Habilidad inferno = new Habilidad("Inferno", Tipo.FUEGO, 70, 5, 70, "Quemadura");
        Habilidad torrente = new Habilidad("Torrente", Tipo.AGUA, 45, 3, 85);
        Habilidad maremoto = new Habilidad("Maremoto", Tipo.AGUA, 65, 5, 75);
        Habilidad terremoto = new Habilidad("Terremoto", Tipo.TIERRA, 50, 4, 80);
        Habilidad vendaval = new Habilidad("Vendaval", Tipo.VIENTO, 35, 2, 95);

        // --- Crear criaturas con balance de stats ---
        System.out.println(">>> Creando criaturas...\n");

        Criatura dragonoid = new Criatura("Dragonoid", Tipo.FUEGO, "Legendaria", 120, 45, 30, 35);
        dragonoid.agregarHabilidad(llamarada);
        dragonoid.agregarHabilidad(inferno);

        Criatura preyas = new Criatura("Preyas", Tipo.AGUA, "Rara", 110, 35, 35, 40);
        preyas.agregarHabilidad(torrente);
        preyas.agregarHabilidad(maremoto);

        Criatura gorem = new Criatura("Gorem", Tipo.TIERRA, "Rara", 140, 40, 45, 20);
        gorem.agregarHabilidad(terremoto);

        Criatura skyress = new Criatura("Skyress", Tipo.VIENTO, "Épica", 100, 38, 25, 50);
        skyress.agregarHabilidad(vendaval);

        System.out.println("Criaturas creadas:");
        System.out.println("  " + dragonoid);
        System.out.println("  " + preyas);
        System.out.println("  " + gorem);
        System.out.println("  " + skyress);

        // --- Demostración de balance de tipos ---
        System.out.println("\n>>> Sistema de tipos (balance):\n");
        System.out.println("  FUEGO vs TIERRA: x" + Tipo.FUEGO.getMultiplicador(Tipo.TIERRA));
        System.out.println("  AGUA  vs FUEGO:  x" + Tipo.AGUA.getMultiplicador(Tipo.FUEGO));
        System.out.println("  FUEGO vs AGUA:   x" + Tipo.FUEGO.getMultiplicador(Tipo.AGUA));
        System.out.println("  VIENTO vs TIERRA: x" + Tipo.VIENTO.getMultiplicador(Tipo.TIERRA));

        // --- Crear usuarios ---
        System.out.println("\n>>> Creando jugadores...\n");

        Usuario dan = new Usuario("U001", "Dan Kuso", "dan@bakugan.com");
        dan.agregarCriatura(dragonoid);

        Usuario marucho = new Usuario("U002", "Marucho", "marucho@bakugan.com");
        marucho.agregarCriatura(preyas);

        Usuario julie = new Usuario("U003", "Julie", "julie@bakugan.com");
        julie.agregarCriatura(gorem);

        System.out.println("Jugadores registrados:");
        System.out.println("  " + dan);
        System.out.println("  " + marucho);
        System.out.println("  " + julie);

        // --- Demostración de matchmaking ---
        System.out.println("\n>>> Matchmaking (emparejamiento justo):\n");

        List<Usuario> jugadores = Arrays.asList(dan, marucho, julie);
        Usuario oponente = Matchmaking.buscarOponente(dan, jugadores);
        if (oponente != null) {
            System.out.println("Mejor oponente para " + dan.getNombre() + ": " + oponente.getNombre());
            System.out.println("Diferencia ELO: " + Math.abs(dan.getElo() - oponente.getElo()));
        }

        // --- Batalla con resultados consistentes (seed determinista) ---
        System.out.println("\n>>> Batalla (resultados consistentes con seed):\n");

        long seed = 42;
        Batalla batalla = new Batalla(dan, dragonoid, marucho, preyas, seed);
        batalla.ejecutar();

        for (String linea : batalla.getLog()) {
            System.out.println("  " + linea);
        }

        // --- Verificar consistencia: misma seed = mismo resultado ---
        System.out.println("\n>>> Verificación de consistencia (RF-06):\n");

        dragonoid.restaurarHp();
        preyas.restaurarHp();
        // Restaurar ELO para repetir
        dan.actualizarElo(-dan.getElo() + 1000);
        marucho.actualizarElo(-marucho.getElo() + 1000);

        Batalla batalla2 = new Batalla(dan, dragonoid, marucho, preyas, seed);
        batalla2.ejecutar();

        System.out.println("  Resultado batalla 1: " + batalla.getResultado());
        System.out.println("  Resultado batalla 2: " + batalla2.getResultado());
        System.out.println("  ¿Consistente? " + batalla.getResultado().equals(batalla2.getResultado()));

        // --- ELO post-batalla ---
        System.out.println("\n>>> ELO actualizado:");
        System.out.println("  " + dan);
        System.out.println("  " + marucho);
    }
}
