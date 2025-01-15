package lt.vcs.pom.tests.barbora;

import lt.vcs.pom.pages.barbora.LoginPage;
import lt.vcs.pom.pages.barbora.RegistrationPage;
import lt.vcs.pom.tests.TestBase;
import lt.vcs.pom.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        Driver.initChromeDriver();
        WebDriver driver = Driver.getDriver();
        RegistrationPage.open("https://barbora.lt/");
    }

    @Test
    public void testSuccessfulLogin() {
        String elPastoAdresas = "demo@gmail.com";
        String slaptazodis = "Slaptazodis!123";

        String expectedResult = "Tavo krepšelis tuščias";
        String actualResult = "";

        LoginPage.clickPrisijungti();
        LoginPage.writeElPastoAdresas(elPastoAdresas);
        LoginPage.writeSlaptazodis(slaptazodis);
        LoginPage.clickPrisijungtiSuElPastu();
        LoginPage.readTextinHomePage();

        actualResult = LoginPage.readTextinHomePage();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected:%s".formatted(actualResult, expectedResult)
        );
    }

    @DataProvider(name = "dataProviderForNegativeLogin")
    public Object[][] provideDataForNegativeLogin() {
        return new Object[][]{
                {"demogmail.com", "Slaptazodis!123", "Įvesk el. pašto adresą"},
                {"demo@gmail", "Slaptazodis!123", "Įvesk el. pašto adresą"},
                {"@gmail.com", "Slaptazodis!123", "Įvesk el. pašto adresą"},
                {"demogmail", "Slaptazodis!123", "Įvesk el. pašto adresą"},
                {"", "Slaptazodis!123", "Įvesk el. pašto adresą"},
                {"", "", "Įvesk el. pašto adresą"},
                {"demogmail.com", "Slaptazodis", "Įvesk el. pašto adresą"},
                {"demo@gmail.com", "", "Įvesk slaptažodį"},
                {"demo@gmail.com", "Slaptazodis", "Neteisingas el. pašto adresas arba slaptažodis"},
                {"demo@gmail.com", "  Slaptazodis!123", "Neteisingas el. pašto adresas arba slaptažodis"},
        };
    }

    @Test(dataProvider = "dataProviderForNegativeLogin")
    public void testUnsuccessfulLogin(String elPastoAdresas, String slaptazodis, String expectedResult) {
        String actualResult = "";

        LoginPage.clickPrisijungti();
        LoginPage.writeElPastoAdresas(elPastoAdresas);
        LoginPage.writeSlaptazodis(slaptazodis);
        LoginPage.clickPrisijungtiSuElPastu();

        actualResult = LoginPage.getErrorMessageText();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected:%s".formatted(actualResult, expectedResult)
        );
    }

}

