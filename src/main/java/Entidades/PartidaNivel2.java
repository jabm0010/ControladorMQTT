package Entidades;

import java.util.List;

public class PartidaNivel2 extends Partida {

    List<Recinto> recintosCorrectos;

    public PartidaNivel2(int tiempoPlanificacion, List<Recinto> listaRecintosVisitados, List<Integer> tiempoVisitas, List<Integer> caminosRepetidos,
                         int numeroDesvios) {


        super(tiempoPlanificacion, listaRecintosVisitados, tiempoVisitas, caminosRepetidos, numeroDesvios);

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

}
