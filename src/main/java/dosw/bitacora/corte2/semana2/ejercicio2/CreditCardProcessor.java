package dosw.bitacora.corte2.semana2.ejercicio2;

/**
 * Credit Card Payment Processor: Implementación para tarjeta de crédito
 * Simula la integración con un procesador de tarjetas propietario
 */
public class CreditCardProcessor implements PaymentProcessor {
    
    @Override
    public boolean processPayment(Payment payment) {
        System.out.println("Processing Credit Card payment for transaction: " + payment.getTransactionId());
        System.out.println("Amount: " + payment.getAmount());
        
        // Simular validación de tarjeta
        boolean success = validateCard(payment);
        
        if (success) {
            payment.setStatus("COMPLETED");
            System.out.println("Credit Card payment processed successfully!");
        } else {
            payment.setStatus("FAILED");
            System.out.println("Credit Card payment failed!");
        }
        
        return success;
    }
    
    private boolean validateCard(Payment payment) {
        // Simular validación de tarjeta
        return payment.getAmount() > 0 && payment.getAmount() <= 100000;
    }
}
