package dosw.bitacora.semana3.patrones.ejercicio3;

/**
 * ToyFactory - Director que coordina el proceso de construcción
 */
public class ToyFactory {
    public ToyDoll constructDoll(ToyBuilder builder) {
        builder.buildHead();
        builder.buildBody();
        builder.buildArms();
        builder.buildLegs();
        builder.addAccessories();
        return builder.getResult();
    }
}
