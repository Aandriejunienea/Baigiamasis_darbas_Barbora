package lt.vcs.pom.pages.barbora;

import lt.vcs.pom.pages.Common;
import org.openqa.selenium.By;

public class HeaderPage {
    private static By dropDownListPaskyrosMenu = By.xpath("//div[@id='fti-header-customer-menu']");
    private static By buttonManoNustatymai = By.xpath("//li[@id='fti-customer-menu-customerDataUserSettings']");

    public static void clickManoNustatymai() {
        Common.moveToElementWithActions(dropDownListPaskyrosMenu);
        Common.clickOnElement(buttonManoNustatymai);
    }
}
