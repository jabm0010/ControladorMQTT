package Entidades;

import java.util.ArrayList;
import java.util.List;

public class PartidaNivel1 extends Partida {

    List<List<Recinto>> recintosCorrectos;


    public PartidaNivel1(){
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
            if(recintoCorrecto == false){
                super.numLugaresIncorrectamenteVisitados++;
            }else{
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


}
