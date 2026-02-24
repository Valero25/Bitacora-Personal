package dosw.bitacora.semana3.repaso.combinaciones.combo1;

public class RutaAuto implements TransporteStrategy {
    @Override
    public void calcularRuta(String origen, String destino) {
        System.out.println("[Auto] Ruta más rápida de " + origen + " a " + destino);
    }
}
