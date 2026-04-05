package dosw.bitacora.semana3.repaso.base.builder;

/** Producto a construir paso a paso */
public class Computadora {
    private String cpu;
    private String ram;
    private String almacenamiento;

    public void setCpu(String cpu)                     { this.cpu = cpu; }
    public void setRam(String ram)                     { this.ram = ram; }
    public void setAlmacenamiento(String almacenamiento) { this.almacenamiento = almacenamiento; }

    @Override
    public String toString() {
        return "Computadora [CPU=" + cpu + ", RAM=" + ram + ", Disco=" + almacenamiento + "]";
    }
}
