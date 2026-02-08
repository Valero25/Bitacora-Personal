package dosw.bitacora.semana3.patrones.ejercicio3;

/**
 * Ejercicio 3: Fábrica de juguetes con patrón Builder
 * 
 * Patrón utilizado:
 * - Builder Pattern: Separa la construcción de un objeto complejo de su representación
 *   permitiendo que el mismo proceso de construcción cree diferentes representaciones
 * 
 * Ventajas:
 * - El proceso de ensamblaje es el mismo para todos los tipos de muñecos
 * - Cada builder define cómo se construye su tipo específico de muñeco
 * - La fábrica (director) no conoce los detalles de construcción
 * - Facilita agregar nuevos tipos de muñecos sin modificar el código existente
 * - Permite construir objetos complejos paso a paso
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("=== Fábrica de Juguetes ===\n");
        
        ToyFactory factory = new ToyFactory();
        
        // Construir muñeco de acción
        ActionDollBuilder actionBuilder = new ActionDollBuilder();
        ToyDoll actionDoll = factory.constructDoll(actionBuilder);
        System.out.println("--- Muñeco de Acción ---");
        actionDoll.showInfo();
        
        System.out.println("\n--------------------\n");
        
        // Construir muñeco clásico
        ClassicDollBuilder classicBuilder = new ClassicDollBuilder();
        ToyDoll classicDoll = factory.constructDoll(classicBuilder);
        System.out.println("--- Muñeco Clásico ---");
        classicDoll.showInfo();
        
        System.out.println("\n=== Producción Completa ===");
    }
}
