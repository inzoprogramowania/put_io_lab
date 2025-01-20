package put.selenium.linear;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import put.selenium.utils.ScreenshotAndQuitOnFailureRule;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class AccountsLinearScriptAT {

    private WebDriver driver;

    @Rule
    public ScreenshotAndQuitOnFailureRule screenshotOnFailureAndWebDriverQuitRule =
            new ScreenshotAndQuitOnFailureRule();


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        this.driver = new ChromeDriver();
        screenshotOnFailureAndWebDriverQuitRule.setWebDriver(driver);
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
    }

    @Test
    public void successfulUserRegistration() throws Exception {
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
        driver.get("http://localhost:8080/accounts/controller");
        assertEquals("Register", driver.findElement(By.linkText("Register")).getText());
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("test");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("qwerty123");
        driver.findElement(By.name("repeat_password")).clear();
        driver.findElement(By.name("repeat_password")).sendKeys("qwerty123");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("Adam");
        driver.findElement(By.name("addressData")).clear();
        driver.findElement(By.name("addressData")).sendKeys("Babiak ul. Zielona 1, 62-620 Babiak \n");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.xpath("//html")).click();
        // ERROR: Caught exception [unknown command
    }


}
