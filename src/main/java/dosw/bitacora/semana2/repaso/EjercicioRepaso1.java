package dosw.bitacora.semana2.repaso;

import java.util.List;

/**
 * Ejercicio de Repaso 1: Filtrado de números con Streams
 * 
 * Enunciado:
 * Dada una lista de números enteros, necesitamos obtener una nueva lista 
 * solo con los números pares mayores a diez.
 * 
 * Datos de Entrada:
 * List<Integer> numbers = List.of(3,8,10,12,15,18,20)
 * 
 * Resultado esperado:
 * List<Integer> con [12, 18, 20]
 */
public class EjercicioRepaso1 {
    public static void main(String[] args) {
        System.out.println("=== Ejercicio de Repaso 1: Filtrado de números con Streams ===\n");
        
        // Datos de entrada
        List<Integer> numbers = List.of(3, 8, 10, 12, 15, 18, 20);
        System.out.println("Lista original: " + numbers);
        
        // ===== PARTE EXPLICADA EN CLASE =====
        // Filtrar números pares mayores a 10 usando streams
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)    // Filtrar números pares
                .filter(n -> n > 10)         // Filtrar números mayores a 10
                .toList();
        
        System.out.println("Números pares mayores a 10: " + result);
        
        // ===== PARTE AGREGADA: Explicación paso a paso =====
        System.out.println("\n--- Explicación paso a paso ---");
        
        // Paso 1: Filtrar solo números pares
        List<Integer> numerosPares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("Paso 1 - Números pares: " + numerosPares);
        
        // Paso 2: De los números pares, filtrar los mayores a 10
        List<Integer> paresYMayoresA10 = numerosPares.stream()
                .filter(n -> n > 10)
                .toList();
        System.out.println("Paso 2 - Pares mayores a 10: " + paresYMayoresA10);
        
        // ===== PARTE AGREGADA: Otras operaciones útiles con streams =====
        System.out.println("\n--- Operaciones adicionales ---");
        
        // Contar cuántos números cumplen la condición
        long count = numbers.stream()
                .filter(n -> n % 2 == 0)
                .filter(n -> n > 10)
                .count();
        System.out.println("Cantidad de números pares mayores a 10: " + count);
        
        // Obtener la suma de los números filtrados
        int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .filter(n -> n > 10)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Suma de números pares mayores a 10: " + sum);
        
        // Verificar si existe al menos un número que cumpla la condición
        boolean exists = numbers.stream()
                .anyMatch(n -> n % 2 == 0 && n > 10);
        System.out.println("¿Existe al menos un número par mayor a 10?: " + exists);
    }
}