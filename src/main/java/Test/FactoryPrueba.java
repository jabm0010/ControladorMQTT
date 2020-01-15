package Test;

import Entidades.PartidaNivel1;
import Entidades.PartidaNivel2;
import Entidades.Recinto;
import Entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class FactoryPrueba {


    public Usuario crearUsuarioPrueba(){
        String nombre = "Eusebio Fernandez Gomez";
        long identificador = 1;
        int edad = 56;
        String genero = "Hombre";
        String dominanciaManual = "Diestro";

        return new Usuario(nombre,identificador,edad,genero,dominanciaManual);
    }



    public PartidaNivel1 partidaNivel1Prueba(){

        int tiempoPlanificacion = 20;
        int numeroDesvios = 3;
        List<Recinto> listaRecintosVisitados = new ArrayList<>();
        List<Integer> listaTiempoVisitas = new ArrayList<>();
        List<Integer> caminosRepetidos = new ArrayList<>();

        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Entrada));
        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Llama));
        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Elefante));
        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Cafe));
        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Oso));
        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Leones));
        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Pajaro));
        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Picnic));

        listaTiempoVisitas.add(0);
        listaTiempoVisitas.add(12);
        listaTiempoVisitas.add(11);
        listaTiempoVisitas.add(9);
        listaTiempoVisitas.add(15);
        listaTiempoVisitas.add(17);
        listaTiempoVisitas.add(8);
        listaTiempoVisitas.add(22);

        caminosRepetidos.add(1);
        caminosRepetidos.add(2);
        caminosRepetidos.add(1);
        caminosRepetidos.add(2);
        caminosRepetidos.add(1);
        caminosRepetidos.add(1);
        caminosRepetidos.add(2);
        caminosRepetidos.add(1);
        caminosRepetidos.add(2);
        caminosRepetidos.add(3);
        caminosRepetidos.add(1);
        caminosRepetidos.add(1);
        caminosRepetidos.add(1);

        return new PartidaNivel1(tiempoPlanificacion, listaRecintosVisitados, listaTiempoVisitas, caminosRepetidos, numeroDesvios);
    }

    public PartidaNivel2 partidaNivel2Prueba(){
        int tiempoPlanificacion = 20;
        int numeroDesvios = 3;
        List<Recinto> listaRecintosVisitados = new ArrayList<>();
        List<Integer> listaTiempoVisitas = new ArrayList<>();
        List<Integer> caminosRepetidos = new ArrayList<>();

        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Entrada));
        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Cafe));
        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Llama));
        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Elefante));
        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Oso));
        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Leones));
        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Pajaro));
        listaRecintosVisitados.add(new Recinto(Recinto.ValoresRecinto.Picnic));

        listaTiempoVisitas.add(0);
        listaTiempoVisitas.add(12);
        listaTiempoVisitas.add(11);
        listaTiempoVisitas.add(9);
        listaTiempoVisitas.add(15);
        listaTiempoVisitas.add(17);
        listaTiempoVisitas.add(8);
        listaTiempoVisitas.add(22);

        caminosRepetidos.add(1);
        caminosRepetidos.add(2);
        caminosRepetidos.add(1);
        caminosRepetidos.add(2);
        caminosRepetidos.add(1);
        caminosRepetidos.add(1);
        caminosRepetidos.add(2);
        caminosRepetidos.add(1);
        caminosRepetidos.add(2);
        caminosRepetidos.add(3);
        caminosRepetidos.add(1);
        caminosRepetidos.add(1);
        caminosRepetidos.add(1);

        return new PartidaNivel2(tiempoPlanificacion, listaRecintosVisitados, listaTiempoVisitas, caminosRepetidos, numeroDesvios);


    }
}
