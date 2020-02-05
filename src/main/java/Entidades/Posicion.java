package Entidades;

/**
 * Recopila la posicion de un usuario;
 */
public class Posicion {


    long identificador;
    int nivel;
    int x;
    int y;


    public Posicion() {
        this.identificador = 0;
        this.nivel = 1;
        int x = 0;
        int y = 0;
    }

    public Posicion(long identificador, int nivel, int x, int y) {
        this.identificador = identificador;
        this.nivel = nivel;
        this.x = x;
        this.y = y;
    }

    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;

    }
}
