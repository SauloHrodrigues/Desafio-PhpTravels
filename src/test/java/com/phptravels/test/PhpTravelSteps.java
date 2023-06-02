package com.phptravels.test;
import static com.phptravels.kernel.AcessarSite.acessarSitePHPTravels;

import com.phptravels.test.pages.HomePhpTravelPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PhpTravelSteps {
	private HomePhpTravelPage home = new HomePhpTravelPage();
//	private String sc;
	
//	************ Futura implementação do excel
//	@Before
//	public void antes(Scenario sc) {
//		this.sc =sc.getSourceTagNames().stream().filter(t->t.startsWith("@#")).findFirst().get();
//		System.out.println("Rodado o cenario = "+this.sc);
//	}

	
	@Given("^Estar no site https://phptravels\\.com/demo/$")
	public void estar_no_site_https_phptravels_com_demo() throws Throwable {
//		System.out.println("Linha no banco = "+excel.buscarCodigo("#002"));
		acessarSitePHPTravels();
	}

	@Given("^preencher o campo First Name$")
	public void preencher_o_campo_First_Name() throws Throwable {
		
	    home.setFirstName("Saulo");
	    
	}

	@Given("^preencher o campo Last Name$")
	public void preencher_o_campo_Last_Name() throws Throwable {
	   home.setLastName("Rodrigues");
	}

	@Given("^preencher o campo Business Name$")
	public void preencher_o_campo_Business_Name() throws Throwable {
	   home.setBusinessName("Programador");
	}

	@Given("^preencher o campo e-mail$")
	public void preencher_o_campo_e_mail() throws Throwable {
	    home.setEmail("saulo.rodrigues@keeggo.com");
	}

	@When("^Digitar a soma apresentada$")
	public void digitar_a_soma_apresentada() throws Throwable {
		home.getResultadoSoma();
	}

	@When("^Clicar no botão Submit$")
	public void clicar_no_botão_Submit() throws Throwable {
	   home.setSubmit();
	}

	@Then("^Validar o Agradecimento$")
	public void validar_o_Agradecimento() throws Throwable {
		home.validarMensagemThankYou();
	}
}
