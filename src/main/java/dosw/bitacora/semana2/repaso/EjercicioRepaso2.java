package dosw.bitacora.semana2.repaso;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Ejercicio de Repaso 2: Procesamiento de palabras con Streams
 * 
 * Enunciado:
 * Dada una lista de palabras, se requiere:
 * - Filtrar las palabras que tengan más de 4 caracteres
 * - Convertirlas en Mayúsculas
 * - Ordenarlas alfabéticamente
 * - Obtener la cantidad total de palabras resultantes
 * 
 * Datos de Entrada:
 * List<String> words = List.of("java","stream","api","functional","code","git")
 * 
 * Resultado esperado:
 * List<String> procesadas: ["FUNCTIONAL", "STREAM"]
 * Cantidad: 2
 */
public class EjercicioRepaso2 {
    public static void main(String[] args) {
        System.out.println("=== Ejercicio de Repaso 2: Procesamiento de palabras con Streams ===\n");
        
        // Datos de entrada
        List<String> words = List.of("java", "stream", "api", "functional", "code", "git");
        System.out.println("Lista original: " + words);
        
        // ===== PARTE EXPLICADA EN CLASE =====
        // Filtrar palabras con más de 4 caracteres, convertir a mayúsculas y ordenar
        List<String> processed = words.stream()
                .filter(w -> w.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .toList();
        
        System.out.println("Palabras procesadas: " + processed);
        
        // Obtener la cantidad total de palabras resultantes
        long count = processed.stream()
                .count();
        
        System.out.println("Cantidad de palabras procesadas: " + count);
        
        // ===== PARTE AGREGADA: Explicación paso a paso =====
        System.out.println("\n--- Explicación paso a paso ---");
        
        // Paso 1: Filtrar palabras con más de 4 caracteres
        List<String> palabrasFiltradas = words.stream()
                .filter(w -> w.length() > 4)
                .toList();
        System.out.println("Paso 1 - Palabras con más de 4 caracteres: " + palabrasFiltradas);
        
        // Paso 2: Convertir a mayúsculas
        List<String> palabrasMayusculas = palabrasFiltradas.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Paso 2 - Convertidas a mayúsculas: " + palabrasMayusculas);
        
        // Paso 3: Ordenar alfabéticamente
        List<String> palabrasOrdenadas = palabrasMayusculas.stream()
                .sorted()
                .toList();
        System.out.println("Paso 3 - Ordenadas alfabéticamente: " + palabrasOrdenadas);
        
        // ===== PARTE AGREGADA: Operaciones adicionales con streams =====
        System.out.println("\n--- Operaciones adicionales ---");
        
        // Concatenar todas las palabras procesadas
        String concatenadas = processed.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Palabras concatenadas: " + concatenadas);
        
        // Obtener la palabra más larga
        String palabraMasLarga = words.stream()
                .filter(w -> w.length() > 4)
                .max((w1, w2) -> Integer.compare(w1.length(), w2.length()))
                .orElse("");
        System.out.println("Palabra más larga (>4 caracteres): " + palabraMasLarga.toUpperCase());
        
        // Verificar si todas las palabras filtradas tienen más de 3 caracteres
        boolean todasMayoresA3 = processed.stream()
                .allMatch(w -> w.length() > 3);
        System.out.println("¿Todas las palabras tienen más de 3 caracteres?: " + todasMayoresA3);
        
        // Obtener la longitud promedio de las palabras procesadas
        double longitudPromedio = words.stream()
                .filter(w -> w.length() > 4)
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
        System.out.println("Longitud promedio de palabras procesadas: " + longitudPromedio);
        
        // Mostrar cada palabra con su longitud
        System.out.println("\n--- Detalle de palabras procesadas ---");
        words.stream()
                .filter(w -> w.length() > 4)
                .forEach(w -> System.out.println(w.toUpperCase() + " - longitud: " + w.length()));
    }
}