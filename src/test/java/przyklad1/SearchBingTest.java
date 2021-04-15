package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SearchBingTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.bing.com");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver.manage().window().fullscreen();
    }

    @Test
    public void testBingSearch() {
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Olimpiada 2021");
        element.submit();
    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
