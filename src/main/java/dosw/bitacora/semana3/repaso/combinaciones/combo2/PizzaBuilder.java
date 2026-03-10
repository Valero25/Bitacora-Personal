package dosw.bitacora.semana3.repaso.combinaciones.combo2;

/** Builder: encapsula la creación paso a paso de PizzaBase */
public class PizzaBuilder {
    private String tamano = "Mediana";
    private String masa   = "delgada";
    private String salsa  = "tomate";

    public PizzaBuilder tamano(String tamano)  { this.tamano = tamano; return this; }
    public PizzaBuilder masa(String masa)      { this.masa = masa;     return this; }
    public PizzaBuilder salsa(String salsa)    { this.salsa = salsa;   return this; }

    public PizzaBase build() {
        return new PizzaBase(tamano, masa, salsa);
    }
}
