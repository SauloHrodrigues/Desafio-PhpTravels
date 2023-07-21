package br.com.phptravels.kernel.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.phptravels.kernel.readers.ConfiguracoesPropriedades;

public class ConstrutorDriver {

	private WebDriver driver;
	private ConfiguracoesPropriedades configuracoes;

	public ConstrutorDriver() {
		configuracoes = new ConfiguracoesPropriedades();
		
		System.setProperty("webdriver.chrome.driver", configuracoes.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
