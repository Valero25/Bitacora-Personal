package dosw.bitacora.corte2.semana2.ejercicio2;

/**
 * Chain of Responsibility Pattern: Interfaz que define los validadores en cadena
 * Cada validador puede procesar la solicitud o pasarla al siguiente
 */
public abstract class PaymentValidator {
    
    protected PaymentValidator nextValidator;
    
    /**
     * Establece el siguiente validador en la cadena
     */
    public void setNext(PaymentValidator nextValidator) {
        this.nextValidator = nextValidator;
    }
    
    /**
     * Valida el pago y pasa la solicitud al siguiente validador si es necesario
     * 
     * @param payment Pago a validar
     * @return true si es válido, false si no
     */
    public final boolean validate(Payment payment) {
        if (!doValidate(payment)) {
            System.out.println("Validation failed at: " + this.getClass().getSimpleName());
            return false;
        }
        
        // Pasar al siguiente validador
        if (nextValidator != null) {
            return nextValidator.validate(payment);
        }
        
        return true;
    }
    
    /**
     * Implementar la lógica de validación específica
     */
    protected abstract boolean doValidate(Payment payment);
}
