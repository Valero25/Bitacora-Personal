package dosw.bitacora.semana2.solid.ejercicio4;

/**
 * Calculadora que usa operaciones (Open/Closed Principle, Single Responsibility Principle)
 */
public class Calculator {
    public double performOperation(Operation operation, double a, double b) {
        return operation.execute(a, b);
    }
}