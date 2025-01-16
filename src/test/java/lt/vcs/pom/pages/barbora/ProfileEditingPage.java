package lt.vcs.pom.pages.barbora;

import lt.vcs.pom.pages.Common;
import org.openqa.selenium.By;

public class ProfileEditingPage {

    private static By inputPavarde = By.xpath("//div[@class='content-block--item b-input-field--root']//input");
    private static final By buttonSaugoti = By.xpath("//button[@id='fti-user-settings-save']");
    private static final By buttonPatvirtinti = By.xpath("//button[@id='fti-modal-option-1']");
    private static final By buttonUzdaryti = By.xpath("//button[@class='c-btn c-btn--gray c-btn--block c-btn--center']");

    public static void open(String url) {
        Common.openUrl(url, 5);
    }

    public static void clickPavarde() {
        Common.clickOnElement(inputPavarde);
    }


    public static void sendKeysWithAction(String pavarde) {
        Common.clearAndSendKeysWithActions(inputPavarde, pavarde);
    }

    public static void clickSaugoti() {
        Common.scrollDownWithActions();
        Common.clickOnElementWithActions(buttonSaugoti);
    }

    public static void clickPatvirtinti() {
        Common.clickOnElement(buttonPatvirtinti);
    }

    public static void clickUzdaryti() {
        Common.clickOnElement(buttonUzdaryti);
    }

    public static String readPavardeNew() {
        return Common.getElementAttributeValue(inputPavarde, "value");
    }

}
