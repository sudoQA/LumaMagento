
// Entire execution will start from here

package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = { ".//FeatureFiles/Login.feature" }, 
		glue = "stepDefinitions"  // We always specify only package name because steps are internally related

)
public class TestRun {

}
