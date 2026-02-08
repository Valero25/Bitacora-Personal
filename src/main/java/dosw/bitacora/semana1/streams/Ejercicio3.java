package dosw.bitacora.semana1.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Ejercicio 3: Dada una lista de usuarios, filtrar activos, obtener nombres en mayúscula y ordenar alfabéticamente
 */
public class Ejercicio3 {

    // Clase Usuario
    public static class Usuario {
        int id;
        String name;
        int age;
        boolean active;

        public Usuario(int id, String name, int age, boolean active) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.active = active;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public boolean isActive() { return active; }

        @Override
        public String toString() {
            return "Usuario{id=" + id + ", name='" + name + "', age=" + age + ", active=" + active + '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Ejercicio 3 ---");
        List<Usuario> usuarios = Arrays.asList(
                new Usuario(1, "Ana", 25, true),
                new Usuario(2, "Carlos", 30, false),
                new Usuario(3, "Beatriz", 22, true),
                new Usuario(4, "David", 35, true)
        );
        List<String> result = usuarios.stream()
                .filter(Usuario::isActive)
                .map(u -> u.getName().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Nombres de usuarios activos en mayúscula y ordenados: " + result);
    }
}
