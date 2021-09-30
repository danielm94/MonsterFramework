package ui.data_providers.login_page;

import org.testng.annotations.DataProvider;
import shared_utilities.data_readers.ExcelReader;

import java.io.IOException;

public class LoginData {
    @DataProvider(name = "Login Info")
    public static Object[][] invalidLoginsExample() throws IOException {
        //TODO: THIS SHOULDN'T BE A MAGIC STRING
        ExcelReader.setExcelSheet("src//test//resources//testng_xmls//monster_login.xlsx", "Login");
        String[][] tableOfWrongLogins = ExcelReader.getTableWithinBounds("#BOUND");
        ExcelReader.close();
        return tableOfWrongLogins;
    }
}
