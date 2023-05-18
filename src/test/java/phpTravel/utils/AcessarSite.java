package phpTravel.utils;

import static phpTravel.utils.DriverFactory.getDriver;

public class AcessarSite {

	private static Configuracoes configuracoes;

	public static void acessarSitePHPTravels() {

		configuracoes = new Configuracoes();
		System.setProperty("webdriver.chrome.driver", configuracoes.getDriverPath());
		getDriver();
		getDriver().manage().window().maximize();
		getDriver().get(configuracoes.getUrlPHPTravals());

//			getDriver().manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);		

	}

}
