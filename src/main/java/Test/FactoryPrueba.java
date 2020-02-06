package Test;

import Entidades.*;

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
        long identificador = 1;
        int tiempoPlanificacion = 20;
        int numeroDesvios = 1;
        List<Recinto> listaRecintosVisitados = new ArrayList<>();
        List<Integer> listaTiempoVisitas = new ArrayList<>();
        List<Integer> caminosRepetidos = new ArrayList<>();

        listaRecintosVisitados.add(new Recinto("Entrada"));
        listaRecintosVisitados.add(new Recinto("Llamas"));
        listaRecintosVisitados.add(new Recinto("Elefantes"));
        listaRecintosVisitados.add(new Recinto("Cafe"));
        listaRecintosVisitados.add(new Recinto("Osos"));
        listaRecintosVisitados.add(new Recinto("Leones"));
        listaRecintosVisitados.add(new Recinto("Pajaros"));
        listaRecintosVisitados.add(new Recinto("Picnic"));

        listaTiempoVisitas.add(0);
        listaTiempoVisitas.add(12);
        listaTiempoVisitas.add(28);
        listaTiempoVisitas.add(49);
        listaTiempoVisitas.add(78);
        listaTiempoVisitas.add(120);
        listaTiempoVisitas.add(139);
        listaTiempoVisitas.add(179);

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

        PartidaNivel1 p  = new PartidaNivel1();
        p.setTiempoPlanificacion(tiempoPlanificacion);
        p.setListaRecintosVisitados(listaRecintosVisitados);
        p.setTiempoVisitas(listaTiempoVisitas);
        p.setCaminosRepetidos(caminosRepetidos);
        p.setNumeroDesvios(numeroDesvios);
        p.setIdentificador(identificador);
        //return new PartidaNivel1(tiempoPlanificacion, listaRecintosVisitados, listaTiempoVisitas, caminosRepetidos, numeroDesvios,identificador);

        p.inicializarPartidaNivel1();
        return p;
    }

    public PartidaNivel2 partidaNivel2Prueba(){
        long identificador = 1;
        int tiempoPlanificacion = 20;
        int numeroDesvios = 3;
        List<Recinto> listaRecintosVisitados = new ArrayList<>();
        List<Integer> listaTiempoVisitas = new ArrayList<>();
        List<Integer> caminosRepetidos = new ArrayList<>();

        listaRecintosVisitados.add(new Recinto("Entrada"));
        listaRecintosVisitados.add(new Recinto("Llamas"));
        listaRecintosVisitados.add(new Recinto("Elefantes"));
        listaRecintosVisitados.add(new Recinto("Cafe"));
        listaRecintosVisitados.add(new Recinto("Osos"));
        listaRecintosVisitados.add(new Recinto("Leones"));
        listaRecintosVisitados.add(new Recinto("Pajaros"));
        listaRecintosVisitados.add(new Recinto("Picnic"));

        listaTiempoVisitas.add(0);
        listaTiempoVisitas.add(12);
        listaTiempoVisitas.add(28);
        listaTiempoVisitas.add(49);
        listaTiempoVisitas.add(67);
        listaTiempoVisitas.add(89);
        listaTiempoVisitas.add(91);
        listaTiempoVisitas.add(120);

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

        PartidaNivel2 p  = new PartidaNivel2();
        p.setTiempoPlanificacion(tiempoPlanificacion);
        p.setListaRecintosVisitados(listaRecintosVisitados);
        p.setTiempoVisitas(listaTiempoVisitas);
        p.setCaminosRepetidos(caminosRepetidos);
        p.setNumeroDesvios(numeroDesvios);
        p.setIdentificador(identificador);
        p.inicalizarPartidaNivel2();

        return p;
        //return new PartidaNivel2(tiempoPlanificacion, listaRecintosVisitados, listaTiempoVisitas, caminosRepetidos, numeroDesvios,identificador);


    }

    public List<Posicion> generarPosicionesPrueba(){
        List<Posicion> posiciones = new ArrayList<>();
        posiciones.add(new Posicion(10,1, 280,120));
        posiciones.add(new Posicion(10,1, 283,140));

        return posiciones;

    }
}
