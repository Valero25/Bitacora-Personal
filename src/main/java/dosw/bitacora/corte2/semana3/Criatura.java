package dosw.bitacora.corte2.semana3;

import java.util.ArrayList;
import java.util.List;

public class Criatura {
    private String nombre;
    private Tipo tipo;
    private String rareza;
    private int nivel;
    private int experiencia;
    private int hp;
    private int hpMax;
    private int ataque;
    private int defensa;
    private int velocidad;
    private List<Habilidad> habilidades;

    public Criatura(String nombre, Tipo tipo, String rareza, int hp, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.rareza = rareza;
        this.nivel = 1;
        this.experiencia = 0;
        this.hp = hp;
        this.hpMax = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.habilidades = new ArrayList<>();
    }

    public void agregarHabilidad(Habilidad habilidad) {
        if (habilidades.size() < 4) {
            habilidades.add(habilidad);
        }
    }

    public void recibirDano(int dano) {
        this.hp = Math.max(0, this.hp - dano);
    }

    public boolean estaVivo() {
        return this.hp > 0;
    }

    public void restaurarHp() {
        this.hp = this.hpMax;
    }

    public void ganarExperiencia(int exp) {
        this.experiencia += exp;
        while (this.experiencia >= nivel * 100) {
            this.experiencia -= nivel * 100;
            subirNivel();
        }
    }

    private void subirNivel() {
        this.nivel++;
        this.hpMax += 10;
        this.hp = hpMax;
        this.ataque += 3;
        this.defensa += 2;
        this.velocidad += 2;
    }

    public int getPoderTotal() {
        return hpMax + ataque + defensa + velocidad + (nivel * 10);
    }

    public String getNombre() { return nombre; }
    public Tipo getTipo() { return tipo; }
    public String getRareza() { return rareza; }
    public int getNivel() { return nivel; }
    public int getHp() { return hp; }
    public int getHpMax() { return hpMax; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getVelocidad() { return velocidad; }
    public List<Habilidad> getHabilidades() { return habilidades; }

    @Override
    public String toString() {
        return nombre + " [" + tipo + " | Nv." + nivel + " | HP:" + hp + "/" + hpMax
                + " | ATK:" + ataque + " | DEF:" + defensa + " | VEL:" + velocidad + "]";
    }
}
