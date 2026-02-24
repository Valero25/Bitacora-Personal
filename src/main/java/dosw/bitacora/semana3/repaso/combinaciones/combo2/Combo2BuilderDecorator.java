package dosw.bitacora.semana3.repaso.combinaciones.combo2;

public class Combo2BuilderDecorator {
    public static void main(String[] args) {
        // Builder crea la pizza base
        Pizza pizza = new PizzaBuilder()
                .tamano("Grande")
                .masa("gruesa")
                .salsa("BBQ")
                .build();

        System.out.println(pizza.descripcion() + " → $" + pizza.precio());

        // Decorator agrega toppings sin modificar la clase
        pizza = new ToppingQueso(pizza);
        pizza = new ToppingJamon(pizza);

        System.out.println(pizza.descripcion() + " → $" + pizza.precio());
    }
}
