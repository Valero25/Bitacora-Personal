package dosw.bitacora.corte2.semana2.ejercicio2;

/**
 * Chain of Responsibility: Validador de límite de transacciones
 * Verifica que el usuario no haya excedido su límite de transacciones
 */
public class TransactionLimitValidator extends PaymentValidator {
    
    private static final int DAILY_TRANSACTION_LIMIT = 10;
    private static final double DAILY_AMOUNT_LIMIT = 100000.0;
    
    @Override
    protected boolean doValidate(Payment payment) {
        // Simular consulta de transacciones del día
        int transactionCount = getTransactionCountToday(payment.getUserId());
        double dailyAmount = getDailyAmount(payment.getUserId());
        
        boolean countValid = transactionCount < DAILY_TRANSACTION_LIMIT;
        boolean amountValid = (dailyAmount + payment.getAmount()) <= DAILY_AMOUNT_LIMIT;
        
        if (countValid && amountValid) {
            System.out.println("Transaction limit validation passed. " +
                             "Daily transactions: " + transactionCount + 
                             ", Daily amount: " + dailyAmount);
        } else {
            if (!countValid) {
                System.out.println("Transaction count limit exceeded for today.");
            }
            if (!amountValid) {
                System.out.println("Daily amount limit would be exceeded.");
            }
        }
        
        return countValid && amountValid;
    }
    
    private int getTransactionCountToday(String userId) {
        // Simular obtención de contador de transacciones
        return 3; // Valor ficticio
    }
    
    private double getDailyAmount(String userId) {
        // Simular obtención del monto ya utilizado
        return 25000.0; // Valor ficticio
    }
}
