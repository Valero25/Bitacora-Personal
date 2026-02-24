package dosw.bitacora.semana3.repaso.base.chainofresponsibility;

public class Supervisor extends AprobadorBase {
    @Override
    public void aprobar(int monto) {
        if (monto <= 500) System.out.println("[Supervisor] Aprueba $" + monto);
        else pasarAlSiguiente(monto);
    }
}
