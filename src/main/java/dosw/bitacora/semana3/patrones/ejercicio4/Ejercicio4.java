package dosw.bitacora.semana3.patrones.ejercicio4;

/**
 * Ejercicio 4: Gasolinera inteligente con patrón Adapter
 * 
 * Patrón utilizado:
 * - Adapter Pattern: Permite que clases con interfaces incompatibles trabajen juntas
 *   convirtiendo la interfaz de una clase en otra que el cliente espera
 * 
 * Problema resuelto:
 * - La gasolinera tiene un sistema estándar (FuelService) para combustión
 * - Los cargadores eléctricos tienen interfaces incompatibles
 * - Los adapters permiten usar los cargadores con la misma interfaz
 * - El sistema central no necesita cambiar para soportar vehículos eléctricos
 * 
 * Ventajas:
 * - Unifica el proceso de abastecimiento para todos los vehículos
 * - El sistema central permanece estable
 * - Fácil agregar nuevos tipos de cargadores
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.println("=== Gasolinera Inteligente ===\n");
        
        // Vehículo de combustión - usa bomba de gasolina directamente
        FuelService gasolinePump = new GasPump();
        System.out.println("--- Vehículo de Combustión ---");
        gasolinePump.supply(30);
        
        System.out.println("\n--------------------\n");
        
        // Vehículo eléctrico - usa cargador rápido a través del adapter
        FuelService fastElectricPump = new FastChargerAdapter(new FastElectricCharger());
        System.out.println("--- Vehículo Eléctrico (Carga Rápida) ---");
        fastElectricPump.supply(30);
        
        System.out.println("\n--------------------\n");
        
        // Vehículo híbrido - usa cargador lento a través del adapter
        FuelService slowElectricPump = new SlowChargerAdapter(new SlowElectricCharger());
        System.out.println("--- Vehículo Híbrido (Carga Lenta) ---");
        slowElectricPump.supply(30);
        
        System.out.println("\n=== Todos los vehículos atendidos ===");
    }
}
