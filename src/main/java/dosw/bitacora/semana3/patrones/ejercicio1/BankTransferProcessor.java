package dosw.bitacora.semana3.patrones.ejercicio1;

/**
 * Procesador de pagos con transferencia bancaria
 */
public class BankTransferProcessor extends PaymentProcessor {
    @Override
    protected Payment createPayment() {
        return new BankTransferPayment();
    }
}
