package dosw.bitacora.semana3.patrones.ejercicio1;

/**
 * Implementación de pago con transferencia bancaria
 */
public class BankTransferPayment implements Payment {
    @Override
    public void pay(double amount) {
        String formattedAmount = (amount % 1 == 0) ? String.format("%.0f", amount) : String.valueOf(amount);
        System.out.println("Pago con Transferencia Bancaria por $" + formattedAmount);
    }
}
