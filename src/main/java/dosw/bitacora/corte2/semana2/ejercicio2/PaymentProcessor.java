package dosw.bitacora.corte2.semana2.ejercicio2;

/**
 * Strategy/Template: Interfaz que define el contrato para procesar pagos
 */
public interface PaymentProcessor {
    boolean processPayment(Payment payment);
}
