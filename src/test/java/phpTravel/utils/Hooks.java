package phpTravel.utils;

import static phpTravel.utils.DriverFactory.getDriver;
import static phpTravel.utils.DriverFactory.killDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	@Before("@#001")
	public void inicio() {
		getDriver();
	}
	
	@After("@#001")
	public void finalizar() {
		killDriver();
	}
	
}
