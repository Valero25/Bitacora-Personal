package dosw.bitacora.semana3.repaso.base.abstractfactory;

/**
 * Abstract Factory: declara la creación de TODA la familia de productos.
 * Garantiza que los productos creados sean compatibles entre sí.
 */
public interface FabricaMuebles {
    Silla crearSilla();
    Mesa crearMesa();
}
