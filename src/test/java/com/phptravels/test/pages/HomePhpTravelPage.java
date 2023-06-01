package com.phptravels.test.pages;

import static com.phptravels.kernel.DriverFactory.getDriver;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.kernel.SeleniumInterative;

public class HomePhpTravelPage {

	private SeleniumInterative dsl;
	
	@FindBy(how = How.XPATH, using = "//input[@type='text'][@name='first_name']")
	private WebElement campoFirstName;
	
	@FindBy(how = How.XPATH, using = "//input[@type='text'][@name='last_name']")
	private WebElement campoLastName;
	
	@FindBy(how = How.XPATH, using = "//input[@type='text'][@name='business_name']")
	private WebElement campoBusinessName;
	
	@FindBy(how = How.XPATH, using = "//input[@type='email'][@name='email']")
	private WebElement campoEmail;
	
	@FindBy(how = How.ID, using = "number")
	private WebElement campoResultado;
	
	@FindBy(how = How.ID, using = "numb1")
	private WebElement lblPrimeiroNumero;
	
	@FindBy(how = How.ID, using = "numb2")
	private WebElement lblSegundoNumero;
	
	@FindBy(how = How.ID, using = "demo")
	private WebElement btnSubmit;

	@FindBy(how = How.ID, using = "colored")
	private WebElement imgValidado;

	@FindBy(how = How.XPATH, using = "//h2/strong[text()=' Thank you!']")
	private WebElement msgThankYou;


//	CONSTRUTOR
	public HomePhpTravelPage() {
		dsl = new SeleniumInterative();
		PageFactory.initElements(getDriver(), this);
	}
	
//	METODOS
	public void escreverFirstName(String texto) {
		dsl.escrever(campoFirstName, texto);
	}
	
	public void escreverLastName(String lastName) {
		dsl.escrever(campoLastName, lastName);
	}
	
	public void escreverBusinessName(String businessName) {
		dsl.escrever(campoBusinessName, businessName);
	}
	
	public void escreverEmail(String email) {
		dsl.escrever(campoEmail, email);
	}
	
	public void escreverResultadoSoma() {
		dsl.escrever(campoResultado, getNumero1()+getNumero2()) ;
	}
	
	public void clicarSubmit() {
		dsl.clicarJS(btnSubmit);
	}
	
	private Integer getNumero1() {
		return Integer.parseInt(lblPrimeiroNumero.getText());		
	}

	private Integer getNumero2() {
		return Integer.parseInt(lblSegundoNumero.getText());		
	}
	
	public void validaMensagemThankYou() {	
		dsl.esperarElementoVisivel(imgValidado, 20);
		Assert.assertTrue(imgValidado.isDisplayed());	
		}
	
}