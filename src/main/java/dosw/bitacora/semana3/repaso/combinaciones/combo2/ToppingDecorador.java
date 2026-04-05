package dosw.bitacora.semana3.repaso.combinaciones.combo2;

/** Decorador base */
public abstract class ToppingDecorador implements Pizza {
    protected Pizza pizza;
    public ToppingDecorador(Pizza pizza) { this.pizza = pizza; }
}
