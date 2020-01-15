package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    String nombre;
    long identificador;
    int edad;
    String genero;
    String dominanciaManual;

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




}
