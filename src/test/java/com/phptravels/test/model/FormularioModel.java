package com.phptravels.test.model;

import static com.phptravels.kernel.DriverFactory.getDriver;

import java.util.List;

import com.phptravels.kernel.Configuracoes;
import com.phptravels.kernel.ExcelUtils;
import com.phptravels.test.pages.Page;

import cucumber.api.Scenario;

public class FormularioModel {
	private final int CODIGO = 0;
	private final int FIRST_NAME = 1;
	private final int LAST_NAME = 2;
	private final int BUSINESS_NAME= 3;
	private final int E_MAIL = 4; 
	private String sc;
	private Page home;
	private ExcelUtils excel;
	private List<String> registro;
	
	public FormularioModel(Scenario sc) {
		String aux = sc.getSourceTagNames().stream().filter(t -> t.startsWith("@#")).findFirst().get();
		String[] aux01 = aux.split("@");
		this.sc = aux01[1];
		home = new Page();
		excel = new ExcelUtils();
	}
	
	public void acessarPHPTravels() {
		Configuracoes config = new Configuracoes();
		getDriver().get(config.getUrl());
	}
	
	private String carregaRegistro(int conteudo) {
		if(registro == null) {
			registro = excel.pesquisaRegistro(CODIGO, sc,"MassaDados");
			excel.closeExcel();
		}
		return registro.get(conteudo);
	}
	
	public void escreverFirstName(String firtname) {
		home.escreverFirstName(firtname);
	}

	public void escreverFirstName() {	
		home.escreverFirstName(carregaRegistro(FIRST_NAME));
	}

	public void escreverLastName(String LastName) {
		home.escreverLastName(LastName);
	}

	public void escreverLastName() {
		home.escreverLastName(carregaRegistro(LAST_NAME));
	}

	public void escreverBusinessName(String BusinessName) {
		home.escreverBusinessName(BusinessName);
	}

	public void escreverBusinessName() {
		home.escreverBusinessName(carregaRegistro(BUSINESS_NAME));
	}

	public void escreverEmail(String Email) {
		home.escreverEmail(Email);
	}

	public void escreverEmail() {
		home.escreverEmail(carregaRegistro(E_MAIL));
	}

	public void escreverSoma() {
		home.escreverResultadoSoma();
	}

	public void submit() {
		home.clicarSubmit();
	}

	public void validarMensagem() {
		home.validarMensagemThankYou();
	}

}
