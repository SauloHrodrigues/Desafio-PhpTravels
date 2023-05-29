package phpTravel.utils;
import static phpTravel.utils.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class DSL {
	private int time=10;
	private WebDriverWait wait= new WebDriverWait(getDriver(), time);



//	************** Escrever no Elemento ****************************
	public void escrever(WebElement elemento, String texto) {
		wait.until(ExpectedConditions.elementToBeClickable(elemento));
		elemento.sendKeys(texto);;
	}
	public void escrever(By by, String texto) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		getDriver().findElement(by).sendKeys(texto);;
	}
	
	public void escrever(String id, String texto) {
		By by = By.id(id);
		if(	esperar(by)) {
			getDriver().findElement(By.id(id)).sendKeys(texto);			
		}else {
			System.out.println(by +" NÃO ENCONTRADO!!");
		}	
	}

//	************** Clicar no Elemento ****************************
	public void clicar(By by) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		getDriver().findElement(by).click();
	}
	public void clicar(WebElement elemento) {
		elemento.click();
	}

//	************** Retornar WebElement ***********************************
	public WebElement retornaElemento(By by) {
		return getDriver().findElement(by);
	}
	
//	************** Retornar texto ***********************************
	public String getTextoElemento(By by) {
		return getDriver().findElement(by).getText();
	}
	public String getTextoElemento(WebElement elemento) throws InterruptedException {
		Thread.sleep(3000);
		return elemento.getText();
	}
//	************** Espera ***********************************
	public void esperar(int time, By by) {
		this.time= time;
		esperar(by);		
	}
	public boolean esperar(By by) {
		boolean r = true;
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by)) ;
		} catch (TimeoutException e) {
			System.out.println("O elemento "+by +" não foi encontrado!!!!!");
			r = false;
		}
		return r;
		
	}
	public void esperarElementoVisivel(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public boolean esperarElementoVisivel(WebElement elemento) {
		try {
			wait.until(ExpectedConditions.visibilityOf(elemento));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public String esperarElemento(WebElement elemento) {
		try {
			wait.until(ExpectedConditions.visibilityOf(elemento));
			return elemento.getText();
		} catch (Exception e) {
			return "Elemento não disponivel!";
		}
	}
	
//	************** Valida elemento Visivel na tela ******************
	
	public boolean validaElemento(By by) {
		boolean aux= true;
		try {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			getDriver().findElement(by);
		} catch (Exception e) {
			aux = false;
		}
		return aux;
	}
	
//	***************** JAVA SCRIPT *********************
	private JavascriptExecutor js() {
		return (JavascriptExecutor) getDriver();
	}
	
	public void clicarJS(WebElement elemento) {
		js().executeScript("arguments[0].click();", elemento);
	}
	public void clicarJS(By by) {
		WebElement elemento = getDriver().findElement(by);
		js().executeScript("arguments[0].click();", elemento);
	}
	
	public void rolarPaginaJS(WebElement elemento) {
		js().executeScript("windows.scrollBy(0,argument[0]);", elemento.getLocation().y);
	}
	public void rolarPaginaJS(By by) {
		WebElement elemento = getDriver().findElement(by);
		js().executeScript("windows.scrollBy(0,argument[0]);", elemento.getLocation().y);
	}
	
}
