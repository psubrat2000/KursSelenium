package przyklad1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PrestaFilterTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @Test
    public void testPrestaFilter() {
        WebElement accessories = driver.findElement(By.cssSelector("li#category-6"));
        accessories.click();

        WebElement priceRange = driver.findElement(By.xpath("/html/body/main/section/div/div[1]/div[2]/div[2]/section[5]/ul/li[1]/label/span"));
        priceRange.click();

        List<WebElement> prices = driver.findElements(By.cssSelector("div#js-product-list div.products.row span.price"));
        String price = prices.get(0).getText();
        price = price.replaceAll("[^\\d.]+", "");
        double price1 = Double.parseDouble(price);
        Double[] prices1 = {price1};

        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i).isEnabled()) {
                price = prices.get(i).getText();
                price = price.replaceAll("[^\\d.]+", "");
                price1 = Double.parseDouble(price);
                prices1 = Arrays.copyOf(prices1, prices1.length + 1);
                prices1[i] = price1;
            }
        }

        for (int i = 0; i < prices.size(); i++) {
            if (prices1[i] >= 11.00 && prices1[i] <= 14.00) {
            } else System.out.println("Price out of range");
        }

    }

}
