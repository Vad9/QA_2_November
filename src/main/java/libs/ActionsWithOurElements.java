package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait5, wait10;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait5 = new WebDriverWait(webDriver, 5);
        wait10 = new WebDriverWait(webDriver, 10);
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
            // wait5.until(ExpectedConditions.elementToBeClickable(element));    // дождись пока єлемент кликабельний ну не працює
            // wait5.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));    // дождись пока єлемент станет не кликабельний
            element.click(); // тоже самое мы писали webDriver.findElement(By.tagName("button")).click();
            logger.info("Element was clicked");

        } catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
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
            select.selectByVisibleText(text);
            logger.info("Text was selected in DD");
        }catch (Exception e) {
            logger.error("Cannot work with element" + e);
            Assert.fail("Cannot work with element" + e);
    }
    }

    public boolean isElementDisplayed(By byxxxpath) {
        try {
            return isElementDisplayed(webDriver.findElement(byxxxpath));
        } catch (Exception e){
            return false;
        }
    }

    /**
     * Set needed state
     * @param element
     * @param state  (only !!! check or uncheck)
     */
    public void setNeededStateToCheckBox(WebElement element, String state){
        boolean checkState = state.toLowerCase().equals("check");
        boolean unCheckState = state.toLowerCase().equals("uncheck");
        if (checkState || unCheckState){
            if (element.isSelected() && checkState){                //елемент вибран и должен остатся вибран
                logger.info("Checkbox is already checked");
            }else if (element.isSelected() && unCheckState){        //елемент вибран и должен стать не вибран
                clickOnElement(element);
            }else if (!element.isSelected() && checkState){         //елемент не вибран а должен стать вибран
                clickOnElement(element);
            }  else if (!element.isSelected() && unCheckState){        //елемент не вибран а должен остатся не вибран
                logger.info("Checkbox is already unchecked");
            }
        }else {
            logger.error("State should be check ot uncheck");
            Assert.fail("State should be check ot uncheck");
        }
    }
}
