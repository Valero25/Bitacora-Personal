package dosw.bitacora.semana3.patrones.ejercicio5;

/**
 * Ejercicio 5: Sistema de formas geométricas con colores usando Bridge Pattern
 * 
 * Patrón utilizado:
 * - Bridge Pattern: Desacopla una abstracción de su implementación para que
 *   ambas puedan variar independientemente
 * 
 * Problema resuelto:
 * - Sin Bridge: necesitaríamos clases CirculoRojo, CirculoAzul, CuadradoRojo, CuadradoAzul
 *   (explosión de clases al combinar formas y colores)
 * - Con Bridge: separamos Forma (abstracción) de Color (implementación)
 *   permitiendo combinarlas libremente
 * 
 * Ventajas:
 * - Evita la explosión de clases al combinar características
 * - Permite agregar nuevas formas sin modificar colores
 * - Permite agregar nuevos colores sin modificar formas
 * - Las jerarquías de abstracción e implementación evolucionan independientemente
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Formas Geométricas ===\n");
        
        // Crear formas con diferentes colores usando el puente
        Forma circuloRojo = new Circulo(new Rojo());
        Forma cuadradoRojo = new Cuadrado(new Rojo());
        Forma circuloAzul = new Circulo(new Azul());
        Forma cuadradoAzul = new Cuadrado(new Azul());
        
        // Dibujar todas las formas
        circuloRojo.dibujar();
        cuadradoRojo.dibujar();
        circuloAzul.dibujar();
        cuadradoAzul.dibujar();
        
        System.out.println("\n=== Todas las formas dibujadas ===");
    }
}
