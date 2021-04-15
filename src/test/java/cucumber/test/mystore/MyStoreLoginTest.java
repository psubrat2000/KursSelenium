package cucumber.test.mystore;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/Cucumber/Features/MyStore", plugin = {"pretty", "html:out.html"})

public class MyStoreLoginTest {
}
