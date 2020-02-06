package Test;

import Controladores.ControladorExcel;
import Controladores.ControladorPosicion;
import Entidades.*;

import java.io.IOException;

public class Main {

    ControladorExcel controladorExcel;

    public static void main(String[] args) throws IOException {
        FactoryPrueba f = new FactoryPrueba();
        Test t = new Test(f.partidaNivel1Prueba(),f.partidaNivel2Prueba(),f.crearUsuarioPrueba());
        String ficheroExcel = "usuarioPrueba"+".xlsx";
        String ficheroTxt = "usuarioPrueba"+".txt";
        String userprofile = System.getenv("USERPROFILE");
        String ruta =  userprofile+"\\Desktop\\";
        String rutaArchivo = ruta+ficheroExcel;



        ControladorExcel controladorExcel = new ControladorExcel(rutaArchivo, t);
        controladorExcel.crearExcel();
      //  controladorExcel.crearHojaUsuario();
   //     controladorExcel.crearHojaPartida1();
       // controladorExcel.crearHojaPartida(2);

        ControladorPosicion controladorPosicion = new ControladorPosicion();
        controladorPosicion.crearFicheroPosiciones(f.generarPosicionesPrueba(), ruta+ficheroTxt);

        System.out.println("He terminado la ejecución");


    }



}
