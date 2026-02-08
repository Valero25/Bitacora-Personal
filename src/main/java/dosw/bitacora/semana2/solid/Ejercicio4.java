package dosw.bitacora.semana2.solid;

/**
 * Ejercicio 4: Principios SOLID (Calculadora simple)
 * Calculadora con operaciones separadas aplicando SOLID.
 */

// Interfaz para operaciones (Interface Segregation)
interface Operation {
    double execute(double a, double b);
}

// Operación de suma
class Add implements Operation {
    @Override
    public double execute(double a, double b) {
        return a + b;
    }
}

// Operación de resta
class Subtract implements Operation {
    @Override
    public double execute(double a, double b) {
        return a - b;
    }
}

// Operación de multiplicación
class Multiply implements Operation {
    @Override
    public double execute(double a, double b) {
        return a * b;
    }
}

// Operación de división
class Divide implements Operation {
    @Override
    public double execute(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return a / b;
    }
}

// Calculadora que usa operaciones (Open/Closed, Single Responsibility)
class Calculator {
    public double performOperation(Operation operation, double a, double b) {
        return operation.execute(a, b);
    }
}

public class Ejercicio4 {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Suma
        Operation add = new Add();
        System.out.println("5 + 3 = " + calc.performOperation(add, 5, 3));

        // Resta
        Operation subtract = new Subtract();
        System.out.println("5 - 3 = " + calc.performOperation(subtract, 5, 3));

        // Multiplicación
        Operation multiply = new Multiply();
        System.out.println("5 * 3 = " + calc.performOperation(multiply, 5, 3));

        // División
        Operation divide = new Divide();
        System.out.println("6 / 2 = " + calc.performOperation(divide, 6, 2));

        // Con decimales
        System.out.println("5.5 + 2.2 = " + calc.performOperation(add, 5.5, 2.2));
    }
}
