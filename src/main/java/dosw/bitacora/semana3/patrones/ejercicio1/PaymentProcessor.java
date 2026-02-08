package dosw.bitacora.semana3.patrones.ejercicio1;

/**
 * Clase abstracta PaymentProcessor - Patrón Bridge
 * Separa la abstracción del procesador de la implementación del pago
 */
public abstract class PaymentProcessor {
    protected Payment payment;
    
    /**
     * Factory Method - cada procesador crea su tipo de pago
     */
    protected abstract Payment createPayment();
    
    /**
     * Procesa el pago usando el método de pago creado
     */
    public void processPayment(double amount) {
        payment = createPayment();
        payment.pay(amount);
    }
}
