package dosw.bitacora.semana3.patrones.ejercicio4;

/**
 * SlowChargerAdapter - Adapta el cargador lento a la interfaz FuelService
 * Conversión: litros * 7.0 = kWh
 */
public class SlowChargerAdapter implements FuelService {
    private SlowElectricCharger charger;
    
    public SlowChargerAdapter(SlowElectricCharger charger) {
        this.charger = charger;
    }
    
    @Override
    public void supply(int liters) {
        // Convertir litros a kWh (modo lento: 7.0)
        double kWh = liters * 7.0;
        charger.slowCharge(kWh);
    }
}
