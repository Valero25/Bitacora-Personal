package dosw.bitacora.semana3.repaso.combinaciones.combo2;

public class ToppingJamon extends ToppingDecorador {
    public ToppingJamon(Pizza pizza) { super(pizza); }

    @Override public String descripcion() { return pizza.descripcion() + " + jamón"; }
    @Override public double precio()      { return pizza.precio() + 2.0; }
}
