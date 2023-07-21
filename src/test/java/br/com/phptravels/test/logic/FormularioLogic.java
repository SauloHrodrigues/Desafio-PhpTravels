package br.com.phptravels.test.logic;

import static br.com.phptravels.kernel.Contexto.getDriver;

import org.junit.Assert;

import br.com.phptravels.kernel.driver.InteracaoWeb;
import br.com.phptravels.kernel.readers.ConfiguracoesPropriedades;
import br.com.phptravels.test.model.FormularioModel;
import br.com.phptravels.test.pages.HomePage;


public class FormularioLogic {
	
	private HomePage homePage;
	private FormularioModel model;
	private InteracaoWeb interacaoWeb;

	public FormularioLogic() {
		interacaoWeb = new InteracaoWeb();
		model= new FormularioModel();
		homePage = new HomePage();
	}
	
	public void acessarPHPTravels() {
		ConfiguracoesPropriedades config = new ConfiguracoesPropriedades();
		getDriver().get(config.getUrl());
	}
	
	
	public void escreverFirstName(String firstName) {
		interacaoWeb.escrever(homePage.getTxtFirstName(), firstName);
	}

	public void escreverFirstName() {	
		escreverFirstName(model.getFirstName());
	}

	public void escreverLastName(String LastName) {
		interacaoWeb.escrever(homePage.getTxtLastName(), LastName);
	}

	public void escreverLastName() {
		escreverLastName(model.getLastName());
	}

	public void escreverBusinessName(String BusinessName) {
		interacaoWeb.escrever(homePage.getTxtBusinessName(), BusinessName);
	}

	public void escreverBusinessName() {
		escreverBusinessName(model.getBusinessName());
	}

	public void escreverEmail(String Email) {
		interacaoWeb.escrever(homePage.getTxtEmail(), Email);
	}

	public void escreverEmail() {
		escreverEmail(model.geteMail());
	}

	public void escreverSoma() {
		Integer numero01 = Integer.parseInt( homePage.getLblPrimeiroNumero().getText());
		Integer numero02 = Integer.parseInt( homePage.getLblSegundoNumero().getText());
		interacaoWeb.escrever(homePage.getTxtLastName(), numero01+numero02);
	}

	public void submit() {
		interacaoWeb.clicar(homePage.getBtnSubmit());
	}

	public void validarMensagemThankYou() {
		//TODO
		Assert.assertTrue(homePage.getMsgTankYou().isDisplayed());
	}

}
