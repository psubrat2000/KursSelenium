package przyklad1;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PrestaShoppingTest {

    private WebDriver driver;
    double priceSum;

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }
    @Test
    public  void testPrestaShopping() {
        WebElement clothes = driver.findElement(By.cssSelector("li#category-3 a.dropdown-item"));
        clothes.click();

        List<WebElement> hummingbirds = driver.findElements(By.cssSelector("h2.h3.product-title"));
        hummingbirds.get(1).click();

        WebElement addToCart1 = driver.findElement(By.cssSelector("button.btn.btn-primary.add-to-cart"));
        if (addToCart1.isEnabled()) {
            WebElement price1 = driver.findElement(By.cssSelector("div.current-price span[itemprop=price]"));
            String price2 = price1.getText();
            price2 = price2.replaceAll("[^\\d.]+", "");
            double price3 = Double.parseDouble(price2);
            priceSum = price3;

            addToCart1.click();

            wait(1000);
            WebElement continueShopping1 = driver.findElement(By.cssSelector("div.cart-content div.cart-content-btn button.btn.btn-secondary"));
            continueShopping1.click();
        }

        driver.get("https://prod-kurs.coderslab.pl/index.php");

        WebElement art = driver.findElement(By.cssSelector("li#category-9 a.dropdown-item"));
        art.click();

        List<WebElement> arts = driver.findElements(By.cssSelector("h2.h3.product-title"));
        arts.get(0).click();

        WebElement addToCart2 = driver.findElement(By.cssSelector("button.btn.btn-primary.add-to-cart"));
        if (addToCart2.isEnabled()) {
            WebElement price1 = driver.findElement(By.cssSelector("div.current-price span[itemprop=price]"));
            String price2 = price1.getText();
            price2 = price2.replaceAll("[^\\d.]+", "");
            double price3 = Double.parseDouble(price2);
            priceSum = priceSum + price3;

            addToCart2.click();

            wait(1000);
            WebElement continueShopping2 = driver.findElement(By.cssSelector("div.cart-content div.cart-content-btn button.btn.btn-secondary"));
            continueShopping2.click();
        }

        driver.get("https://prod-kurs.coderslab.pl/index.php");

        WebElement cart = driver.findElement(By.cssSelector("i.material-icons.shopping-cart"));
        cart.click();

        WebElement total = driver.findElement(By.cssSelector("div.cart-summary-line.cart-total span.value"));
        String total1 = total.getText();
        total1 = total1.replaceAll("[^\\d.]+", "");
        double total2 = Double.parseDouble(total1);

        if (total2 == priceSum) {
            System.out.println("Sumy są zgodne");
        } else {
            System.out.println("Sumy nie są zgodne");
        }
    }
}