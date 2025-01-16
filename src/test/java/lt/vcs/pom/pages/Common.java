package lt.vcs.pom.pages;

import lt.vcs.pom.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Common {

    public static void openUrl(String url, int seconds) {      //static, kad nereiktu kurti objektu
        Driver.initChromeDriver();   // cia instancas
        Driver.getDriver().get(url);
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));  // lauks viso puslapio uzkrovimo
    }

    public static void openUrl(String url) {      //static, kad nereiktu kurti objektu
        Driver.initChromeDriver();   // cia instancas
        Driver.getDriver().get(url);
    }

    public static void quitDriver() {
        Driver.getDriver().quit();
    }

    private static WebElement getElement(By locator) {
        return Driver.getDriver().findElement(locator);
    }

    private static List<WebElement> getElements(By locator) {
        return Driver.getDriver().findElements(locator);
    }

    public static void sendKeysToElement(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    public static void clear(By locator) {
        getElement(locator).clear();
    }

    public static String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }

    public static void clickOnElement(By locator) {
        getElement(locator).click();
    }

    public static void waitElementLocated(By locator, int seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private static Actions getActions() {
        return new Actions(Driver.getDriver());
    }

    public static void scrollDownWithActions() {
        getActions().sendKeys(Keys.PAGE_DOWN).perform();
    }

    public static void moveToElementWithActions(By locator){
        getActions().moveToElement(getElement(locator)).perform();
    }

}
