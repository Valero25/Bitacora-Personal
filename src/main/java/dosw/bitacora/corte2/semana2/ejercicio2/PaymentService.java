package dosw.bitacora.corte2.semana2.ejercicio2;

/**
 * Facade Pattern: Punto de entrada simplificado para procesar pagos
 * Orquesta: Validación (Chain of Responsibility) + Procesamiento (Factory)
 * Encapsula la complejidad del sistema de procesamiento de pagos
 */
public class PaymentService {
    
    private ValidationChain validationChain;
    
    public PaymentService() {
        this.validationChain = new ValidationChain();
    }
    
    /**
     * Procesa un pago de forma completa:
     * 1. Valida el pago a través de la cadena de validadores
     * 2. Si es válido, procesa el pago con el procesador correspondiente
     * 
     * @param payment Pago a procesar
     * @return true si se procesó exitosamente
     */
    public boolean processPayment(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null");
        }
        
        // Paso 1: Validar el pago
        if (!validationChain.validatePayment(payment)) {
            System.out.println("Payment validation failed. Transaction aborted.");
            payment.setStatus("REJECTED");
            return false;
        }
        
        // Paso 2: Si pasa validación, procesar el pago
        System.out.println("\n--- Processing Payment ---");
        PaymentProcessor processor = PaymentProcessorFactory.createProcessor(
            payment.getPaymentMethod()
        );
        
        boolean processed = processor.processPayment(payment);
        
        return processed;
    }
}
