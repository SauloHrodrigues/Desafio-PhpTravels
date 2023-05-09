package phpTravel.runner;

import static phpTravel.utils.DriverFactory.killDriver;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import phpTravel.utils.DriverFactory;

@CucumberOptions(features = "src/test/resources/feature/phptravel.feature", 
		glue = "phpTravel.steps",
//		tags = "~@Validado",//executa apenas os cenarios com essa tags 
		monochrome = false, snippets = SnippetType.CAMELCASE, 
		dryRun = false, 
		strict = true)
@RunWith(Cucumber.class)
public class PhpTravelRunner {

//	@AfterClass
//	public void finalizaDriver() {
//		killDriver();
//	}
}
