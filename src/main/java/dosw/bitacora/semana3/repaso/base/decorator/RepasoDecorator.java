package dosw.bitacora.semana3.repaso.base.decorator;

public class RepasoDecorator {
    public static void main(String[] args) {
        Cafe c = new CafeSimple();
        System.out.println(c.getDescripcion() + " $" + c.getCosto());

        c = new Leche(c);
        System.out.println(c.getDescripcion() + " $" + c.getCosto());

        c = new Caramelo(c);
        System.out.println(c.getDescripcion() + " $" + c.getCosto());
    }
}
