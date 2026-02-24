package dosw.bitacora.semana3.repaso.base.factorymethod;

public class RepasoFactoryMethod {
    public static void main(String[] args) {
        Notificador n1 = new NotificadorEmail();
        Notificador n2 = new NotificadorSMS();

        n1.notificar("Bienvenido!");
        n2.notificar("Tu codigo es 1234");
    }
}
