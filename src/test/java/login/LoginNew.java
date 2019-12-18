package login;

import libs.UtilsForDB;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;


// Второй Тест которий ми используем для входа логин и пароль (типа коректний)
public class LoginNew extends ParentTest {

    @Test
    public void validLogin() {
        //UtilsForDB utilsForDB = new UtilsForDB();  for SQL
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");   //loginPage.enterPassword(utilsForDB.getPassForLogin"Student");
        loginPage.clickButtonVhod();

//        Assert.assertTrue("Avatar is not present", homePage.isAvatarDisplayed());
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }

    @Test
    public void unValidLogin(){
        loginPage.loginInToApp("Student","909090");

        checkExpectedResult("Avatar should not be present"
                , homePage.isAvatarDisplayed()
                , false);

    }
}
