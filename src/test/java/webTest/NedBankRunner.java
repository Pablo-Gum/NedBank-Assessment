package webTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(value= Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/NedbankAssessment.feature",
        glue = {"stepDefinitions"}
)
public class NedBankRunner {

}
