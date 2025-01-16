package lt.vcs.pom.pages.barbora;

import lt.vcs.pom.pages.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.Arrays;
import java.util.List;

public class LoginPage  {

    private static final By buttonPrisijungti = By.xpath("//button[@id='fti-header-login']");
    private static final By inputElPastoAdresas = By.xpath("//input[@id='email']");
    private static final By inputSlaptazodis = By.xpath("//input[@id='password']");
    private static final By buttonPrisijungtiSuElPastu = By.xpath("//button[@id='fti-login-email']");
    private static final By paragraphTavoKrepselisTuscias = By.xpath("//span[@class='b-cart--empty-content--title']");
    private static final By paragraphErrorMessageEmail = By.xpath("//div[@class='b-form-group--error']");
    private static final By paragraphAlertMessage = By.xpath("//div[@class='b-alert b-alert--error']");
    private static final By paragraphErrorMessagePassword = By.xpath("//div[@class='b-form-group--error']");

    public static final List<By> errorLocators = Arrays.asList(
            By.xpath("//div[@class='b-form-group--error']"),
            By.xpath("//div[@class='b-alert b-alert--error']"),
            By.xpath("//div[@class='b-form-group--error']")
    );

    public static String getErrorMessageText() {
        for (By locator : errorLocators) {
            try {
                return Common.getTextFromElement(locator);
            } catch (NoSuchElementException e) {

            }
        }
        return "<No data>";
    }

    public static void open(String url) {
        Common.openUrl(url, 5);
    }

    public static void clickPrisijungti() {
        Common.clickOnElement(buttonPrisijungti);
    }

    public static void writeElPastoAdresas(String elPastoAdresas) {
        Common.sendKeysToElement(inputElPastoAdresas, elPastoAdresas);
    }

    public static void writeSlaptazodis(String slaptazodis) {
        Common.sendKeysToElement(inputSlaptazodis, slaptazodis);
    }

    public static void clickPrisijungtiSuElPastu() {
        Common.clickOnElement(buttonPrisijungtiSuElPastu);
    }

    public static String readTextinHomePage() {
        return Common.getTextFromElement(paragraphTavoKrepselisTuscias);
    }

    public static String readErrorMessagePassword() {
        return Common.getTextFromElement(paragraphErrorMessagePassword);
    }

    public static String readErrorMessageEmail() {
        return Common.getTextFromElement(paragraphErrorMessageEmail);
    }

    public static String readAlertMessage() {
        return Common.getTextFromElement(paragraphAlertMessage);
    }

    public static void login(String elPastoAdresas, String slaptazodis){
        Common.clickOnElement(buttonPrisijungti);
        Common.sendKeysToElement(inputElPastoAdresas, elPastoAdresas);
        Common.sendKeysToElement(inputSlaptazodis, slaptazodis);
        Common.clickOnElement(buttonPrisijungtiSuElPastu);
    }

}
