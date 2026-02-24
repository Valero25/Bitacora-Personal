package dosw.bitacora.semana3.repaso.base.chainofresponsibility;

public class RepasoChainOfResponsibility {
    public static void main(String[] args) {
        Aprobador supervisor = new Supervisor();
        Aprobador gerente    = new Gerente();
        Aprobador director   = new Director();

        supervisor.setSiguiente(gerente);
        gerente.setSiguiente(director);

        supervisor.aprobar(200);
        supervisor.aprobar(1500);
        supervisor.aprobar(10000);
    }
}
