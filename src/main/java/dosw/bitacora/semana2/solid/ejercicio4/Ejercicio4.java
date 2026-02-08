package dosw.bitacora.semana2.solid.ejercicio4;

/**
 * Clase principal para el Ejercicio 4: Principios SOLID (Calculadora simple)
 */
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