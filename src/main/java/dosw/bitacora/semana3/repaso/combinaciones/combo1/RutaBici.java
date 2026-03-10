package dosw.bitacora.semana3.repaso.combinaciones.combo1;

public class RutaBici implements TransporteStrategy {
    @Override
    public void calcularRuta(String origen, String destino) {
        System.out.println("[Bici] Ruta ciclovía de " + origen + " a " + destino);
    }
}
