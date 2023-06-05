package com.phptravels.test;
import static com.phptravels.kernel.AcessarSite.acessarSitePHPTravels;

import com.phptravels.kernel.ExcelUtils;
import com.phptravels.test.pages.HomePhpTravelPage;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PhpTravelSteps {
	private HomePhpTravelPage home = new HomePhpTravelPage();
	ExcelUtils excel = new ExcelUtils();
	
	private String sc;
	
//	************ Futura implementação do excel
	@Before
	public void antes(Scenario sc) {
		String aux= sc.getSourceTagNames().stream().filter(t->t.startsWith("@#")).findFirst().get();
		String[] aux01 = aux.split("@");
		this.sc = aux01[1];
		System.out.println("Rodado o cenario = "+this.sc);
		
	}

	
	
	@Given("^Estar no site https://phptravels\\.com/demo/$")
	public void estar_no_site_https_phptravels_com_demo() throws Throwable {
		acessarSitePHPTravels();
	
	}

	@Given("^preencher o campo First Name$")
	public void preencher_o_campo_First_Name() throws Throwable {
		
	    home.setFirstName(excel.getExcelFirstName(sc));
//	    home.setFirstName("Saulo");
	    
	}

	@Given("^preencher o campo Last Name$")
	public void preencher_o_campo_Last_Name() throws Throwable {
	   home.setLastName(excel.getExcelLastName(sc));
//	   home.setLastName("Rpdrigues");
	}

	@Given("^preencher o campo Business Name$")
	public void preencher_o_campo_Business_Name() throws Throwable {
	   home.setBusinessName(excel.getExcelBusinessName(sc));
//	   home.setBusinessName("programador");
	}

	@Given("^preencher o campo e-mail$")
	public void preencher_o_campo_e_mail() throws Throwable {
	    home.setEmail(excel.getExcelEmail(sc));
//	    home.setEmail("saulo@gmail.com");
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
