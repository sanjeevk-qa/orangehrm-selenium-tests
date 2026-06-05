package utils;

import com.opencsv.CSVReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static Object[][] readCsv(String resourcePath, boolean skipHeader) {
        try (CSVReader reader = new CSVReader(
                new InputStreamReader(ResourceUtils.getResourceAsStream(resourcePath), StandardCharsets.UTF_8))) {

            List<String[]> rows = reader.readAll();
            List<Object[]> data = new ArrayList<>();

            int start = skipHeader ? 1 : 0;
            for (int i = start; i < rows.size(); i++) {
                String[] r = rows.get(i);
                // CSV columns: testName, username, password, expectedResult
                data.add(new Object[]{ r[0], r[1], r[2], r[3] });
            }
            return data.toArray(new Object[0][0]);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read CSV: " + resourcePath, e);
        }
    }
}
