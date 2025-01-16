package lt.vcs.pom.tests.barbora;

import lt.vcs.pom.pages.barbora.DeleteAccountPage;
import lt.vcs.pom.pages.barbora.LoginPage;
import lt.vcs.pom.pages.barbora.RegistrationPage;
import lt.vcs.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteAccountTests extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        RegistrationPage.open("https://barbora.lt/");
    }

    @Test
    public void testAccountDeletion() {
        String elPastoAdresas = "demo@gmail.com";
        String slaptazodis = "Slaptazodis!123";

        String expectedResult = "Jūsų vartotojo duomenys yra sėkmingai pašalinti";
        String actualResult = "";

        LoginPage.login(elPastoAdresas, slaptazodis);
        DeleteAccountPage.clickManoNustatymai();
        DeleteAccountPage.clickPasalinti();
        DeleteAccountPage.clickPatvirtinti();

        actualResult = DeleteAccountPage.readModalMessageDemesio();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected:%s".formatted(actualResult, expectedResult)
        );
    }
}
