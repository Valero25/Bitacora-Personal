package dosw.bitacora.semana3.patrones.ejercicio6;

/**
 * Ejercicio 6: Sistema de gestión de bodega con productos y cajas usando Composite Pattern
 * 
 * Patrón utilizado:
 * - Composite Pattern: Permite componer objetos en estructuras de árbol para representar
 *   jerarquías parte-todo. Permite tratar objetos individuales y composiciones de
 *   objetos de manera uniforme.
 * 
 * Problema resuelto:
 * - Una bodega maneja productos individuales y cajas que pueden contener productos
 *   u otras cajas (cajas dentro de cajas)
 * - El sistema debe calcular el precio total de cualquier elemento, sin importar
 *   si es un producto simple o una caja compuesta
 * 
 * Componentes:
 * - ItemBodega (Component): Interfaz común para productos y cajas
 * - Producto (Leaf): Elemento individual con precio específico
 * - Caja (Composite): Contenedor que puede tener productos y otras cajas
 * 
 * Ventajas:
 * - Permite tratar objetos individuales y compuestos de manera uniforme
 * - Facilita agregar nuevos tipos de componentes
 * - Simplifica el código del cliente (no necesita distinguir entre productos y cajas)
 * - Facilita la creación de estructuras jerárquicas complejas
 */
public class Ejercicio6 {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Gestión de Bodega ===\n");
        
        // Crear productos individuales
        Producto laptop = new Producto("Laptop", 1200.00);
        Producto mouse = new Producto("Mouse", 25.00);
        Producto teclado = new Producto("Teclado", 75.00);
        Producto monitor = new Producto("Monitor", 300.00);
        Producto cable = new Producto("Cable HDMI", 15.00);
        
        // Crear caja de accesorios
        Caja cajaAccesorios = new Caja("Accesorios");
        cajaAccesorios.agregar(mouse);
        cajaAccesorios.agregar(teclado);
        cajaAccesorios.agregar(cable);
        
        // Crear caja de computadora (contiene laptop y caja de accesorios)
        Caja cajaComputadora = new Caja("Computadora Completa");
        cajaComputadora.agregar(laptop);
        cajaComputadora.agregar(monitor);
        cajaComputadora.agregar(cajaAccesorios);
        
        // Crear otra caja con productos individuales
        Producto impresora = new Producto("Impresora", 200.00);
        Producto papel = new Producto("Resma de Papel", 5.00);
        
        Caja cajaOficina = new Caja("Oficina");
        cajaOficina.agregar(impresora);
        cajaOficina.agregar(papel);
        
        // Crear caja maestra que contiene todo
        Caja cajaMaestra = new Caja("Pedido Completo");
        cajaMaestra.agregar(cajaComputadora);
        cajaMaestra.agregar(cajaOficina);
        
        // Mostrar estructura completa con precios
        System.out.println("Estructura de la bodega:");
        cajaMaestra.mostrar(0);
        
        // Calcular precio total
        System.out.println("\n--- Resumen ---");
        double precioTotal = cajaMaestra.getPrecio();
        double precioComputadora = cajaComputadora.getPrecio();
        double precioOficina = cajaOficina.getPrecio();
        
        String precioTotalFormateado = (precioTotal % 1 == 0) ? String.format("%.0f", precioTotal) : String.valueOf(precioTotal);
        String precioComputadoraFormateado = (precioComputadora % 1 == 0) ? String.format("%.0f", precioComputadora) : String.valueOf(precioComputadora);
        String precioOficinaFormateado = (precioOficina % 1 == 0) ? String.format("%.0f", precioOficina) : String.valueOf(precioOficina);
        
        System.out.println("Precio total del pedido completo: $" + precioTotalFormateado);
        System.out.println("Precio de la caja de computadora: $" + precioComputadoraFormateado);
        System.out.println("Precio de la caja de oficina: $" + precioOficinaFormateado);
        
        System.out.println("\n=== Cálculo de precios completado ===");
    }
}
