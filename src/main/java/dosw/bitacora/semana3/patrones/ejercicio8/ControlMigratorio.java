package dosw.bitacora.semana3.patrones.ejercicio8;

/**
 * ControlMigratorio - Interfaz del patrón Chain of Responsibility
 * Define el contrato para cada eslabón de la cadena de controles
 */
public interface ControlMigratorio {
    void setSiguiente(ControlMigratorio siguiente);
    void procesar(IngresoRequest request);
}
