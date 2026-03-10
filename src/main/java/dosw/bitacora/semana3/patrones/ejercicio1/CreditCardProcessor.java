package dosw.bitacora.semana3.patrones.ejercicio1;

/**
 * Procesador de pagos con tarjeta de crédito
 */
public class CreditCardProcessor extends PaymentProcessor {
    @Override
    protected Payment createPayment() {
        return new CreditCardPayment();
    }
}
