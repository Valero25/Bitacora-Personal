package dosw.bitacora.semana3.patrones.ejercicio1;

/**
 * Procesador de pagos con PayPal
 */
public class PaypalProcessor extends PaymentProcessor {
    @Override
    protected Payment createPayment() {
        return new PaypalPayment();
    }
}
