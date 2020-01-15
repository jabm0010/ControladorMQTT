package Entidades;

public class Test {

    PartidaNivel1 partidaNivel1;
    PartidaNivel2 partidaNivel2;

    int puntuacionPerfil;
    boolean planMas15 = false;
    boolean planMas123 = false;


    public Test(PartidaNivel1 p1, PartidaNivel2 p2){
        partidaNivel1 = p1;
        partidaNivel2 = p2;
    }

    private void calcularPuntuacionPerfil(){

        int puntuacionTotal = partidaNivel1.puntuacionTotal + partidaNivel2.puntuacionTotal;
        if(puntuacionTotal == 16){
            puntuacionPerfil = 4;
        }else if(puntuacionTotal >= 11){
            puntuacionPerfil = 3;
        }else if(puntuacionTotal >= 6){
            puntuacionPerfil = 2;
        }else if(puntuacionTotal >= 1){
            puntuacionPerfil = 1;
        }else{
            puntuacionPerfil = 0;
        }

        if(partidaNivel2.tiempoPlanificacion >15){
            planMas15 = true;
            if(puntuacionPerfil > 0){
                puntuacionPerfil--;
            }

        }

        if(partidaNivel2.tiempoPlanificacion >123){
            planMas123 = true;
            if(puntuacionPerfil > 0){
                puntuacionPerfil--;
            }

        }






    }

}
