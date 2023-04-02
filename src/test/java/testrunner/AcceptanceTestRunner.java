package testrunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"src/test/java/features/"},
            glue = {"steps"},
            plugin = {"pretty", "html:target/allure-results/allure.html",
                    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
    )
    public class AcceptanceTestRunner {

    }