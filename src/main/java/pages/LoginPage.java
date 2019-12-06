package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    WebElement inputLogin;

    @FindBy(id = "password")
    WebElement inputPassWord;

    @FindBy(tagName = "button")
    WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");

        } catch (Exception e) {
            logger.info("Cannot open login Page");
            Assert.fail("Cannot open login Page");
        }
    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextInToElement(inputLogin, login);

//        try{
//            inputLogin.clear();             // тоже самое мы писали  webDriver.findElement(By.name("_username")).clear();
//            inputLogin.sendKeys(login);     // тоже самое мы писали  webDriver.findElement(By.name("_username")).sendKeys(login);
//            logger.info(login + "was inputted into Input");
//
//        }catch (Exception e){
//            logger.error("Cannot work with element");
//            Assert.fail("Cannot work with element");
//        }
    }

    public void enterPassword(String passWord) {
        actionsWithOurElements.enterTextInToElement(inputPassWord, passWord);
//        try {
//            inputPassWord.clear();              // тоже самое мы писали webDriver.findElement(By.id("password")).clear();
//            inputPassWord.sendKeys(passWord);   // тоже самое мы писали  webDriver.findElement(By.id("password")).sendKeys(passWord);
//            logger.info(passWord + "was inputted into Input");
//
//        } catch (Exception e) {
//            logger.error("Cannot work with element");
//            Assert.fail("Cannot work with element");
//        }
    }


    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
//        try {
//            buttonVhod.click(); // тоже самое мы писали webDriver.findElement(By.tagName("button")).click();
//            logger.info("Element was clicked");
//
//        } catch (Exception e) {
//            logger.error("Cannot work with element");
//            Assert.fail("Cannot work with element");
//        }
    }

    public boolean isButtonVhodDisplayed() {
        return actionsWithOurElements.isElementDisplayed(buttonVhod);
    }

    public void loginInToApp(String login, String passWord){
        openLoginPage();
        enterLogin(login);
        enterPassword(passWord);
        clickButtonVhod();
    }

    public void validLoginInToApp(){
        loginInToApp("Student", "909090");
        HomePage homePage = new HomePage(webDriver);
        homePage.isAvatarDisplayed();
    }
}

