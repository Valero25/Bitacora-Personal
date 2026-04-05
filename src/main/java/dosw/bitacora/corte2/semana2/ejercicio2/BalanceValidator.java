package dosw.bitacora.corte2.semana2.ejercicio2;

/**
 * Chain of Responsibility: Validador de saldo
 * Verifica que el usuario tenga suficiente saldo para la transacción
 */
public class BalanceValidator extends PaymentValidator {
    
    private static final double MINIMUM_BALANCE = 100.0;
    
    @Override
    protected boolean doValidate(Payment payment) {
        // Simular consulta de saldo del usuario
        double userBalance = getUserBalance(payment.getUserId());
        
        boolean valid = userBalance >= payment.getAmount();
        
        if (valid) {
            System.out.println("Balance validation passed. User balance: " + userBalance);
        } else {
            System.out.println("Insufficient balance. Available: " + userBalance + 
                             ", Required: " + payment.getAmount());
        }
        
        return valid;
    }
    
    private double getUserBalance(String userId) {
        // Simular obtención de saldo del usuario
        return 5000.0; // Saldo ficticio
    }
}
