package dosw.bitacora.corte2.semana3;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private String email;
    private int nivel;
    private int experiencia;
    private int elo;
    private List<Criatura> inventario;

    public Usuario(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.nivel = 1;
        this.experiencia = 0;
        this.elo = 1000;
        this.inventario = new ArrayList<>();
    }

    public void agregarCriatura(Criatura criatura) {
        inventario.add(criatura);
    }

    public int getPoderTotal() {
        return inventario.stream().mapToInt(Criatura::getPoderTotal).sum();
    }

    public void actualizarElo(int cambio) {
        this.elo = Math.max(0, this.elo + cambio);
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public int getNivel() { return nivel; }
    public int getElo() { return elo; }
    public List<Criatura> getInventario() { return inventario; }

    @Override
    public String toString() {
        return nombre + " [Nv." + nivel + " | ELO:" + elo + " | Criaturas:" + inventario.size() + "]";
    }
}
