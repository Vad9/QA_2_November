package login;

import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;


// четвертий Тест которий ми используем для входа логин и пароль c даними с Excel
public class LoginNewWithDataFromExcel extends ParentTest {

    @Test
    public void validLogin() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");
        loginPage.openLoginPage();
        //loginPage.enterLogin("Student");      значение логина ми задаем
        loginPage.enterLogin(dataForValidLogin.get("login").toString());  // значение логина с файла Excel
        //loginPage.enterPassword("909090");    значение пароля ми задаем
        loginPage.enterPassword(dataForValidLogin.get("pass").toString());  // значение пароля с файла Excel
        loginPage.clickButtonVhod();

        Assert.assertTrue("Avatar is not present", homePage.isAvatarDisplayed());

    }
}
