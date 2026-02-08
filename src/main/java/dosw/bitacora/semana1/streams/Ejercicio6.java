package dosw.bitacora.semana1.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Ejercicio 6: Dada una lista de strings, filtrar los que empiezan con 'A' y convertirlos a mayúsculas
 */
public class Ejercicio6 {

    public static void main(String[] args) {
        System.out.println("--- Ejercicio 6 ---");
        List<String> words = Arrays.asList("Apple", "Banana", "Avocado", "Cherry", "Apricot");
        List<String> result = words.stream()
                .filter(w -> w.startsWith("A"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Palabras que empiezan con 'A' en mayúsculas: " + result);
    }
}
