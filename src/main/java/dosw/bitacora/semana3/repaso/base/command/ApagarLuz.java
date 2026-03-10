package dosw.bitacora.semana3.repaso.base.command;

public class ApagarLuz implements Comando {
    private Luz luz;
    public ApagarLuz(Luz luz) { this.luz = luz; }

    @Override public void ejecutar() { luz.apagar(); }
}
