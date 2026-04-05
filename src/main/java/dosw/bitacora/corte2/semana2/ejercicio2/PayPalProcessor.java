package dosw.bitacora.corte2.semana2.ejercicio2;

/**
 * PayPal Payment Processor: Implementación para PayPal
 * Simula la integración nativa con la API de PayPal
 */
public class PayPalProcessor implements PaymentProcessor {
    
    @Override
    public boolean processPayment(Payment payment) {
        System.out.println("Processing PayPal payment for transaction: " + payment.getTransactionId());
        System.out.println("Amount: " + payment.getAmount());
        
        // Simular validación con API de PayPal
        boolean success = validateWithPayPal(payment);
        
        if (success) {
            payment.setStatus("COMPLETED");
            System.out.println("PayPal payment processed successfully!");
        } else {
            payment.setStatus("FAILED");
            System.out.println("PayPal payment failed!");
        }
        
        return success;
    }
    
    private boolean validateWithPayPal(Payment payment) {
        // Simular validación con PayPal API
        return payment.getAmount() > 0;
    }
}
