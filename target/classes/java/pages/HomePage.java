package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{
    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(id ="spares" )
    private WebElement subMenuSpare;


    public HomePage(WebDriver webDriver) {
        super(webDriver,"/");
    }


    public boolean isAvatarDisplayed() {
//        try {
//            return avatar.isDisplayed();       // тоже самое мы писали return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();
//
//            } catch (Exception e) {
//                return false;
//            }
        return actionsWithOurElements.isElementDisplayed(avatar);
    }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        actionsWithOurElements.clickOnElement(subMenuSpare);
    }
}