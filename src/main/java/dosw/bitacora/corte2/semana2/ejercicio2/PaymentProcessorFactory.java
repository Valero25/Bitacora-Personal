package dosw.bitacora.corte2.semana2.ejercicio2;

/**
 * Factory Pattern: Crea instancias de PaymentProcessor según el tipo de pago
 * Centraliza la creación y permite agregar nuevos procesadores sin cambiar código existente
 */
public class PaymentProcessorFactory {
    
    /**
     * Crea un procesador de pago según el método especificado
     * 
     * @param paymentMethod Tipo de pago: "PAYPAL", "STRIPE", "CREDITCARD", "BANKTRANSFER"
     * @return Instancia de PaymentProcessor
     * @throws IllegalArgumentException si el método no es válido
     */
    public static PaymentProcessor createProcessor(String paymentMethod) {
        if (paymentMethod == null || paymentMethod.isEmpty()) {
            throw new IllegalArgumentException("Payment method cannot be null or empty");
        }
        
        String method = paymentMethod.toUpperCase();
        
        switch (method) {
            case "PAYPAL":
                return new PayPalProcessor();
            case "STRIPE":
                return new StripeProcessor();
            case "CREDITCARD":
                return new CreditCardProcessor();
            case "BANKTRANSFER":
                return new BankTransferProcessor();
            default:
                throw new IllegalArgumentException("Unknown payment method: " + paymentMethod);
        }
    }
}
