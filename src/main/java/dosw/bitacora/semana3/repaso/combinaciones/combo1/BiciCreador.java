package dosw.bitacora.semana3.repaso.combinaciones.combo1;

public class BiciCreador extends TransporteCreador {
    @Override
    protected TransporteStrategy crearEstrategia() { return new RutaBici(); }
}
