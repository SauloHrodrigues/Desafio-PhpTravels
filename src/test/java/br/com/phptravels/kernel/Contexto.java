package br.com.phptravels.kernel;

import org.openqa.selenium.WebDriver;

import br.com.phptravels.kernel.driver.ConstrutorDriver;
import br.com.phptravels.kernel.utils.IdCenariosUtils;
import cucumber.api.Scenario;

public class Contexto {

	private static ConstrutorDriver construtorDriver;
	private static IdCenariosUtils idCenariosUtils;

	public static void inicializar(Scenario scenario) {
		setConstrutorDriver();
		setIdCenario(scenario);
	}

	private static void setConstrutorDriver() {
		construtorDriver = new ConstrutorDriver();
	}

	public static WebDriver getDriver() {
		return construtorDriver.getDriver();
	}

	private static void setIdCenario(Scenario cenario) {
		idCenariosUtils = new IdCenariosUtils(cenario);
	}

	public static String getIdCenario() {
		return idCenariosUtils.getId();
	}

	public static void finalizar() {
		construtorDriver.killDriver();
		
		construtorDriver = null;
		idCenariosUtils = null;
	}

}
