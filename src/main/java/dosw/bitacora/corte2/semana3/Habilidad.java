package dosw.bitacora.corte2.semana3;

public class Habilidad {
    private String nombre;
    private Tipo tipo;
    private int poder;
    private int costoEnergia;
    private int precision; // 0-100
    private String efectoSecundario;

    public Habilidad(String nombre, Tipo tipo, int poder, int costoEnergia, int precision) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.poder = poder;
        this.costoEnergia = costoEnergia;
        this.precision = precision;
        this.efectoSecundario = null;
    }

    public Habilidad(String nombre, Tipo tipo, int poder, int costoEnergia, int precision, String efectoSecundario) {
        this(nombre, tipo, poder, costoEnergia, precision);
        this.efectoSecundario = efectoSecundario;
    }

    public String getNombre() { return nombre; }
    public Tipo getTipo() { return tipo; }
    public int getPoder() { return poder; }
    public int getCostoEnergia() { return costoEnergia; }
    public int getPrecision() { return precision; }
    public String getEfectoSecundario() { return efectoSecundario; }

    @Override
    public String toString() {
        return nombre + " [" + tipo + " | Poder:" + poder + " | Costo:" + costoEnergia + " | Precisión:" + precision + "%]";
    }
}
