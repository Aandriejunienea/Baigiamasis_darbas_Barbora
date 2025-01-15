package lt.vcs.pom.pages.barbora;

import lt.vcs.pom.pages.Common;
import lt.vcs.pom.tests.TestBase;
import lt.vcs.pom.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import java.util.Arrays;
import java.util.List;

public class LoginPage extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
    }

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
        WebDriver driver = Driver.getDriver();  // Naudojame WebDriver gauti
        for (By locator : errorLocators) {
            List<WebElement> elements = driver.findElements(locator);
            if (!elements.isEmpty()) {
                return elements.get(0).getText();  // Grąžina pirmą klaidos tekstą
            }
        }
        return "";  // Jei nieko nerasta, grąžina tuščią tekstą
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

}
