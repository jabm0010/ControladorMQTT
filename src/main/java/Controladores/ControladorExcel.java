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


    String rutaArchivo;
    String hoja;
    Test test;
    String[] header = new String[]{"Id", "Nombre", "Edad", "Genero", "Dom. Manual"};

    public ControladorExcel(String rutaArchivo, String hoja, Test test) {
        this.rutaArchivo = rutaArchivo;
        this.hoja = hoja;
        this.test = test;


    }

    public void crearHojaResultados() {
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);

        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);

        XSSFRow rowHeaders = hoja1.createRow(0);
        for (int j = 0; j < header.length; j++) {
            XSSFCell cell = rowHeaders.createCell(j);
            cell.setCellStyle(style);
            cell.setCellValue(header[j]);
        }

        XSSFRow rowContent = hoja1.createRow(1);
        List<String> atributosUsuario = test.getUsuario().listAtributos();
        for(int i = 0; i<header.length;i++){
            XSSFCell cellContent =  rowContent.createCell(i);
            cellContent.setCellStyle(style);
            cellContent.setCellStyle(style);
            cellContent.setCellValue(atributosUsuario.get(i));
        }




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


}
