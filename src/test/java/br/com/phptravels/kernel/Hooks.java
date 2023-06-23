package br.com.phptravels.kernel;

import static br.com.phptravels.kernel.ConstrutorDriver.killDriver;

import java.io.IOException;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {
		
	@After
	public void finalizaProjeto(Scenario sc) throws IOException {
		CapturaEvidenciasTela.evidencias(sc);
		killDriver();
	}
	
}