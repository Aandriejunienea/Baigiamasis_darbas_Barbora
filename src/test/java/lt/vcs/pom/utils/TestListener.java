package lt.vcs.pom.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        takeScreenshot(result.getName());
    }

    private void takeScreenshot(String testName) {

        if (Driver.getDriver() == null)
            return;

        TakesScreenshot screenshot = (TakesScreenshot) Driver.getDriver();

        File fileSrc = screenshot.getScreenshotAs(OutputType.FILE);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd__HH_mm_ss_SSS");
        String date = LocalDateTime.now().format(formatter);

        File fileDestination = new File("screenshot/%s_screenshot_%s.png".formatted(date, testName)); // kitas failas, i kuri kopijuosim ir saugosim cia

        try {
            FileUtils.copyFile(fileSrc, fileDestination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
