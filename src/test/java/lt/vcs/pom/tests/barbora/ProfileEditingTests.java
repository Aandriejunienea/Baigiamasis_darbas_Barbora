package lt.vcs.pom.tests.barbora;

import lt.vcs.pom.pages.barbora.DeleteAccountPage;
import lt.vcs.pom.pages.barbora.LoginPage;
import lt.vcs.pom.pages.barbora.ProfileEditingPage;
import lt.vcs.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileEditingTests extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        ProfileEditingPage.open("https://barbora.lt/");
    }

    @Test
    public void testProfileDataEditing() {
        String elPastoAdresas = "demo@gmail.com";
        String slaptazodis = "Slaptazodis!123";
        String pavarde = "Andriejuniene";

        String expectedResult = "Jūsų vartotojo duomenys yra sėkmingai pašalinti";
        String actualResult = "";

        LoginPage.login(elPastoAdresas, slaptazodis);
        DeleteAccountPage.clickManoNustatymai();
        ProfileEditingPage.clickPavarde();
        ProfileEditingPage.writeNewPavarde(pavarde);
        ProfileEditingPage.clickSaugoti();
        ProfileEditingPage.clickPatvirtinti();
        ProfileEditingPage.clickUzdaryti();

        actualResult = ProfileEditingPage.readPavardeNew();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected:%s".formatted(actualResult, expectedResult)
        );
    }


}
