package dosw.bitacora.semana3.repaso.combinaciones.combo1;

public class AutoCreador extends TransporteCreador {
    @Override
    protected TransporteStrategy crearEstrategia() { return new RutaAuto(); }
}
