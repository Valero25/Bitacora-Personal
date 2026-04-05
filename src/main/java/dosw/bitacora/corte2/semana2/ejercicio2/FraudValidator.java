package dosw.bitacora.corte2.semana2.ejercicio2;

/**
 * Chain of Responsibility: Validador de fraude
 * Detecta patrones sospechosos en la transacción
 */
public class FraudValidator extends PaymentValidator {
    
    @Override
    protected boolean doValidate(Payment payment) {
        // Simular análisis de fraude
        boolean isSuspicious = analyzeFraudPatterns(payment);
        
        if (!isSuspicious) {
            System.out.println("Fraud validation passed. Transaction looks legitimate.");
        } else {
            System.out.println("Suspicious activity detected for transaction: " + 
                             payment.getTransactionId());
        }
        
        return !isSuspicious;
    }
    
    private boolean analyzeFraudPatterns(Payment payment) {
        // Simular análisis de fraude
        // Por ejemplo: si el monto es muy alto, puede ser sospechoso
        return payment.getAmount() > 50000;
    }
}
