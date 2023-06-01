package com.phptravels.kernel;

import static com.phptravels.kernel.DriverFactory.getDriver;

public class AcessarSite {
//
//	private static Configuracoes configuracoes;

	public static void acessarSitePHPTravels() {
//		configuracoes = new Configuracoes();		

		getDriver().get("https://phptravels.com/demo/");	


	}

}
