import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCases {

    static WebDriver driver;

    @Test
    public void testCaseQuestion2() throws Exception {

        System.setProperty("webdriver.gecko.driver","geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get("https://www.weightwatchers.com/us/");

    }
}
