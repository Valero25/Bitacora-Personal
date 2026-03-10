package dosw.bitacora.semana1.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Ejercicio 2: Dada una lista de palabras, filtrar las que tengan más de 4 caracteres, convertir a mayúsculas, ordenar alfabéticamente y contar
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        System.out.println("--- Ejercicio 2 ---");
        List<String> words = Arrays.asList("hola", "mundo", "java", "streams", "programacion", "codigo");
        long count = words.stream()
                .filter(w -> w.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .peek(System.out::println) // Para ver las palabras procesadas
                .count();
        System.out.println("Cantidad total de palabras resultantes: " + count);
    }
}
