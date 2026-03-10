package dosw.bitacora.semana3.repaso.base.composite;

/** Hoja: no tiene hijos */
public class Archivo implements Componente {
    private String nombre;

    public Archivo(String nombre) { this.nombre = nombre; }

    @Override
    public void mostrar(String indent) {
        System.out.println(indent + "- " + nombre);
    }
}
