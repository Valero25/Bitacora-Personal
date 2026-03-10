package dosw.bitacora.semana3.patrones.ejercicio3;

/**
 * ActionDollBuilder - Constructor de muñecos de acción
 */
public class ActionDollBuilder implements ToyBuilder {
    private ToyDoll doll;
    
    public ActionDollBuilder() {
        this.doll = new ToyDoll();
    }
    
    @Override
    public void buildHead() {
        doll.setHead("Cabeza de acción con casco");
    }
    
    @Override
    public void buildBody() {
        doll.setBody("Cuerpo musculoso articulado");
    }
    
    @Override
    public void buildArms() {
        doll.setArms("Brazos articulados fuertes");
    }
    
    @Override
    public void buildLegs() {
        doll.setLegs("Piernas articuladas resistentes");
    }
    
    @Override
    public void addAccessories() {
        doll.setAccessories("Arma, escudo y armadura");
    }
    
    @Override
    public ToyDoll getResult() {
        return doll;
    }
}
