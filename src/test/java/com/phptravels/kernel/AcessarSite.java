package com.phptravels.kernel;

import static com.phptravels.kernel.DriverFactory.getDriver;

public class AcessarSite {

	public static void acessarSitePHPTravels() {
		getDriver().get("https://phptravels.com/demo/");
	}
}
