package Entidades;


public class Test {

    PartidaNivel1 partidaNivel1;
    PartidaNivel2 partidaNivel2;
    Usuario usuario;


    int puntuacionPerfil;
    boolean planMas15 = false;
    boolean planMas123 = false;


    public Test(){
        this.partidaNivel1 = new PartidaNivel1();
        this.partidaNivel2 = new PartidaNivel2();
        this.usuario = new Usuario();
    }

    public Test(PartidaNivel1 p1, PartidaNivel2 p2, Usuario usuario) {
        partidaNivel1 = p1;
        partidaNivel2 = p2;
        this.usuario = usuario;
    }

    private void calcularPuntuacionPerfil() {

        int puntuacionTotal = partidaNivel1.puntuacionTotal + partidaNivel2.puntuacionTotal;
        if (puntuacionTotal == 16) {
            puntuacionPerfil = 4;
        } else if (puntuacionTotal >= 11) {
            puntuacionPerfil = 3;
        } else if (puntuacionTotal >= 6) {
            puntuacionPerfil = 2;
        } else if (puntuacionTotal >= 1) {
            puntuacionPerfil = 1;
        } else {
            puntuacionPerfil = 0;
        }

        if (partidaNivel2.tiempoPlanificacion > 15) {
            planMas15 = true;
            if (puntuacionPerfil > 0) {
                puntuacionPerfil--;
            }

        }

        if (partidaNivel2.tiempoPlanificacion > 123) {
            planMas123 = true;
            if (puntuacionPerfil > 0) {
                puntuacionPerfil--;
            }

        }


    }

    public PartidaNivel1 getPartidaNivel1() {
        return partidaNivel1;
    }

    public void setPartidaNivel1(PartidaNivel1 partidaNivel1) {
        this.partidaNivel1 = partidaNivel1;
    }

    public PartidaNivel2 getPartidaNivel2() {
        return partidaNivel2;
    }

    public void setPartidaNivel2(PartidaNivel2 partidaNivel2) {
        this.partidaNivel2 = partidaNivel2;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getPuntuacionPerfil() {
        return puntuacionPerfil;
    }

    public void setPuntuacionPerfil(int puntuacionPerfil) {
        this.puntuacionPerfil = puntuacionPerfil;
    }

    public boolean isPlanMas15() {
        return planMas15;
    }

    public void setPlanMas15(boolean planMas15) {
        this.planMas15 = planMas15;
    }

    public boolean isPlanMas123() {
        return planMas123;
    }

    public void setPlanMas123(boolean planMas123) {
        this.planMas123 = planMas123;
    }
}
