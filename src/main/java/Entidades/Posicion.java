package Entidades;

/**
 * Recopila la posicion de un usuario;
 */
public class Posicion {


    long identificador;
    boolean nivel;
    int x;
    int y;


    public Posicion(){
        this.identificador = 0;
        this.nivel = true;
        int x = 0;
        int y = 0;
    }

    public Posicion(long identificador, boolean nivel, int x, int y){
        this.identificador = identificador;
        this.nivel = nivel;
        this.x = x;
        this.y = y;
    }
}
