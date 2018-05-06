import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TestCases {

    static WebDriver driver;
    PageSelectors pageSelectors;

    @Test
    public void testCaseQuestion2() throws Exception {

        //Set the remote web driver and launch the browser
        System.setProperty("webdriver.gecko.driver","geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.weightwatchers.com/us/");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        pageSelectors = new PageSelectors(driver);

        //Validate titles from step 2 , 3 and 7
        Assert.assertEquals("Weight Loss Program, Recipes & Help | Weight Watchers",pageSelectors.validateTitle());
        Assert.assertEquals("Find A Meeting: Get Schedules & Times Near You | Weight Watchers",pageSelectors.clickFindMeeting());
        String expectedLocation = pageSelectors.searchByZipCode("10011");
        System.out.println(expectedLocation);
        Assert.assertEquals(expectedLocation,pageSelectors.validateLocation());
        pageSelectors.getHoursOfOperation(getCurrentDay());
        driver.close();

    }

    private String getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return new SimpleDateFormat("EEEE",Locale.ENGLISH).format(date.getTime());
    }
}
