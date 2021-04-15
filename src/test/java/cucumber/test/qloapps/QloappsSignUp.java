package cucumber.test.qloapps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QloappsSignUp {

    WebDriver driver;

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Given("an open browser with {string}")
    public void openQloapps(String url) {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do URL
        driver.get(url);
    }

    @And("click {string}")
    public void clickSignIn(String objectToClick) {
        WebElement signIn = driver.findElement(By.cssSelector(objectToClick));
        signIn.click();
    }

    @And("an email {string} is entered in input field")
    public void enterEmail(String email) {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement emailAddress = driver.findElement(By.cssSelector("input#email_create"));
        // Wyczyść tekst zapisany w elemencie
        emailAddress.clear();
        // Wpisz informacje do wyszukania
        emailAddress.sendKeys(email);
        // Prześlij formularz
        WebElement createAccount = driver.findElement(By.cssSelector("button#SubmitCreate"));
        createAccount.click();
    }

    @When("details are entered")
    public void enterDetails() {
        wait(700);
        WebElement firstName = driver.findElement(By.cssSelector("input#customer_firstname"));
        firstName.sendKeys("Delilah");
        WebElement lastName = driver.findElement(By.cssSelector("input#customer_lastname"));
        lastName.sendKeys("Jones");
        WebElement password = driver.findElement(By.cssSelector("input#passwd"));
        password.sendKeys("password");
    }

    @And("register is clicked")
    public void clickRegister() {
        WebElement register = driver.findElement(By.cssSelector("button#submitAccount"));
        register.click();
    }

    @Then("the account is created")
    public void theAccountIsCreated() {
        WebElement accountCreated = driver.findElement(By.cssSelector("p.alert.alert-success"));
        accountCreated.isDisplayed();
    }

    @And("close browser")
    public void closeBrowser(){
        driver.quit();
    }
}