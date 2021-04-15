package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("http://www.google.com");
    }
    @Test
    public void testGoogleSearch() {
        //((ChromeDriver)driver).getCapabilities();
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Testowanie Selenium WebDriver");
        element.submit();
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}