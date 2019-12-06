package spares;

import org.junit.Test;
import parentTest.ParentTest;



// Второй Тест создаем деталь и ...
public class AddNewSpare extends ParentTest {
    String spareName = "Vad9_spare";

    @Test
    public void addNewSpare (){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
        sparePage.checkAndDeleteSpare(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика");
        editSparePage.clickOnButtonCreate();
    }

}
