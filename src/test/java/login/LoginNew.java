package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;


// Второй Тест которий ми используем для входа логин и пароль (типа коректний)
public class LoginNew extends ParentTest {

    @Test
    public void validLogin() {
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickButtonVhod();

        Assert.assertTrue("Avatar is not present", homePage.isAvatarDisplayed());

    }
}
