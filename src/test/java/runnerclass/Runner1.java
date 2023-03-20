package runnerclass;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
					glue = {"Scripts"}, monochrome = true, tags="@ebay",plugin = {"pretty", "html:target\\result"})
					
public class Runner1 {
}
