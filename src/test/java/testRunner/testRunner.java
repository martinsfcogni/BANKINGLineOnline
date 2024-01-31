package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"steps"},
        plugin = {"pretty", "html:Report1"},
        dryRun = false,
        //strict = true,
        monochrome = true,
        tags = "@transfers"
        //name = {"Logo"}
)

public class testRunner {

}
