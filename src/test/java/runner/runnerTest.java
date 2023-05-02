package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Steps",
        tags = "@wip, @wip2, @regressao",
        plugin = {"html:target/cucumber.html"}
)

public class runnerTest {

}

