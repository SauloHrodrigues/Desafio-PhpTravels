package br.com.phptravels.kernel;
import static br.com.phptravels.kernel.ConstrutorDriver.getDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;



public class SeleniumInterative extends Esperas{
	private int tempoPadrao = 20;
	
	//Construtor
	public SeleniumInterative() {
		super();
		
	}
	
	private JavascriptExecutor js() {
		return (JavascriptExecutor) getDriver();
	}

	public void escrever(WebElement elemento, String texto, int time) {
//		EsperasEmEspecies.esperarElementomVisivel(elemento, time);
			elemento.sendKeys(texto);
				
	}
	
	public void escrever(WebElement elemento, String texto) {
//		elemento.sendKeys(texto); Usar esperas!!!!
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

	public void clicarJS(WebElement elemento) {
		js().executeScript("arguments[0].click();", elemento);
	}	

//	************** Retornar texto elemento ****************************
	
	public String getTextoElemento(WebElement elemento) {
		esperarElementoVisivel(elemento, tempoPadrao);
		return elemento.getText();
	}
	
//	************** Rolar pagina até o elemento ****************************
	public void rolarPaginaAteElementoJS(WebElement elemento) {
		js().executeScript("windows.scrollBy(0,argument[0]);", elemento.getLocation().y);
	}
	

	
	
	
}
