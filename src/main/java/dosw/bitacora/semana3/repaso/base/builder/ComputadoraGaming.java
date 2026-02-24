package dosw.bitacora.semana3.repaso.base.builder;

public class ComputadoraGaming implements ComputadoraBuilder {
    private Computadora pc = new Computadora();

    @Override public void buildCpu()            { pc.setCpu("Intel i9"); }
    @Override public void buildRam()            { pc.setRam("32GB DDR5"); }
    @Override public void buildAlmacenamiento() { pc.setAlmacenamiento("2TB NVMe"); }
    @Override public Computadora getResultado() { return pc; }
}
