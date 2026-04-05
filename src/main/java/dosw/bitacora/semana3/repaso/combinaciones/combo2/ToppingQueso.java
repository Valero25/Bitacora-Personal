package dosw.bitacora.semana3.repaso.combinaciones.combo2;

public class ToppingQueso extends ToppingDecorador {
    public ToppingQueso(Pizza pizza) { super(pizza); }

    @Override public String descripcion() { return pizza.descripcion() + " + queso extra"; }
    @Override public double precio()      { return pizza.precio() + 1.5; }
}
