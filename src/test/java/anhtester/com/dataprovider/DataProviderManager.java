package anhtester.com.dataprovider;

import anhtester.com.helpers.ExcelHelpers;
import anhtester.com.helpers.SystemHelpers;
import org.testng.annotations.DataProvider;

public class DataProviderManager {

    @DataProvider(name = "data_provider_login", parallel = true)
    public Object[][] dataLoginHRM() {
        return new Object[][]{{"admin_example", "123456"}, {"project_manager", "123456"}};
    }

    @DataProvider(name = "data_provider_login_from_excel", parallel = true)
    public Object[][] dataLoginHRMFromExcel() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelData(SystemHelpers.getCurrentDir() + "datatest/Login.xlsx", "Sheet1");

        return data;
    }

    @DataProvider(name = "data_provider_login_from_excel_by_row", parallel = true)
    public Object[][] dataLoginHRMFromExcelByRow() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelDataHashTable(SystemHelpers.getCurrentDir() + "datatest/Login.xlsx", "Sheet1", 1, 2);

        return data;
    }

}
