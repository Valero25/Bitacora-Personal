package dosw.bitacora.semana3.repaso.base.abstractfactory;

public class FabricaModerna implements FabricaMuebles {
    @Override public Silla crearSilla() { return new SillaModerna(); }
    @Override public Mesa crearMesa()   { return new MesaModerna(); }
}
