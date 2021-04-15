package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class SearchProductTest {

    private static final String SHOP_URL = "https://prod-kurs.coderslab.pl/index.php";
    private static final String[] PRODUCTS = {"T-Shirt", "Sweater", "Mug", "Cushion", "Notebook", "Poster", "Vesctor Graphics"};
    private static final Random RAND = new Random(System.currentTimeMillis());
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(SHOP_URL);
    }

    @Test
    public void searchRandomProduct() {
        WebElement element = driver.findElement(By.name("s"));
        element.clear();
        element.sendKeys(PRODUCTS[RAND.nextInt(PRODUCTS.length)]);
        element.submit();
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }

}
