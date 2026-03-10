package dosw.bitacora.semana3.patrones.ejercicio6;

/**
 * Producto - Hoja (Leaf) del patrón Composite
 * Representa un producto individual con precio específico
 */
public class Producto implements ItemBodega {
    private String nombre;
    private double precio;
    
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    @Override
    public double getPrecio() {
        return precio;
    }
    
    @Override
    public void mostrar(int nivel) {
        String indentacion = "  ".repeat(nivel);
        String precioFormateado = (precio % 1 == 0) ? String.format("%.0f", precio) : String.valueOf(precio);
        System.out.println(indentacion + "- Producto: " + nombre + " ($" + precioFormateado + ")");
    }
}
