package lt.vcs.pom.pages.barbora;

import lt.vcs.pom.pages.Common;
import org.openqa.selenium.By;

public class RegistrationPage {

    private static final By buttonRegistruotis = By.xpath("//button[@id='fti-header-register']");
    private static final By buttonRegistruotisSuElPastu = By.xpath("//span[@class='b-login-form--email-txt']");
    private static final By inputVardasIrPavarde = By.xpath("//input[@id='fullname']");
    private static final By inputElPastoAdresas = By.xpath("//input[@id='email']");
    private static final By inputSlaptazodis = By.xpath("//input[@id='password']");
    private static final By inputTelefonoNumeris = By.xpath("//input[@id='phone']");
    private static final By buttonTesti = By.xpath("//button[@id='fti-wizard-next']");
    private static final By buttonGatveNamoNumeris = By.xpath("//button[@id='street_house']");
    private static final By inputGatveNamoNumeris = By.xpath("//input[@class='tw-flex-1 tw-border-none tw-py-2']");
    private static final By dropDownListVilneles3 = By.xpath("//div[text()='Vilnelės g. 3, 11346 Vilnius']");
    private static final By CheckboxSutikimas = By.xpath("(//div[contains(@class, 'b-input-checkbox-styled')])[3]");
    private static final By buttonSubmitRegistruotis = By.xpath("//button[@id='fti-wizard-submit']");
    private static final By paragraphTavoKrepselisTuscias = By.xpath("//span[@class='b-cart--empty-content--title']");
    private static final By paragraphErrorMessage = By.xpath("//div[@class='b-alert b-alert--error']");

    public static void open(String url) {
        Common.openUrl(url, 5);
    }

    public static void clickRegistruotis() {
        Common.clickOnElement(buttonRegistruotis);
    }

    public static void clickRegistruotisSuElPastu() {
        Common.clickOnElement(buttonRegistruotisSuElPastu);
    }

    public static void writeVardasIrPavarde(String vardasIrPavarde) {
        Common.sendKeysToElement(inputVardasIrPavarde, vardasIrPavarde);
    }

    public static void writeElPastoAdresas(String elPastoAdresas) {
        Common.sendKeysToElement(inputElPastoAdresas, elPastoAdresas);
    }

    public static void writeSlaptazodis(String slaptazodis) {
        Common.sendKeysToElement(inputSlaptazodis, slaptazodis);
    }

    public static void writeTelefonoNumeris(long telefonoNumeris) {
        Common.sendKeysToElement(inputTelefonoNumeris, String.valueOf(telefonoNumeris));
    }

    public static void clickTesti() {
        Common.clickOnElement(buttonTesti);
    }

    public static void clickGatveNamoNumeris() {
        Common.clickOnElement(buttonGatveNamoNumeris);
    }

    public static void writeGatveNamoNumeris(String gatveNamoNumeris) {
        Common.sendKeysToElement(inputGatveNamoNumeris, gatveNamoNumeris);
    }

    public static void clickVilneles3() {
        Common.clickOnElement(dropDownListVilneles3);
    }

    public static void clickSutikimas() {
        Common.clickOnElement(CheckboxSutikimas);
    }

    public static void clickRegistruotisSubmit() {
        Common.clickOnElement(buttonSubmitRegistruotis);
    }

    public static String readTextinHomePage() {
        return Common.getTextFromElement(paragraphTavoKrepselisTuscias);
    }

    public static String readErrorMessage() {
        return Common.getTextFromElement(paragraphErrorMessage);
    }
}
