package dosw.bitacora.semana3.repaso.base.command;

public class RepasoCommand {
    public static void main(String[] args) {
        Luz luz = new Luz();
        ControlRemoto control = new ControlRemoto();

        control.presionar(new EncenderLuz(luz));
        control.presionar(new ApagarLuz(luz));
    }
}
