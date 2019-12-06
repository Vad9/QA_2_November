package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {
    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDD;

    @FindBy(id = "delete")
    private WebElement buttonDelete;

    @FindBy(name = "add")
    private WebElement buttonCreate;


    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public boolean checkSpareNameInInput(String spareName){
        return spareNameInput.getText().equals(spareName);
    }
    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void enterSpareNameInToInput(String spareName) {
        actionsWithOurElements.enterTextInToElement(spareNameInput,spareName);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void selectSpareTypeInDD(String spareType) {
        actionsWithOurElements.selectTextInDD (spareTypeDD, spareType);
    }

}
