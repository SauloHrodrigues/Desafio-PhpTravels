package com.phptravels.kernel;

import static com.phptravels.kernel.DriverFactory.killDriver;

import java.io.IOException;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {
	
//	@Before("@#001")
//	public void inicio() {
//		getDriver();
//	}
	
	@After
	public void finalizaProjeto(Scenario sc) throws IOException {
		ScrenShorts.evidencias(sc);
		killDriver();
	}
	
}
