package phpTravel.page;

import static phpTravel.utils.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import phpTravel.utils.DSL;

public class HomePhpTravelPage {

	private DSL dsl;
	
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

	@FindBy(how = How.XPATH, using = "//h2/strong[text()=' Thank you!']")
	private WebElement msgThankYou;


//	CONSTRUTOR
	public HomePhpTravelPage() {
		dsl = new DSL();
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
	
	public void escreverResultado(String resultado) {
		dsl.escrever(campoResultado, resultado);
	}
	
	public void clicarSubmit() {
		dsl.clicarJS(btnSubmit);
	}
	
	public Integer retornaN1() {
		return Integer.parseInt(lblPrimeiroNumero.getText());		
	}

	public Integer retornaN2() {
		return Integer.parseInt(lblSegundoNumero.getText());		
	}
	
	public Integer getSoma() {
		return retornaN1()+retornaN2();
	} 
	
	public String validaMensagem() {
		
		return dsl.esperarElemento(msgThankYou);
	}
	
}
