package dosw.bitacora.semana3.repaso.base.abstractfactory;

public class RepasoAbstractFactory {
    static void amueblar(FabricaMuebles fabrica) {
        fabrica.crearSilla().describir();
        fabrica.crearMesa().describir();
    }

    public static void main(String[] args) {
        System.out.println("-- Estilo Moderno --");
        amueblar(new FabricaModerna());

        System.out.println("-- Estilo Victoriano --");
        amueblar(new FabricaVictoriana());
    }
}
