package dosw.bitacora.semana3.repaso.base.chainofresponsibility;

public class Gerente extends AprobadorBase {
    @Override
    public void aprobar(int monto) {
        if (monto <= 5000) System.out.println("[Gerente] Aprueba $" + monto);
        else pasarAlSiguiente(monto);
    }
}
