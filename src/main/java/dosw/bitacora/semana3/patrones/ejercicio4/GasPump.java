package dosw.bitacora.semana3.patrones.ejercicio4;

/**
 * GasPump - Bomba de gasolina estándar
 */
public class GasPump implements FuelService {
    @Override
    public void supply(int liters) {
        System.out.println("Suministrando " + liters + " litros de gasolina");
    }
}
