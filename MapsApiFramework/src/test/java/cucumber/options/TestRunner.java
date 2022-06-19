package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\resources\\Features\\addPlaceFeature.feature"},
					glue = {"stepDef"},
					monochrome = true,
					tags = "@Addplace",
					plugin = {"pretty","html:target/cucumber-reports.html"})
public class TestRunner {

}
