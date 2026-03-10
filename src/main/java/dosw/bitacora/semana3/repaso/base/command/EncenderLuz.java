package dosw.bitacora.semana3.repaso.base.command;

public class EncenderLuz implements Comando {
    private Luz luz;
    public EncenderLuz(Luz luz) { this.luz = luz; }

    @Override public void ejecutar() { luz.encender(); }
}
