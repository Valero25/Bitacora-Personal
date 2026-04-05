package dosw.bitacora.semana3.repaso.base.chainofresponsibility;

public class Director extends AprobadorBase {
    @Override
    public void aprobar(int monto) {
        System.out.println("[Director] Aprueba $" + monto);
    }
}
