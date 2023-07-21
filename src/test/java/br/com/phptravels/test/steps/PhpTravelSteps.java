package br.com.phptravels.test.steps;


import br.com.phptravels.test.logic.FormularioLogic;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PhpTravelSteps {
	private FormularioLogic form= new FormularioLogic(); 	

	@Given("^Estar no site https://phptravels\\.com/demo/$")
	public void estar_no_site_https_phptravels_com_demo() throws Throwable {
		form.acessarPHPTravels();
	}

	@Given("^preencher o campo First Name$")
	public void preencher_o_campo_First_Name() throws Throwable {
		form.escreverFirstName();	    
	}

	@Given("^preencher o campo Last Name$")
	public void preencher_o_campo_Last_Name() throws Throwable {
//	   form.escreverLastName("Rodrigues");
	   form.escreverLastName();
	}

	@Given("^preencher o campo Business Name$")
	public void preencher_o_campo_Business_Name() throws Throwable {
//		form.escreverBusinessName("digitador");
		form.escreverBusinessName();
	}

	@Given("^preencher o campo e-mail$")
	public void preencher_o_campo_e_mail() throws Throwable {
//	    form.escreverEmail("saulo@gmail.com");
	    form.escreverEmail();
	}

	@When("^Digitar a soma apresentada$")
	public void digitar_a_soma_apresentada() throws Throwable {
		form.escreverSoma();
	}

	@When("^Clicar no botão Submit$")
	public void clicar_no_botão_Submit() throws Throwable {
		form.submit();
	}

	@Then("^Validar o Agradecimento$")
	public void validar_o_Agradecimento() throws Throwable {
		form.validarMensagemThankYou();
	}
}
