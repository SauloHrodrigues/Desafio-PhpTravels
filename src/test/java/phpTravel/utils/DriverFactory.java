package phpTravel.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static WebDriver driver;	
	private static Configuracoes configuracoes = new Configuracoes();
	private DriverFactory() {
		
	}
	
	public static WebDriver getDriver() {
		if(driver == null) {
			System.setProperty("webdriver.chrome.driver", configuracoes.getDriverPath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();			
		}
		return driver;
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();	
			driver = null;
		}
	}
		
}
