package phpTravel.utils;

import static phpTravel.utils.DriverFactory.getDriver;

public class AcessarSite {
	public static void acessarSite(String site) {
		getDriver().get(site);
	}
}
