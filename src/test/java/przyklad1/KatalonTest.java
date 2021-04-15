package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class KatalonTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }
    @Test
    public void testKatalonSearch() {
        // ((ChromeDriver)driver).getCapabilities();
        WebElement firstName = driver.findElement(By.cssSelector("input#first-name"));
        firstName.clear();
        firstName.sendKeys("Karol");

        WebElement lastName = driver.findElement(By.cssSelector("input#last-name"));
        lastName.clear();
        lastName.sendKeys("Kowalski");

        List<WebElement> genders = driver.findElements(By.cssSelector("input[name=gender]"));
        genders.get(0).click();

        WebElement dob = driver.findElement(By.cssSelector("#dob"));
        dob.clear();
        dob.sendKeys("05/22/2010");

        WebElement address = driver.findElement(By.cssSelector("#address"));
        address.clear();
        address.sendKeys("Prosta 51");

        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.clear();
        email.sendKeys("karol.kowalski@mailinator.com");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.clear();
        password.sendKeys("Pass123");

        WebElement company = driver.findElement(By.cssSelector("#company"));
        company.clear();
        company.sendKeys("Coders Lab");

        List<WebElement> role = driver.findElements(By.cssSelector("select#role option"));
        Random random = new Random();
        int rand = random.nextInt(role.size());
        role.get(rand).click();

        List<WebElement> jobExpectation = driver.findElements(By.cssSelector("select#expectation option"));
        rand = random.nextInt(jobExpectation.size());
        jobExpectation.get(rand).click();

        List<WebElement> waysOfDevelopment = driver.findElements(By.xpath("//*[@id=\"infoForm\"]/div[11]/div//label"));
        rand = random.nextInt(waysOfDevelopment.size());
        waysOfDevelopment.get(rand).click();

        WebElement comment = driver.findElement(By.cssSelector("#comment"));
        comment.clear();
        comment.sendKeys("To jest mój pierwszy automat testowy");

        WebElement submit = driver.findElement(By.cssSelector("#submit"));
        submit.click();

        // Prześlij formularz
        //element.submit();

    }
    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        //driver.quit();
    }
}