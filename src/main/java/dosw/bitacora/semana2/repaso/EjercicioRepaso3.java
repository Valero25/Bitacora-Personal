package dosw.bitacora.semana2.repaso;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Ejercicio de Repaso 3: Filtrado y transformación de usuarios con Streams
 * 
 * Enunciado:
 * Dada una lista de usuarios con los atributos:
 * - id
 * - name
 * - age
 * - active
 * 
 * Se requiere:
 * - Filtra únicamente los usuarios activos
 * - Obtén una lista con los nombres en mayúscula
 * - Ordena alfabéticamente el resultado
 * 
 * Datos de Entrada: users = List<User>
 * Resultado: List<String>
 */
public class EjercicioRepaso3 {
    
    // Clase User con sus atributos
    static class User {
        private int id;
        private String name;
        private int age;
        private boolean active;
        
        public User(int id, String name, int age, boolean active) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.active = active;
        }
        
        public int getId() {
            return id;
        }
        
        public String getName() {
            return name;
        }
        
        public int getAge() {
            return age;
        }
        
        public boolean isActive() {
            return active;
        }
        
        @Override
        public String toString() {
            return "User{id=" + id + ", name='" + name + "', age=" + age + ", active=" + active + '}';
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Ejercicio de Repaso 3: Filtrado y transformación de usuarios ===\n");
        
        // Datos de entrada
        List<User> users = Arrays.asList(
                new User(1, "Ana", 25, true),
                new User(2, "Carlos", 30, false),
                new User(3, "Beatriz", 22, true),
                new User(4, "David", 35, true),
                new User(5, "Elena", 28, false),
                new User(6, "Fernando", 32, true)
        );
        
        System.out.println("Lista de usuarios:");
        users.forEach(System.out::println);
        
        // ===== PARTE EXPLICADA EN CLASE =====
        // Filtrar usuarios activos, obtener nombres en mayúsculas y ordenar
        List<String> result = users.stream()
                .filter(User::isActive)
                .map(User::getName)
                .map(String::toUpperCase)
                .sorted()
                .toList();
        
        System.out.println("\nNombres de usuarios activos en mayúscula (ordenados): " + result);
        
        // ===== PARTE AGREGADA: Explicación paso a paso =====
        System.out.println("\n--- Explicación paso a paso ---");
        
        // Paso 1: Filtrar solo usuarios activos
        List<User> usuariosActivos = users.stream()
                .filter(User::isActive)
                .toList();
        System.out.println("Paso 1 - Usuarios activos:");
        usuariosActivos.forEach(u -> System.out.println("  " + u));
        
        // Paso 2: Extraer solo los nombres
        List<String> nombres = usuariosActivos.stream()
                .map(User::getName)
                .toList();
        System.out.println("Paso 2 - Nombres: " + nombres);
        
        // Paso 3: Convertir a mayúsculas
        List<String> nombresMayusculas = nombres.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Paso 3 - Nombres en mayúsculas: " + nombresMayusculas);
        
        // Paso 4: Ordenar alfabéticamente
        List<String> nombresOrdenados = nombresMayusculas.stream()
                .sorted()
                .toList();
        System.out.println("Paso 4 - Nombres ordenados: " + nombresOrdenados);
        
        // ===== PARTE AGREGADA: Operaciones adicionales con usuarios =====
        System.out.println("\n--- Operaciones adicionales ---");
        
        // Contar usuarios activos
        long cantidadActivos = users.stream()
                .filter(User::isActive)
                .count();
        System.out.println("Cantidad de usuarios activos: " + cantidadActivos);
        
        // Contar usuarios inactivos
        long cantidadInactivos = users.stream()
                .filter(u -> !u.isActive())
                .count();
        System.out.println("Cantidad de usuarios inactivos: " + cantidadInactivos);
        
        // Obtener edad promedio de usuarios activos
        double edadPromedio = users.stream()
                .filter(User::isActive)
                .mapToInt(User::getAge)
                .average()
                .orElse(0.0);
        System.out.println("Edad promedio de usuarios activos: " + edadPromedio);
        
        // Encontrar el usuario activo más joven
        User masJoven = users.stream()
                .filter(User::isActive)
                .min((u1, u2) -> Integer.compare(u1.getAge(), u2.getAge()))
                .orElse(null);
        System.out.println("Usuario activo más joven: " + (masJoven != null ? masJoven.getName() + " (" + masJoven.getAge() + " años)" : "N/A"));
        
        // Encontrar el usuario activo mayor
        User mayor = users.stream()
                .filter(User::isActive)
                .max((u1, u2) -> Integer.compare(u1.getAge(), u2.getAge()))
                .orElse(null);
        System.out.println("Usuario activo mayor: " + (mayor != null ? mayor.getName() + " (" + mayor.getAge() + " años)" : "N/A"));
        
        // Verificar si existe algún usuario activo menor de 25 años
        boolean existeMenorDe25 = users.stream()
                .filter(User::isActive)
                .anyMatch(u -> u.getAge() < 25);
        System.out.println("¿Existe algún usuario activo menor de 25 años?: " + existeMenorDe25);
        
        // Concatenar todos los nombres de usuarios activos
        String todosLosNombres = users.stream()
                .filter(User::isActive)
                .map(User::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Todos los nombres de usuarios activos: " + todosLosNombres);
        
        // Agrupar usuarios por estado (activo/inactivo)
        System.out.println("\n--- Detalle por usuario activo ---");
        users.stream()
                .filter(User::isActive)
                .forEach(u -> System.out.println(u.getName().toUpperCase() + " - " + u.getAge() + " años (ID: " + u.getId() + ")"));
    }
}