package dosw.bitacora.corte2.semana2.ejercicio2;

/**
 * Chain of Responsibility Builder: Gestor de la cadena de validadores
 * Construye y maneja la cadena de responsabilidades
 */
public class ValidationChain {
    
    private PaymentValidator firstValidator;
    
    /**
     * Construye la cadena de validadores en orden
     * Cada validador pasa al siguiente si la validación es exitosa
     */
    public ValidationChain() {
        buildChain();
    }
    
    private void buildChain() {
        // Crear validadores en orden de ejecución
        BalanceValidator balanceValidator = new BalanceValidator();
        FraudValidator fraudValidator = new FraudValidator();
        TransactionLimitValidator limitValidator = new TransactionLimitValidator();
        
        // Encadenar: BalanceValidator -> FraudValidator -> TransactionLimitValidator
        balanceValidator.setNext(fraudValidator);
        fraudValidator.setNext(limitValidator);
        
        this.firstValidator = balanceValidator;
    }
    
    /**
     * Inicia la validación a través de la cadena completa
     */
    public boolean validatePayment(Payment payment) {
        System.out.println("\n--- Starting Payment Validation ---");
        return firstValidator.validate(payment);
    }
}
