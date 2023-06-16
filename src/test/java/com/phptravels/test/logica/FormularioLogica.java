package com.phptravels.test.logica;

import static com.phptravels.kernel.DriverFactory.getDriver;

import org.junit.Assert;

import com.phptravels.kernel.Configuracoes;
import com.phptravels.test.model.FormularioModel;
import com.phptravels.test.pages.Page;

import cucumber.api.Scenario;


public class FormularioLogica {
	
	private Page home;
	private FormularioModel excel;

	public FormularioLogica(Scenario sc) {
		String aux = sc.getSourceTagNames().stream().filter(t -> t.startsWith("@#")).findFirst().get();
		String[] aux01 = aux.split("@");
		String codCenario = aux01[1];
		home = new Page();
		excel = new FormularioModel(codCenario);
	}
	
	public void acessarPHPTravels() {
		Configuracoes config = new Configuracoes();
		getDriver().get(config.getUrl());
		
	}
	
	
	public void escreverFirstName(String firtname) {
		home.escreverFirstName(firtname);
	}

	public void escreverFirstName() {	
		home.escreverFirstName(excel.getFirstName());
	}

	public void escreverLastName(String LastName) {
		home.escreverLastName(LastName);
	}

	public void escreverLastName() {
		home.escreverLastName(excel.getLastName());
	}

	public void escreverBusinessName(String BusinessName) {
		home.escreverBusinessName(BusinessName);
	}

	public void escreverBusinessName() {
		home.escreverBusinessName(excel.getBusinessName());
	}

	public void escreverEmail(String Email) {
		home.escreverEmail(Email);
	}

	public void escreverEmail() {
		home.escreverEmail(excel.geteMail());
	}

	public void escreverSoma() {
		home.escreverResultadoSoma();
	}

	public void submit() {
		home.clicarSubmit();
	}

	public void validarMensagemThankYou() {
		Assert.assertTrue(home.msgThankYou().isDisplayed());
	}

}
