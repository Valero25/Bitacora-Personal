package dosw.bitacora.semana3.repaso.base.abstractfactory;

public class FabricaVictoriana implements FabricaMuebles {
    @Override public Silla crearSilla() { return new SillaVictorina(); }
    @Override public Mesa crearMesa()   { return new MesaVictoriana(); }
}
