package phpTravel.steps;

import static phpTravel.utils.AcessarSite.acessarSite;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import phpTravel.page.HomePhpTravelPage;
import phpTravel.utils.DriverFactory;

public class PhpTravelSteps {
	HomePhpTravelPage home = new HomePhpTravelPage();
	@Given("^Estar no site https://phptravels\\.com/demo/$")
	public void estar_no_site_https_phptravels_com_demo() throws Throwable {
	    acessarSite("https://phptravels.com/demo/");
	}

	@Given("^preencher o campo First Name$")
	public void preencher_o_campo_First_Name() throws Throwable {
	    home.escreverFirstName("Saulo");
	}

	@Given("^preencher o campo Last Name$")
	public void preencher_o_campo_Last_Name() throws Throwable {
	   home.escreverLastName("Rodrigues");
	}

	@Given("^preencher o campo Business Name$")
	public void preencher_o_campo_Business_Name() throws Throwable {
	   home.escreverBusinessName("keggoo");
	}

	@Given("^preencher o campo e-mail$")
	public void preencher_o_campo_e_mail() throws Throwable {
	    home.escreverEmail("saulohRodrigues@gmail.com");
	}

	@When("^Digitar a soma apresentada$")
	public void digitar_a_soma_apresentada() throws Throwable {
	    String soma = ""+home.getSoma();
		home.escreverResultado(soma);
	}

	@When("^Clicar no botão Submit$")
	public void clicar_no_botão_Submit() throws Throwable {
	   home.clicarSubmit();
	}

	@Then("^Validar o Agradecimento$")
	public void validar_o_Agradecimento() throws Throwable {
			Assert.assertTrue("Não validou os agradecimentos!",home.validaMensagem());
	}
}
