package dosw.bitacora.semana3.repaso.base.builder;

public class ComputadoraOficina implements ComputadoraBuilder {
    private Computadora pc = new Computadora();

    @Override public void buildCpu()            { pc.setCpu("Intel i5"); }
    @Override public void buildRam()            { pc.setRam("8GB DDR4"); }
    @Override public void buildAlmacenamiento() { pc.setAlmacenamiento("256GB SSD"); }
    @Override public Computadora getResultado() { return pc; }
}
