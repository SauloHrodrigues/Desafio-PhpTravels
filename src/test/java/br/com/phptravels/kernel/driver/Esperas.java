package br.com.phptravels.kernel.driver;

import static br.com.phptravels.kernel.Contexto.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Esperas {
	private WebDriverWait wait;
	private int tempoPadrao = 20;
	
	//****************** WebDriverWait *************************************
		private WebDriverWait esperar(int tempo) {
			if(tempo != tempoPadrao) {
				wait = new WebDriverWait(getDriver(), tempo);
			}

			if(wait == null) {			 
				 wait = new WebDriverWait(getDriver(), tempoPadrao);
			 }			 
			 return wait;
		}
			
//		Uma expectativa para verificar se o elemento está invisível

		public void esperarElementomVisivel(WebElement elemento, int time) {
			wait.until(ExpectedConditions.invisibilityOf(elemento));
		}

		public void esperarElementomVisivel(WebElement elemento) {
			wait.until(ExpectedConditions.invisibilityOf(elemento));
		}
		
//		Uma expectativa para verificar a presença do WebElement filho como parte do elemento pai
		
		public void esperarElementoFilho(WebElement elemento, By by, int time) {
			esperar(time).until(ExpectedConditions.presenceOfNestedElementLocatedBy(elemento, by));
		}

		
//		Uma expectativa para verificar um elemento é visível e habilitada para que você possa clicar nele.
		public void esperarElementoClicavel(WebElement elemento, int time) {
			esperar(time).until(ExpectedConditions.elementToBeClickable(elemento)	);
		}
		
//		
//		public static  ExpectedCondition <java.lang.Boolean> attributeToBeNotEmpty​(  elemento WebElement , atributo java.lang.String)
//		Uma expectativa para verificar WebElement qualquer valor não vazio para determinado atributo
		public void esperarElementoConteudo(WebElement elemento, int time) {
			esperar(time).until(ExpectedConditions.attributeToBeNotEmpty(elemento, elemento.getText())	);
		}
		
		public void esperarElementoVisivel(WebElement elemento, int time) {
			esperar(time).until(ExpectedConditions.visibilityOf(elemento));//retornar 
		}
		
}//Fim classe