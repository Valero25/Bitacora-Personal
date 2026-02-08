package dosw.bitacora.semana1.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Ejercicio 4: Dado un listado de Usuarios, filtrar mayores de edad y obtener sus nombres
 */
public class Ejercicio4 {

    // Clase Usuario
    static class Usuario {
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
        System.out.println("--- Ejercicio 4 ---");
        List<Usuario> usuarios = Arrays.asList(
                new Usuario(1, "Ana", 17, true),
                new Usuario(2, "Carlos", 30, false),
                new Usuario(3, "Beatriz", 22, true),
                new Usuario(4, "David", 35, true)
        );
        List<String> result = usuarios.stream()
                .filter(u -> u.getAge() >= 18)
                .map(Usuario::getName)
                .collect(Collectors.toList());
        System.out.println("Nombres de usuarios mayores de edad: " + result);
    }
}
