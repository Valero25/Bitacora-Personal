package dosw.bitacora.semana3.repaso.base.builder;

public class RepasoBuilder {
    public static void main(String[] args) {
        Ensamblador director = new Ensamblador();

        ComputadoraBuilder gamer = new ComputadoraGaming();
        director.ensamblar(gamer);
        System.out.println(gamer.getResultado());

        ComputadoraBuilder oficina = new ComputadoraOficina();
        director.ensamblar(oficina);
        System.out.println(oficina.getResultado());
    }
}
