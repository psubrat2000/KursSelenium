package przyklad1;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class Scratchpad {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://pl.wikipedia.org/");
    }
    @Test
    public void wikipedia() {
        WebElement element = driver.findElement(By.id("main-page-column1"));
        System.out.println(element.getText());
    }
}
