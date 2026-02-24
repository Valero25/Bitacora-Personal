package dosw.bitacora.semana3.patrones.ejercicio1;

/**
 * PaymentProcessor - Creador abstracto del patrón Factory Method
 * Define el método fábrica createPayment() que las subclases implementan
 * para crear el tipo concreto de pago sin acoplar el proceso al tipo específico
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
