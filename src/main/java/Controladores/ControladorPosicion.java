package Controladores;

import Entidades.Posicion;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ControladorPosicion {

    public ControladorPosicion(){

    }

    public void crearFicheroPosiciones(List<Posicion> posiciones, String ruta) throws IOException {
        FileWriter writer = new FileWriter(ruta);
        for(Posicion p : posiciones){
            writer.write(p.toString() + System.lineSeparator());
        }

        writer.close();
    }


}
