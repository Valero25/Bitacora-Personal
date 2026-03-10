package dosw.bitacora.semana1.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Ejercicio 1: Dada una lista de números enteros, obtener una nueva lista solo con los números pares mayores a diez
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        System.out.println("--- Ejercicio 1 ---");
        List<Integer> numbers = Arrays.asList(5, 12, 8, 15, 22, 7, 30, 9);
        List<Integer> result = numbers.stream()
                .filter(n -> n > 10 && n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Números pares mayores a 10: " + result);
    }
}

