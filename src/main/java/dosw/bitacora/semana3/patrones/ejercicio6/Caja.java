package dosw.bitacora.semana3.patrones.ejercicio6;

import java.util.ArrayList;
import java.util.List;

/**
 * Caja - Compuesto (Composite) del patrón Composite
 * Representa una caja que puede contener productos y/o otras cajas
 */
public class Caja implements ItemBodega {
    private String nombre;
    private List<ItemBodega> items;
    
    public Caja(String nombre) {
        this.nombre = nombre;
        this.items = new ArrayList<>();
    }
    
    public void agregar(ItemBodega item) {
        items.add(item);
    }
    
    public void remover(ItemBodega item) {
        items.remove(item);
    }
    
    @Override
    public double getPrecio() {
        // Recorre todos los items y suma sus precios
        double total = 0;
        for (ItemBodega item : items) {
            total += item.getPrecio();
        }
        return total;
    }
    
    @Override
    public void mostrar(int nivel) {
        String indentacion = "  ".repeat(nivel);
        double precio = getPrecio();
        String precioFormateado = (precio % 1 == 0) ? String.format("%.0f", precio) : String.valueOf(precio);
        System.out.println(indentacion + "+ Caja: " + nombre + " (Precio total: $" + precioFormateado + ")");
        for (ItemBodega item : items) {
            item.mostrar(nivel + 1);
        }
    }
}
