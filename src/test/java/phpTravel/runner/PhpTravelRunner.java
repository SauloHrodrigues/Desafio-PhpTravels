package phpTravel.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features = "src/test/resources/feature/phptravel.feature", 
		glue = {"phpTravel.steps", "phpTravel.utils"},
//		tags = "~@Validado",//executa apenas os cenarios com essa tags 
		monochrome = false, snippets = SnippetType.CAMELCASE, 
		dryRun = false, 
		strict = true)
@RunWith(Cucumber.class)
public class PhpTravelRunner {

	
}
