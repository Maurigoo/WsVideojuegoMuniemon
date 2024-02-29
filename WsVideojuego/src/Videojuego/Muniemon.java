package Videojuego;

public class Muniemon {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private TipoMuniemon tipo;

    public Muniemon(String nombre, int vida, int ataque, int defensa, TipoMuniemon tipo) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public TipoMuniemon getTipo() {
        return tipo;
    }

    public void setTipo(TipoMuniemon tipo) {
        this.tipo = tipo;
    }

    public void atacar(Muniemon objetivo) {
        int ataqueRealizado = this.ataque - objetivo.getDefensa();
        if (ataqueRealizado < 0) {
            ataqueRealizado = 0;
        }
        objetivo.setVida(objetivo.getVida() - ataqueRealizado);
        System.out.println(this.nombre + " atacó a " + objetivo.getNombre() + " y le quitó " + ataqueRealizado + " puntos de vida.");
        if (objetivo.getVida() <= 0) {
            System.out.println(objetivo.getNombre() + " ha sido derrotado.");
        }
    }
}
