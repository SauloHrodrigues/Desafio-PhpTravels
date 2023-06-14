package com.phptravels.test.pages;

import static com.phptravels.kernel.DriverFactory.getDriver;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.kernel.SeleniumInterative;

public class Page {

	private SeleniumInterative dsl;
	
	@FindBy(xpath = "//input[@type='text'][@name='first_name']")
	private WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@type='text'][@name='last_name']")
	private WebElement txtLastName;
	
	@FindBy(xpath = "//input[@type='text'][@name='business_name']")
	private WebElement txtBusinessName;
	
	@FindBy(xpath = "//input[@type='email'][@name='email']")
	private WebElement txtEmail;
	
	@FindBy(id = "number")
	private WebElement txtResultado;
	
	@FindBy(id = "numb1")
	private WebElement lblPrimeiroNumero;
	
	@FindBy(id = "numb2")
	private WebElement lblSegundoNumero;
	
	@FindBy(id = "demo")
	private WebElement btnSubmit;

	@FindBy(xpath = "//strong[text()=' Thank you!']")
	private WebElement msgTankYou;


//	CONSTRUTOR
	public Page() {
		dsl = new SeleniumInterative();
		PageFactory.initElements(getDriver(), this);
	}
	
//	METODOS
	public void escreverFirstName(String texto) {
		dsl.escrever(txtFirstName, texto);
	}
	
	public void escreverLastName(String lastName) {
		dsl.escrever(txtLastName, lastName);
	}
	
	public void escreverBusinessName(String businessName) {
		dsl.escrever(txtBusinessName, businessName);
	}
	
	public void escreverEmail(String email) {
		dsl.escrever(txtEmail, email);
	}
	
	public void escreverResultadoSoma() {
		int n1 = Integer.parseInt(lblPrimeiroNumero.getText());
		int n2 = Integer.parseInt(lblSegundoNumero.getText());
		dsl.escrever(txtResultado, n1+n2) ;
	}
	
	public void clicarSubmit() {
		dsl.clicarJS(btnSubmit);
	}

	
	public void validarMensagemThankYou() {	
		dsl.esperarElementoVisivel(msgTankYou, 20);
		Assert.assertTrue(msgTankYou.isDisplayed());	
		}
	
}