package spares;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;



// Третій Тест создаем деталь и ...
public class AddNewSpare extends ParentTest {
    String spareName = "wad9spare";

    @Test
    public void addNewSpare (){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
        sparePage.deletingSpareUntilPresent(spareName);   // удаление всех одинкових запчастей
        //sparePage.checkAndDeleteSpare(spareName);   // удаление 1 запчасти
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механикa");
        editSparePage.clickOnButtonCreate();

        checkExpectedResult("Spare was not added to list", sparePage.isSpareInList(spareName));

    }

    @After
    public void spareDeleting(){
        sparePage.deletingSpareUntilPresent(spareName);
    }


}
