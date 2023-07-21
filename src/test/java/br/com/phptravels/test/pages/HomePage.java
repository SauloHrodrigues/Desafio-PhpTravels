package br.com.phptravels.test.pages;

import static br.com.phptravels.kernel.Contexto.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
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
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtBusinessName() {
		return txtBusinessName;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtResultado() {
		return txtResultado;
	}

	public WebElement getLblPrimeiroNumero() {
		return lblPrimeiroNumero;
	}

	public WebElement getLblSegundoNumero() {
		return lblSegundoNumero;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getMsgTankYou() {
		return msgTankYou;
	}
}