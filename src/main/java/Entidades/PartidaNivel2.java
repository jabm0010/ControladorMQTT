package Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class PartidaNivel2 extends Partida {

    List<Recinto> recintosCorrectos = new ArrayList<>();

    public PartidaNivel2(){
        super();
    }

    public PartidaNivel2(int tiempoPlanificacion, List<Recinto> listaRecintosVisitados, List<Integer> tiempoVisitas, List<Integer> caminosRepetidos,
                         int numeroDesvios, Long identificador) {


        super(tiempoPlanificacion, listaRecintosVisitados, tiempoVisitas, caminosRepetidos, numeroDesvios, identificador);

        iniciarRecintosCorrectos();
        calcularPuntuacionRecorrido();
        super.calcularTotalErrores();
        super.calcularPuntuacionTotal();
    }


    private void calcularPuntuacionRecorrido() {

        for (int i = 0; i < listaRecintosVisitados.size(); i++) {
            if (listaRecintosVisitados.get(i).recinto == recintosCorrectos.get(i).recinto) {
                super.puntuacionRecorrido++;
            } else {
                super.numLugaresIncorrectamenteVisitados++;

            }

        }
    }


    private void iniciarRecintosCorrectos(){

        recintosCorrectos.add(new Recinto(Recinto.ValoresRecinto.Entrada));
        recintosCorrectos.add(new Recinto(Recinto.ValoresRecinto.Llama));
        recintosCorrectos.add(new Recinto(Recinto.ValoresRecinto.Elefante));
        recintosCorrectos.add(new Recinto(Recinto.ValoresRecinto.Cafe));
        recintosCorrectos.add(new Recinto(Recinto.ValoresRecinto.Oso));
        recintosCorrectos.add(new Recinto(Recinto.ValoresRecinto.Leones));
        recintosCorrectos.add(new Recinto(Recinto.ValoresRecinto.Pajaro));
        recintosCorrectos.add(new Recinto(Recinto.ValoresRecinto.Picnic));



    }



    public Map<Integer, List<String>> getAtributosExcel() {

        Map<Integer, List<String>> partida = new TreeMap<>();

        ArrayList<String> l0 = new ArrayList();
        l0.add( String.valueOf(tiempoPlanificacion));
        partida.put(0,l0);

        ArrayList<String> l1 = new ArrayList();
        l1.add( String.valueOf(tiempoEjecucionTotal));
        partida.put(1,l1);

        List<String> l2 = listaRecintosVisitados.stream().map(recinto -> recinto.recinto.toString()).
                collect(toList());
        partida.put(2, l2);

        List<String> l3 = tiempoVisitas.stream().map(tiempo -> String.valueOf(tiempo)).collect(Collectors.toList());
        partida.put(3, l3);

        List<String> l4 = caminosRepetidos.stream().map(camino -> String.valueOf(camino)).collect(Collectors.toList());
        partida.put(4, l4);

        ArrayList<String> l5 = new ArrayList();
        l5.add( String.valueOf(puntuacionTotalVecesRutaRepetida));
        partida.put(5,l5);

        ArrayList<String> l6 = new ArrayList();
        l6.add( String.valueOf(puntuacionRecorrido));
        partida.put(6,l6);

        ArrayList<String> l7 = new ArrayList();
        l6.add( String.valueOf(numLugaresIncorrectamenteVisitados));
        partida.put(7,l7);

        ArrayList<String> l8 = new ArrayList();
        l7.add( String.valueOf(numeroDesvios));
        partida.put(8,l8);

        ArrayList<String> l9 = new ArrayList();
        l8.add( String.valueOf(totalErrores));
        partida.put(9,l9);

        ArrayList<String> l10 = new ArrayList();
        l9.add( String.valueOf(puntuacionTotal));
        partida.put(10,l10);

        return partida;
    }


}
