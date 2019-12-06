package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SparePage extends ParentPage {

    @FindBy (xpath = "//table//tr")
    List<WebElement> listOfRows;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void checkAndDeleteSpare(String spareName) {
        for (WebElement line:listOfRows){
            WebElement cellWithSpare = line.findElement(By.xpath("//td[1]"));
            if (cellWithSpare.getText().trim().equals(spareName)) {
                actionsWithOurElements.clickOnElement(cellWithSpare);
                logger.info("Yes!!!");
            }
        }
    }
}
