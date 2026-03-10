package dosw.bitacora.semana3.repaso.combinaciones.combo2;

/** Producto creado por el Builder */
public class PizzaBase implements Pizza {
    private String tamano;
    private String masa;
    private String salsa;

    public PizzaBase(String tamano, String masa, String salsa) {
        this.tamano = tamano;
        this.masa = masa;
        this.salsa = salsa;
    }

    @Override public String descripcion() { return tamano + " | masa:" + masa + " | salsa:" + salsa; }
    @Override public double precio()      { return 8.0; }
}
