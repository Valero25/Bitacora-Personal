package dosw.bitacora.corte2.semana2.ejercicio2;

/**
 * Bank Transfer Payment Processor: Implementación para transferencia bancaria
 * Simula la integración con sistema de transferencias bancarias
 */
public class BankTransferProcessor implements PaymentProcessor {
    
    @Override
    public boolean processPayment(Payment payment) {
        System.out.println("Processing Bank Transfer for transaction: " + payment.getTransactionId());
        System.out.println("Amount: " + payment.getAmount());
        
        // Simular validación de transferencia bancaria
        boolean success = validateBankTransfer(payment);
        
        if (success) {
            payment.setStatus("COMPLETED");
            System.out.println("Bank Transfer processed successfully!");
        } else {
            payment.setStatus("FAILED");
            System.out.println("Bank Transfer failed!");
        }
        
        return success;
    }
    
    private boolean validateBankTransfer(Payment payment) {
        // Simular validación de transferencia
        return payment.getAmount() > 0 && payment.getAmount() <= 1000000;
    }
}
