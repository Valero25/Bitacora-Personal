package dosw.bitacora.semana3.patrones.ejercicio3;

/**
 * Interfaz ToyBuilder - Define los pasos para construir un muñeco
 */
public interface ToyBuilder {
    void buildHead();
    void buildBody();
    void buildArms();
    void buildLegs();
    void addAccessories();
    ToyDoll getResult();
}
