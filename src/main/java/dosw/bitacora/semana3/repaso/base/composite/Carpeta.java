package dosw.bitacora.semana3.repaso.base.composite;

import java.util.ArrayList;
import java.util.List;

/** Compuesto: puede contener hojas u otros compuestos */
public class Carpeta implements Componente {
    private String nombre;
    private List<Componente> hijos = new ArrayList<>();

    public Carpeta(String nombre) { this.nombre = nombre; }

    public void agregar(Componente c) { hijos.add(c); }

    @Override
    public void mostrar(String indent) {
        System.out.println(indent + "+ " + nombre);
        hijos.forEach(h -> h.mostrar(indent + "  "));
    }
}
