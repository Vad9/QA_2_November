package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class editSparePage extends ParentPage {
    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDD;

    @FindBy(id = "delete")
    private WebElement buttonDelete;

    public editSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public boolean checkSpareNameInInput(String spareName){
        return spareNameInput.getText().equals(spareName);
    }
    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
