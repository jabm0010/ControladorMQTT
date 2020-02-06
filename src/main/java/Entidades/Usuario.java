package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    String nombre;
    long identificador;
    int edad;
    String genero;
    String dominanciaManual;
    String fecha;

    public Usuario(){
        this.nombre = "";
        this.identificador = 0;
        this.edad = 0;
        this.genero = "";
        this.dominanciaManual = "";
    }



    public Usuario(String nombre, Long identificador, int edad, String genero, String dominanciaManual){
        this.nombre = nombre;
        this.identificador = identificador;
        this.edad = edad;
        this.genero = genero;
        this.dominanciaManual = dominanciaManual;
    }


    public List<String> listAtributos(){
        List<String> lRet = new ArrayList<>();

        lRet.add(String.valueOf(identificador));
        lRet.add(nombre);
        lRet.add(String.valueOf(edad));
        lRet.add(genero);
        lRet.add(dominanciaManual);

        return  lRet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDominanciaManual() {
        return dominanciaManual;
    }

    public void setDominanciaManual(String dominanciaManual) {
        this.dominanciaManual = dominanciaManual;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
