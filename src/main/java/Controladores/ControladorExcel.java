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
import java.util.Map;

public class ControladorExcel {

    XSSFWorkbook libro;
    String rutaArchivo;
    String[] hojas = new String[]{"Usuario", "Nivel 1", "Nivel 2", "Test "};
    Test test;
    String[] headerUsuario = new String[]{"Id", "Nombre", "Edad", "Genero", "Dom. Manual"};
    String[] headerPartida1 = new String[]{"Tiempo planificación",
            "Tiempo ejecucion total",
            "Recintos visitados",
            "Tiempos de visita",
            "Caminos repetidos",
            "Puntuacion ruta repetida",
            "Puntuacion recorrido",
            "Nº desvios",
            "Total errores",
            "Puntuación total"
    };

    String[] headerPartida2 = new String[]{"Tiempo planificación",
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

    String[] headerResultadoTest = new String[]{"Puntuacion perfil",
            "+15",
            "+123"};


    public ControladorExcel(String rutaArchivo, Test test) {
        this.rutaArchivo = rutaArchivo;
        this.test = test;

    }


    public void crearExcel() {
        libro = new XSSFWorkbook();
        File file;
        file = new File(rutaArchivo);
        crearHojaUsuario();
        crearHojaPartida1();
        crearHojaPartida2();
        crearHojaTest();

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

    public void crearHojaUsuario() {
        XSSFSheet hojaUsuario = libro.createSheet("Usuario");
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
        for (int i = 0; i < headerUsuario.length; i++) {
            XSSFCell cellContent = rowContent.createCell(i);
            cellContent.setCellStyle(style);
            cellContent.setCellStyle(style);
            System.out.println(atributosUsuario.get(i));
            cellContent.setCellValue(atributosUsuario.get(i));
        }


    }

    public void crearHojaPartida1() {
        XSSFSheet hojaPartida;

        Map<Integer, List<String>> partida = test.getPartidaNivel1().getAtributosExcel();
        hojaPartida = libro.createSheet(hojas[1]);

        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);
        XSSFRow rowHeaders = hojaPartida.createRow(0);
        //Headers
        for (int i = 0; i < headerPartida1.length; i++) {
            XSSFCell cell = rowHeaders.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(headerPartida1[i]);
        }

        for (int i = 0; i < headerPartida1.length; i++) {
            for (int j = 1; j <= partida.get(i).size(); j++) {
                if (hojaPartida.getRow(j) == null) {
                    hojaPartida.createRow(j);
                    System.out.println("He creado la fila" + j);
                }
                XSSFRow rowContent = hojaPartida.getRow(j);
                XSSFCell cellContent = rowContent.createCell(i);
                cellContent.setCellStyle(style);
                cellContent.setCellStyle(style);
                int tmpJ = j - 1;
                System.out.println("A printear " + partida.get(i).get(tmpJ));
                cellContent.setCellValue(partida.get(i).get(tmpJ));

            }

        }


    }


    public void crearHojaPartida2() {
        XSSFSheet hojaPartida;

        Map<Integer, List<String>> partida = test.getPartidaNivel2().getAtributosExcel();
        hojaPartida = libro.createSheet(hojas[2]);

        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);
        XSSFRow rowHeaders = hojaPartida.createRow(0);
        //Headers
        for (int i = 0; i < headerPartida2.length; i++) {
            XSSFCell cell = rowHeaders.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(headerPartida2[i]);
        }

        for (int i = 0; i < headerPartida2.length; i++) {
            for (int j = 1; j <= partida.get(i).size(); j++) {
                if (hojaPartida.getRow(j) == null) {
                    hojaPartida.createRow(j);
                    System.out.println("He creado la fila" + j);
                }
                XSSFRow rowContent = hojaPartida.getRow(j);
                XSSFCell cellContent = rowContent.createCell(i);
                cellContent.setCellStyle(style);
                cellContent.setCellStyle(style);
                int tmpJ = j - 1;
                System.out.println("A printear " + partida.get(i).get(tmpJ));
                cellContent.setCellValue(partida.get(i).get(tmpJ));

            }

        }


    }

    public void crearHojaTest(){
        XSSFSheet hojaPartida;
        test.calcularPuntuacionPerfil();
        hojaPartida = libro.createSheet(hojas[3]);

        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);
        XSSFRow rowHeaders = hojaPartida.createRow(0);
        //Headers
        for (int i = 0; i < headerResultadoTest.length; i++) {
            XSSFCell cell = rowHeaders.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(headerResultadoTest[i]);
        }
        XSSFRow rowContent = hojaPartida.createRow(1);
        List<String> atributosTest = test.listAtributos();

        for (int i = 0; i < headerResultadoTest.length; i++) {
            XSSFCell cellContent = rowContent.createCell(i);
            cellContent.setCellStyle(style);
            cellContent.setCellStyle(style);
            cellContent.setCellValue(atributosTest.get(i));
        }

    }


}
