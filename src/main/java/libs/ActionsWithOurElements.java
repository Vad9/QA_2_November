package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger =Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;

    }
    public void enterTextInToElement(WebElement element, String text){
        try {
            element.clear();              // тоже самое мы писали webDriver.findElement(By.id("password")).clear();
            element.sendKeys(text);   // тоже самое мы писали  webDriver.findElement(By.id("password")).sendKeys(passWord);
            logger.info(text + " was inputted into Input");

        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
        }

    }

    public void clickOnElement(WebElement element) {
                try {
            element.click(); // тоже самое мы писали webDriver.findElement(By.tagName("button")).click();
            logger.info("Element was clicked");

        } catch (Exception e) {
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }
    public boolean isElementDisplayed (WebElement element){
        try {
            return element.isDisplayed();       // тоже самое мы писали return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public void selectTextInDD(WebElement element, String text) {
        try{
            Select select = new Select(element);
            select.deselectByVisibleText(text);
            logger.info("Text was selected in DD");
        }catch (Exception e) {
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
    }
    }
}
