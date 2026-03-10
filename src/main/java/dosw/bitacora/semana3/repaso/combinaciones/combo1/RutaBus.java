package dosw.bitacora.semana3.repaso.combinaciones.combo1;

public class RutaBus implements TransporteStrategy {
    @Override
    public void calcularRuta(String origen, String destino) {
        System.out.println("[Bus] Ruta con paradas de " + origen + " a " + destino);
    }
}
