package Entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Partida {

    Long identificador;
    int tiempoPlanificacion;
    int tiempoEjecucionTotal;

    List<Recinto> listaRecintosVisitados;
    List<Integer> tiempoVisitas;
    List<Integer> caminosRepetidos;
    int puntuacionTotalVecesRutaRepetida;
    int puntuacionRecorrido;
    int numLugaresIncorrectamenteVisitados;
    int numeroDesvios;
    int totalErrores;

    int puntuacionTotal;


    public Partida() {

    }


    public Partida(int tiempoPlanificacion, List<Recinto> listaRecintosVisitados, List<Integer> tiempoVisitas, List<Integer> caminosRepetidos,
                   int numeroDesvios, Long identificador) {

        this.identificador = identificador;
        this.tiempoPlanificacion = tiempoPlanificacion;
        this.listaRecintosVisitados = listaRecintosVisitados;
        this.tiempoVisitas = tiempoVisitas;
        this.caminosRepetidos = caminosRepetidos;
        this.numeroDesvios = numeroDesvios;


    }


    public void inicializarPartidaGeneral() {

        this.tiempoEjecucionTotal = tiempoVisitas.get(tiempoVisitas.size() - 1);

        List<Integer> tiempoVisitasAjustado = new ArrayList<>();
        for (int i = 0; i < tiempoVisitas.size(); i++) {
            if (i == 0) {
                tiempoVisitasAjustado.add(tiempoVisitas.get(i));
            } else {
                tiempoVisitasAjustado.add(tiempoVisitas.get(i) - tiempoVisitas.get(i - 1));
            }
        }

        this.tiempoVisitas = tiempoVisitasAjustado;

        //Calculamos el tiempo de ejecución total en base a los tiempos parciales de cada visita


        //Normalizar los valores de caminos para que se ajusten a los requisitos
        normalizarCaminosRepetidos();
        //Calculamos el total de veces de caminos repetidos
        this.puntuacionTotalVecesRutaRepetida = caminosRepetidos.stream().mapToInt(Integer::intValue).sum();
    }


    protected void calcularTotalErrores() {
        this.totalErrores = numeroDesvios + puntuacionTotalVecesRutaRepetida + numLugaresIncorrectamenteVisitados;
    }

    protected void calcularPuntuacionTotal() {
        this.puntuacionTotal = puntuacionRecorrido - totalErrores;
        if(puntuacionTotal < 0){
            this.puntuacionTotal = 0;
        }
    }

    public void normalizarCaminosRepetidos() {
        List<Integer> caminosAjustados = new ArrayList<>();
        for(int i = 0; i<caminosRepetidos.size();i++){
            if(caminosRepetidos.get(i)>0){
                int restarUno = caminosRepetidos.get(i)-1;
                caminosAjustados.add(i,restarUno);
            }else{
                caminosAjustados.add(i,caminosRepetidos.get(i));
            }
        }

        caminosRepetidos = caminosAjustados;
    }


    public int getTiempoPlanificacion() {
        return tiempoPlanificacion;
    }

    public void setTiempoPlanificacion(int tiempoPlanificacion) {
        this.tiempoPlanificacion = tiempoPlanificacion;
    }

    public int getTiempoEjecucionTotal() {
        return tiempoEjecucionTotal;
    }

    public void setTiempoEjecucionTotal(int tiempoEjecucionTotal) {
        this.tiempoEjecucionTotal = tiempoEjecucionTotal;
    }

    public List<Recinto> getListaRecintosVisitados() {
        return listaRecintosVisitados;
    }

    public void setListaRecintosVisitados(List<Recinto> listaRecintosVisitados) {
        this.listaRecintosVisitados = listaRecintosVisitados;
    }

    public List<Integer> getTiempoVisitas() {
        return tiempoVisitas;
    }

    public void setTiempoVisitas(List<Integer> tiempoVisitas) {
        this.tiempoVisitas = tiempoVisitas;
    }

    public List<Integer> getCaminosRepetidos() {
        return caminosRepetidos;
    }

    public void setCaminosRepetidos(List<Integer> caminosRepetidos) {
        this.caminosRepetidos = caminosRepetidos;
    }

    public int getPuntuacionTotalVecesRutaRepetida() {
        return puntuacionTotalVecesRutaRepetida;
    }

    public void setPuntuacionTotalVecesRutaRepetida(int puntuacionTotalVecesRutaRepetida) {
        this.puntuacionTotalVecesRutaRepetida = puntuacionTotalVecesRutaRepetida;
    }

    public int getPuntuacionRecorrido() {
        return puntuacionRecorrido;
    }

    public void setPuntuacionRecorrido(int puntuacionRecorrido) {
        this.puntuacionRecorrido = puntuacionRecorrido;
    }

    public int getNumeroDesvios() {
        return numeroDesvios;
    }

    public void setNumeroDesvios(int numeroDesvios) {
        this.numeroDesvios = numeroDesvios;
    }

    public int getTotalErrores() {
        return totalErrores;
    }

    public void setTotalErrores(int totalErrores) {
        this.totalErrores = totalErrores;
    }

    public int getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public int getNumLugaresIncorrectamenteVisitados() {
        return numLugaresIncorrectamenteVisitados;
    }

    public void setNumLugaresIncorrectamenteVisitados(int numLugaresIncorrectamenteVisitados) {
        this.numLugaresIncorrectamenteVisitados = numLugaresIncorrectamenteVisitados;
    }
}
