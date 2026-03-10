package dosw.bitacora.semana3.repaso.base.chainofresponsibility;

/** Handler: define el contrato de la cadena */
public interface Aprobador {
    void setSiguiente(Aprobador siguiente);
    void aprobar(int monto);
}
