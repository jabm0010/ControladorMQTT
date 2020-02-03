package Test;

import Controladores.ControladorExcel;
import Entidades.*;

public class Main {

    ControladorExcel controladorExcel;

    public static void main(String[] args) {
        FactoryPrueba f = new FactoryPrueba();
        Test t = new Test(f.partidaNivel1Prueba(),f.partidaNivel2Prueba(),f.crearUsuarioPrueba());
        String userprofile = System.getenv("USERPROFILE");
        String rutaArchivo = userprofile+"\\Desktop\\prueba.xlsx";
        String hoja = "Hoja1";

        ControladorExcel controladorExcel = new ControladorExcel(rutaArchivo, hoja, t);
        controladorExcel.crearHojaResultados();


    }



}
