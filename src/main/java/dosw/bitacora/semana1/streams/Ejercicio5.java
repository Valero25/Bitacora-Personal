package dosw.bitacora.semana1.streams;

import java.util.*;

/**
 * Ejercicio 5: Dada una lista de transacciones, usar peek para ver cada una, verificar si existe al menos una no aprobada, retornar si el lote es válido
 */
public class Ejercicio5 {

    // Clase Transaction
    public static class Transaction {
        String id;
        double amount;
        boolean approved;

        public Transaction(String id, double amount, boolean approved) {
            this.id = id;
            this.amount = amount;
            this.approved = approved;
        }

        public String getId() { return id; }
        public double getAmount() { return amount; }
        public boolean isApproved() { return approved; }

        @Override
        public String toString() {
            return "Transaction{id='" + id + "', amount=" + amount + ", approved=" + approved + '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Ejercicio 5 ---");
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", 100.0, true),
                new Transaction("T2", 200.0, true),
                new Transaction("T3", 150.0, false),
                new Transaction("T4", 50.0, true)
        );
        boolean isValid = transactions.stream()
                .peek(t -> System.out.println("Procesando: " + t))
                .allMatch(Transaction::isApproved);
        System.out.println("¿El lote de transacciones es válido? " + isValid);
    }
}
