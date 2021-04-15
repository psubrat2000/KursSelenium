package przyklad1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class PrestaAccounts {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @Test
    public void testPresta() {
        // ((ChromeDriver)driver).getCapabilities();
        int testCases = 1;

        int rand1;
        int rand2 = 0;
        int rand3;

        for (int j = 0; j < testCases; j++) {
            WebElement signIn = driver.findElement(By.cssSelector("#_desktop_user_info a"));
            if (signIn.isEnabled()) {
                signIn.click();
            } else {
                Assert.fail();
            }

            WebElement noAccount = driver.findElement(By.cssSelector(".no-account a"));
            if (noAccount.isEnabled()) {
                noAccount.click();
            } else {
                Assert.fail();
            }

            List<WebElement> genders = driver.findElements(By.cssSelector(".col-md-6.form-control-valign .custom-radio"));
            Random random = new Random();
            int rand = random.nextInt(genders.size());
            genders.get(rand).click();

            WebElement firstName = driver.findElement(By.cssSelector("input[name=firstname]"));
            System.out.println(firstName.getAttribute("name"));
            if (firstName.isEnabled()) {
                String[] fname = {"Alice", "Monica", "Chandler", "Ross", "Phoebe", "Rachel", "Joseph", "Mercurio", "Hamlet", "Erica", "Genevieve", "Francis", "Jake", "Michael", "DeShawn", "LeBron", "Dwyane", "Arthur", "Stan", "Florence", "Tom", "Jerry", "Mickey", "Sean", "Dan", "Edward", "Don", "Henry"};
                rand = random.nextInt(fname.length);
                firstName.sendKeys(fname[rand]);
            } else {
                Assert.fail("firstname is not enabled");
            }

            WebElement lastName = driver.findElement(By.cssSelector("input[name=lastname]"));
            System.out.println(lastName.getAttribute("name"));
            if (lastName.isEnabled()) {
                String[] lname = {"Markowski", "Geller", "Bing", "Buffay", "Green", "Tribbiani", "Schwimmer", "Perry", "LeBlanc", "Aniston", "Cox", "Kudrow", "King", "James", "Tartakovsky", "Helder", "Smith", "Houston"};
                rand = random.nextInt(lname.length);
                lastName.sendKeys(lname[rand]);
            } else {
                Assert.fail("lastname is not enabled");
            }

            WebElement email = driver.findElement(By.cssSelector("input[name=email]"));
            System.out.println(email.getAttribute("name"));
            if (email.isEnabled()) {
                email.sendKeys("hamlet@gmail.com");
            } else {
                Assert.fail("email is not enabled");
            }

            WebElement password = driver.findElement(By.cssSelector("input[name=password]"));
            System.out.println(password.getAttribute("name"));
            if (password.isEnabled()) {
                password.sendKeys("crownprince");
            } else {
                Assert.fail();
            }

            WebElement birthday = driver.findElement(By.cssSelector("input[name=birthday]"));
            System.out.println(birthday.getAttribute("name"));
            if (birthday.isEnabled()) {
                rand1 = random.nextInt(11) + 1;
                switch (rand1) {
                    case 1:
                        rand2 = random.nextInt(30 + 1);
                    case 2:
                        rand2 = random.nextInt(27 + 1);
                    case 3:
                        rand2 = random.nextInt(30 + 1);
                    case 5:
                        rand2 = random.nextInt(30 + 1);
                    case 7:
                        rand2 = random.nextInt(30 + 1);
                    case 8:
                        rand2 = random.nextInt(30 + 1);
                    case 10:
                        rand2 = random.nextInt(30 + 1);
                    case 12:
                        rand2 = random.nextInt(30 + 1);
                    case 4:
                        rand2 = random.nextInt(29 + 1);
                    case 6:
                        rand2 = random.nextInt(29 + 1);
                    case 9:
                        rand2 = random.nextInt(29 + 1);
                    case 11:
                        rand2 = random.nextInt(29 + 1);
                }
                rand3 = random.nextInt(120) + 1900;
                birthday.sendKeys(rand1 + "/" + rand2 + "/" + rand3);
            } else {
                Assert.fail();
            }

            WebElement save = driver.findElement(By.cssSelector("button.btn.btn-primary.form-control-submit.float-xs-right"));
            if (save.isEnabled()) {
                save.click();
            } else {
                Assert.fail();
            }

            WebElement signOut = driver.findElement(By.cssSelector("a.logout.hidden-sm-down"));
            if (signOut.isEnabled()) {
                signOut.click();
            } else {
                Assert.fail();
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        //driver.quit();
    }
}
