package phpTravel.utils;

import static phpTravel.utils.DriverFactory.getDriver;

public class AcessarSite {

	private static Configuracoes configuracoes;

	public static void acessarSitePHPTravels() {
		configuracoes = new Configuracoes();		
		getDriver().get(configuracoes.getUrlPHPTravals());		

	}

}
