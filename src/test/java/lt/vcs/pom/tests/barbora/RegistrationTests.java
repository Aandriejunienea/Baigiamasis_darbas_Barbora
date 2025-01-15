package lt.vcs.pom.tests.barbora;

import lt.vcs.pom.pages.barbora.RegistrationPage;
import lt.vcs.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTests extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        RegistrationPage.open("https://barbora.lt/");
    }

    @Test
    public void testSuccessfulRegistration() {
        String vardasIrPavarde = "Akvile Pavarde";
        String elPastoAdresas = "demo@gmail.com";
        String slaptazodis = "Slaptazodis!123";
        long telefonoNumeris = 61234567;
        String gatveNamoNumeris = "Vilneles 3";

        String expectedResult = "Tavo krepšelis tuščias";
        String actualResult = "";

        RegistrationPage.clickRegistruotis();
        RegistrationPage.clickRegistruotisSuElPastu();
        RegistrationPage.writeVardasIrPavarde(vardasIrPavarde);
        RegistrationPage.writeElPastoAdresas(elPastoAdresas);
        RegistrationPage.writeSlaptazodis(slaptazodis);
        RegistrationPage.writeTelefonoNumeris(telefonoNumeris);
        RegistrationPage.clickTesti();
        RegistrationPage.clickGatveNamoNumeris();
        RegistrationPage.writeGatveNamoNumeris(gatveNamoNumeris);
        RegistrationPage.clickVilneles3();
        RegistrationPage.clickTesti();
        RegistrationPage.clickSutikimas();
        RegistrationPage.clickRegistruotis01();
        RegistrationPage.readTextinHomePage();

        actualResult = RegistrationPage.readTextinHomePage();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected:%s".formatted(actualResult, expectedResult)
        );
    }
}

