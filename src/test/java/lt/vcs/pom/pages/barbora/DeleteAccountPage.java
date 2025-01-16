package lt.vcs.pom.pages.barbora;

import lt.vcs.pom.pages.Common;
import org.openqa.selenium.By;

public class DeleteAccountPage {

    private static By dropDownListPaskyrosMenu = By.xpath("//div[@id='fti-header-customer-menu']");
    private static By buttonManoNustatymai = By.xpath("//li[@id='fti-customer-menu-customerDataUserSettings']");
    private static By buttonPasalinti = By.xpath("//button[@id='fti-user-settings-remove']");
    private static By buttonPatvirtinti = By.xpath("//button[@id='fti-modal-option-1']");
    private static By modalMessageDemesio = By.xpath("//div[@class='modal-body ']//p");

    public static void open(String url) {
        Common.openUrl(url, 5);
    }

    public static void clickManoNustatymai() {
        Common.moveToElementWithActions(dropDownListPaskyrosMenu);
        Common.clickOnElement(buttonManoNustatymai);
    }

    public static void clickPasalinti() {
        Common.scrollDownWithActions();
        Common.clickOnElement(buttonPasalinti);
    }

    public static void clickPatvirtinti() {
        Common.clickOnElement(buttonPatvirtinti);
    }

    public static String readModalMessageDemesio() {
        return Common.getTextFromElement(modalMessageDemesio);
    }
}