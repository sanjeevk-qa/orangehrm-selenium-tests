package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    private static final DataFormatter formatter = new DataFormatter();

    public static Object[][] readXlsx(String resourcePath, String sheetName) {
        try (InputStream is = ResourceUtils.getResourceAsStream(resourcePath);
             Workbook wb = new XSSFWorkbook(is)) {

            Sheet sheet = wb.getSheet(sheetName);
            if (sheet == null)
                throw new IllegalArgumentException("Sheet not found: " + sheetName);

            List<Object[]> data = new ArrayList<>();
            int rows = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rows; i++) { // skip header row
                Row row = sheet.getRow(i);
                if (row == null) continue;

                String testName = getCellAsString(row.getCell(0));
                String username = getCellAsString(row.getCell(1));
                String password = getCellAsString(row.getCell(2));
                String expected = getCellAsString(row.getCell(3));

                data.add(new Object[]{testName, username, password, expected});
            }

            return data.toArray(new Object[0][0]);

        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel: " + resourcePath, e);
        }
    }

    private static String getCellAsString(Cell cell) {
        if (cell == null) return "";
        return formatter.formatCellValue(cell);
    }
}
