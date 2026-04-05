package dosw.bitacora.corte2.semana2.ejercicio2;

/**
 * Stripe Payment Processor: Implementación para Stripe
 * Simula la integración nativa con la API de Stripe
 */
public class StripeProcessor implements PaymentProcessor {
    
    @Override
    public boolean processPayment(Payment payment) {
        System.out.println("Processing Stripe payment for transaction: " + payment.getTransactionId());
        System.out.println("Amount: " + payment.getAmount());
        
        // Simular validación con API de Stripe
        boolean success = validateWithStripe(payment);
        
        if (success) {
            payment.setStatus("COMPLETED");
            System.out.println("Stripe payment processed successfully!");
        } else {
            payment.setStatus("FAILED");
            System.out.println("Stripe payment failed!");
        }
        
        return success;
    }
    
    private boolean validateWithStripe(Payment payment) {
        // Simular validación con Stripe API
        return payment.getAmount() > 0;
    }
}
