package dosw.bitacora.corte2.semana2.ejercicio2;

/**
 * Payment Model: Contiene la información del pago a procesar
 */
public class Payment {
    private String transactionId;
    private String paymentMethod;
    private String userId;
    private double amount;
    private String status;
    
    public Payment(String transactionId, String paymentMethod, String userId, double amount) {
        this.transactionId = transactionId;
        this.paymentMethod = paymentMethod;
        this.userId = userId;
        this.amount = amount;
        this.status = "PENDING";
    }
    
    // Getters y Setters
    public String getTransactionId() { return transactionId; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getUserId() { return userId; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    @Override
    public String toString() {
        return "Payment{" +
                "transactionId='" + transactionId + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", userId='" + userId + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
