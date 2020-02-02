package Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class PartidaNivel1 extends Partida {

    List<List<Recinto>> recintosCorrectos;


    public PartidaNivel1() {
        super();
    }

    public PartidaNivel1(int tiempoPlanificacion, List<Recinto> listaRecintosVisitados, List<Integer> tiempoVisitas, List<Integer> caminosRepetidos,
                         int numeroDesvios) {

        super(tiempoPlanificacion, listaRecintosVisitados, tiempoVisitas, caminosRepetidos, numeroDesvios);

        iniciarRecintosCorrectos();
        calcularPuntuacionRecorrido();
        super.calcularTotalErrores();
        super.calcularPuntuacionTotal();

    }


    private void calcularPuntuacionRecorrido() {

        for (int i = 0; i < listaRecintosVisitados.size(); i++) {
            boolean recintoCorrecto = false;
            for (Recinto r : recintosCorrectos.get(i)) {
                if (listaRecintosVisitados.get(i).recinto == r.recinto) {
                    recintoCorrecto = true;
                }
            }
            if (recintoCorrecto == false) {
                super.numLugaresIncorrectamenteVisitados++;
            } else {
                super.puntuacionRecorrido++;
            }

        }
    }

    private void iniciarRecintosCorrectos() {

        List<List<Recinto>> recintos = new ArrayList<>();

        List<Recinto> r1 = new ArrayList<>();
        r1.add(new Recinto(Recinto.ValoresRecinto.Entrada));

        List<Recinto> r2 = new ArrayList<>();
        r2.add(new Recinto(Recinto.ValoresRecinto.Llama));
        r2.add(new Recinto(Recinto.ValoresRecinto.Cafe));
        r2.add(new Recinto(Recinto.ValoresRecinto.Elefante));

        List<Recinto> r3 = new ArrayList<>();
        r3.add(new Recinto(Recinto.ValoresRecinto.Cafe));
        r3.add(new Recinto(Recinto.ValoresRecinto.Elefante));

        List<Recinto> r4 = new ArrayList<>();
        r4.add(new Recinto(Recinto.ValoresRecinto.Llama));
        r4.add(new Recinto(Recinto.ValoresRecinto.Cafe));
        r4.add(new Recinto(Recinto.ValoresRecinto.Elefante));

        List<Recinto> r5 = new ArrayList<>();
        r5.add(new Recinto(Recinto.ValoresRecinto.Oso));

        List<Recinto> r6 = new ArrayList<>();
        r6.add(new Recinto(Recinto.ValoresRecinto.Leones));

        List<Recinto> r7 = new ArrayList<>();
        r7.add(new Recinto(Recinto.ValoresRecinto.Pajaro));

        List<Recinto> r8 = new ArrayList<>();
        r8.add(new Recinto(Recinto.ValoresRecinto.Picnic));


        recintos.add(r1);
        recintos.add(r2);
        recintos.add(r3);
        recintos.add(r4);
        recintos.add(r5);
        recintos.add(r6);
        recintos.add(r7);
        recintos.add(r8);

        recintosCorrectos = recintos;
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
        l7.add( String.valueOf(numeroDesvios));
        partida.put(7,l7);

        ArrayList<String> l8 = new ArrayList();
        l8.add( String.valueOf(totalErrores));
        partida.put(8,l8);

        ArrayList<String> l9 = new ArrayList();
        l9.add( String.valueOf(puntuacionTotal));
        partida.put(9,l9);

        return partida;
    }


}
