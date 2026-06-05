package utils;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

    @DataProvider(name = "loginCsvData")
    public static Object[][] loginCsvData() {
        return CsvUtils.readCsv("testdata/login-data.csv", true);
    }

    @DataProvider(name = "loginJsonData")
    public static Object[][] loginJsonData() {
        return JsonUtils.readJsonArray("testdata/login-data.json");
    }

    @DataProvider(name = "loginExcelData")
    public static Object[][] loginExcelData() {
        return ExcelUtils.readXlsx("testdata/login-data.xlsx", "Sheet1");
    }
}
