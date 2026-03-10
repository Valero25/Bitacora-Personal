package dosw.bitacora.semana3.patrones.ejercicio4;

/**
 * FastChargerAdapter - Adapta el cargador rápido a la interfaz FuelService
 * Conversión: litros * 8.0 = kWh
 */
public class FastChargerAdapter implements FuelService {
    private FastElectricCharger charger;
    
    public FastChargerAdapter(FastElectricCharger charger) {
        this.charger = charger;
    }
    
    @Override
    public void supply(int liters) {
        // Convertir litros a kWh (modo rápido: 8.0)
        double kWh = liters * 8.0;
        charger.fastCharge(kWh);
    }
}
