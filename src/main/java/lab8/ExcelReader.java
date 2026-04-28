package lab8;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReader {

    public static void main(String[] args) {
        String inputFile = "laborator8_input.xlsx";

        // Apelăm metodele pentru cele două cerințe
        genereazaFisierCuMedieCalculata(inputFile, "laborator8_output2.xlsx");
        genereazaFisierCuMedieFormula(inputFile, "laborator8_output3.xlsx");

        System.out.println("Fisierele output au fost generate cu succes!");
    }

    // --- Rezolvare 8.5.2 ---
    public static void genereazaFisierCuMedieCalculata(String inputPath, String outputPath) {
        try (FileInputStream inputStream = new FileInputStream(new File(inputPath));
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            // Parcurgem rândurile. Presupunem că rândul 0 este header-ul (capul de tabel)
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell newCell = row.createCell(6); // Creăm o celulă nouă pe coloana G (index 6)

                    if (i == 0) {
                        // Pe primul rând punem titlul coloanei
                        newCell.setCellValue("Medie Calculata Java");
                    } else {
                        // Pentru restul rândurilor, extragem valorile din coloanele D, E, F (index 3, 4, 5)
                        double val1 = (row.getCell(3) != null) ? row.getCell(3).getNumericCellValue() : 0;
                        double val2 = (row.getCell(4) != null) ? row.getCell(4).getNumericCellValue() : 0;
                        double val3 = (row.getCell(5) != null) ? row.getCell(5).getNumericCellValue() : 0;

                        // Calculăm media
                        double media = (val1 + val2 + val3) / 3.0;
                        newCell.setCellValue(media);
                    }
                }
            }

            // Salvăm modificările într-un nou fișier
            try (FileOutputStream outputStream = new FileOutputStream(outputPath)) {
                workbook.write(outputStream);
            }

        } catch (IOException e) {
            System.err.println("Eroare la generarea output2: " + e.getMessage());
        }
    }

    // --- Rezolvare 8.5.3 ---
    public static void genereazaFisierCuMedieFormula(String inputPath, String outputPath) {
        try (FileInputStream inputStream = new FileInputStream(new File(inputPath));
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell newCell = row.createCell(6); // Coloana G (index 6)

                    if (i == 0) {
                        newCell.setCellValue("Medie Formula Excel");
                    } else {
                        // În Excel, rândurile încep de la 1, deci rândul 'i' în Java este 'i + 1' în Excel
                        int excelRowNum = i + 1;

                        // Construim formula de tipul AVERAGE(D2:F2)
                        String formula = "AVERAGE(D" + excelRowNum + ":F" + excelRowNum + ")";
                        newCell.setCellFormula(formula);
                    }
                }
            }

            // Salvăm modificările în al treilea fișier
            try (FileOutputStream outputStream = new FileOutputStream(outputPath)) {
                workbook.write(outputStream);
            }

        } catch (IOException e) {
            System.err.println("Eroare la generarea output3: " + e.getMessage());
        }
    }
}