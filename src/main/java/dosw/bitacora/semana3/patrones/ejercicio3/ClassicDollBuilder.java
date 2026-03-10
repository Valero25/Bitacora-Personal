package dosw.bitacora.semana3.patrones.ejercicio3;

/**
 * ClassicDollBuilder - Constructor de muñecos clásicos
 */
public class ClassicDollBuilder implements ToyBuilder {
    private ToyDoll doll;
    
    public ClassicDollBuilder() {
        this.doll = new ToyDoll();
    }
    
    @Override
    public void buildHead() {
        doll.setHead("Cabeza clásica con cabello suave");
    }
    
    @Override
    public void buildBody() {
        doll.setBody("Cuerpo suave de tela");
    }
    
    @Override
    public void buildArms() {
        doll.setArms("Brazos flexibles de tela");
    }
    
    @Override
    public void buildLegs() {
        doll.setLegs("Piernas suaves cosidas");
    }
    
    @Override
    public void addAccessories() {
        doll.setAccessories("Vestido y zapatos");
    }
    
    @Override
    public ToyDoll getResult() {
        return doll;
    }
}
