package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    public static Object[][] readJsonArray(String resourcePath) {
        try (InputStream is = ResourceUtils.getResourceAsStream(resourcePath)) {
            ObjectMapper mapper = new ObjectMapper();

            List<Map<String, Object>> list = mapper.readValue(is, new TypeReference<>() {});
            Object[][] data = new Object[list.size()][4];

            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> row = list.get(i);
                data[i][0] = String.valueOf(row.get("testName"));
                data[i][1] = String.valueOf(row.get("username"));
                data[i][2] = String.valueOf(row.get("password"));
                data[i][3] = String.valueOf(row.get("expectedResult"));
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON: " + resourcePath, e);
        }
    }
}
