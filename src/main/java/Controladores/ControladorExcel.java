package Controladores;

import Entidades.Test;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ControladorExcel {

    XSSFWorkbook libro;
    String rutaArchivo;
    String[] hojas = new String[]{"Usuario", "Nivel 1", "Nivel 2", "Test "};
    Test test;
    String[] headerUsuario = new String[]{"Id", "Nombre", "Edad", "Genero", "Dom. Manual"};
    String[] headerPartida = new String[]{"Tiempo planificación",
            "Tiempo ejecucion total",
            "Recintos visitados",
            "Tiempos de visita",
            "Caminos repetidos",
            "Puntuacion ruta repetida",
            "Puntuacion recorrido",
            "Nº Lugares incorrectamente visitados",
            "Nº desvios",
            "Total errores",
            "Puntuación total"
    };

    public ControladorExcel(String rutaArchivo, Test test) {
        this.rutaArchivo = rutaArchivo;
        this.test = test;
        libro = new XSSFWorkbook();
        File file;
        file = new File(rutaArchivo);
        try (FileOutputStream fileOuS = new FileOutputStream(file)) {
            if (file.exists()) {// si el archivo existe se elimina
                file.delete();
                System.out.println("Archivo eliminado");
            }
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
            System.out.println("Archivo Creado");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void crearHojaUsuario(){
        XSSFSheet hojaUsuario = libro.createSheet(hojas[0]);
        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);
        XSSFRow rowHeaders = hojaUsuario.createRow(0);

        //Headers
        for (int i = 0; i < headerUsuario.length; i++) {
            XSSFCell cell = rowHeaders.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(headerUsuario[i]);
        }

        //Content
        XSSFRow rowContent = hojaUsuario.createRow(1);
        List<String> atributosUsuario = test.getUsuario().listAtributos();
        for (int i = 0; i < headerPartida.length; i++) {
            XSSFCell cellContent = rowContent.createCell(i);
            cellContent.setCellStyle(style);
            cellContent.setCellStyle(style);
            cellContent.setCellValue(atributosUsuario.get(i));
        }


    }

    public void crearHojaPartida(boolean nivel) {
        XSSFSheet hojaPartida;
        if(nivel) {
             hojaPartida = libro.createSheet(hojas[1]);
        }else{
             hojaPartida = libro.createSheet(hojas[2]);

        }
        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);
        XSSFRow rowHeaders = hojaPartida.createRow(0);

        //Headers
        for (int i = 0; i < headerPartida.length; i++) {
            XSSFCell cell = rowHeaders.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(headerPartida[i]);
        }







    }


}
