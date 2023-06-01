package com.phptravels.kernel;
import static com.phptravels.kernel.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;



public class SeleniumInterative extends Esperas{
	private int tempoPadrao = 20;
	
	//Construtor
	public SeleniumInterative() {
		super();
		
	}

	public void escrever(WebElement elemento, String texto, int time) {
//		EsperasEmEspecies.esperarElementomVisivel(elemento, time);
			elemento.sendKeys(texto);
				
	}
	
	public void escrever(WebElement elemento, String texto) {
//		elemento.sendKeys(texto);
		escrever(elemento, texto, this.tempoPadrao);
	}
	
	public void escrever(WebElement elemento, Integer numero) {
		String texto = ""+numero;
		escrever(elemento,texto, this.tempoPadrao);
	}


//	************** Clicar no Elemento ****************************

	public void clicar(WebElement elemento, int timeEspera) {
//		EsperasEmEspecies.esperarElementoClicavel(elemento, timeEspera);
		try {
			elemento.click();			
		} catch (Exception e) {
			System.out.println("Elemento não encontrado");
			e.fillInStackTrace();
		}
	}
	public void clicar(WebElement elemento) {
		clicar(elemento, this.tempoPadrao);
	}

//	************** Retornar WebElement ***********************************
	public WebElement retornaElemento(By by) {
		return getDriver().findElement(by);
	}
	
//	************** Retornar texto ***********************************
	public String getTextoElemento(WebElement elemento) {
		esperarElementoVisivel(elemento, tempoPadrao);
		return elemento.getText();
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
	
//   ***************** Esperas ===============================
	
	
	
}
