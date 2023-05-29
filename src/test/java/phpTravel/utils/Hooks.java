package phpTravel.utils;

import static phpTravel.utils.DriverFactory.getDriver;
import static phpTravel.utils.DriverFactory.killDriver;

import java.io.IOException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	@Before("@#001")
	public void inicio() {
		getDriver();
	}
	
//	@After("@#002")
//	public void finalizar() {
//		
//		killDriver();
//	}
	
	@After
	public void finalizarGeral(Scenario sc) throws IOException {
		ScrenShorts.evidencias(sc);

//		killDriver();
	}
	
}
