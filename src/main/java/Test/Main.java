package Test;

import Controladores.ControladorExcel;
import Entidades.*;

public class Main {

    ControladorExcel controladorExcel;

    public static void main(String[] args) {
        FactoryPrueba f = new FactoryPrueba();
        Test t = new Test(f.partidaNivel1Prueba(),f.partidaNivel2Prueba(),f.crearUsuarioPrueba());
        String ficheroExcel = "usuarioPrueba"+".xlsx";
        String userprofile = System.getenv("USERPROFILE");
        String ruta =  userprofile+"\\Desktop\\";
        String rutaArchivo = ruta+ficheroExcel;



        ControladorExcel controladorExcel = new ControladorExcel(rutaArchivo, t);
        controladorExcel.crearExcel();
      //  controladorExcel.crearHojaUsuario();
   //     controladorExcel.crearHojaPartida1();
       // controladorExcel.crearHojaPartida(2);


    }



}
