package dosw.bitacora.semana3.patrones.ejercicio1;

/**
 * Ejercicio 1: Sistema de procesamiento de pagos
 * 
 * Patrones utilizados:
 * - Bridge Pattern: Separa la abstracción (PaymentProcessor) de la implementación (Payment)
 * - Factory Method: Cada procesador crea su tipo específico de pago
 * 
 * Ventajas:
 * - El sistema no está acoplado a clases concretas de pagos
 * - Permite agregar nuevos métodos de pago sin modificar código existente
 * - Facilita el mantenimiento y la extensión del sistema
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Procesamiento de Pagos ===\n");
        
        PaymentProcessor processor;
        
        // Pago con tarjeta de crédito
        processor = new CreditCardProcessor();
        processor.processPayment(100);
        
        // Pago con PayPal
        processor = new PaypalProcessor();
        processor.processPayment(250);
        
        // Pago con transferencia bancaria
        processor = new BankTransferProcessor();
        processor.processPayment(500);
        
        System.out.println("\n=== Procesamiento Completo ===");
    }
}
