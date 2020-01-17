package Test;

import Controladores.ControladorExcel;
import Entidades.*;

public class Main {

    ControladorExcel controladorExcel;

    public static void main(String[] args) {
        FactoryPrueba f = new FactoryPrueba();
        Test t = new Test(f.partidaNivel1Prueba(),f.partidaNivel2Prueba(),f.crearUsuarioPrueba());
        String rutaArchivo = "C:\\Users\\jabm9\\OneDrive\\Escritorio\\Clases\\Entornos Virtuales y Simulacion\\prueba.xlsx";
        String hoja = "Hoja1";

        ControladorExcel controladorExcel = new ControladorExcel(rutaArchivo, t);
        controladorExcel.crearHojaUsuario();
        controladorExcel.crearHojaPartida(true);
        controladorExcel.crearHojaPartida(false);


    }



}
