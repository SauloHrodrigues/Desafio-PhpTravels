package br.com.phptravels.kernel.utils;

import cucumber.api.Scenario;

public class IdCenariosUtils {
	private String id;
	
	public IdCenariosUtils(Scenario cenario) {
		normalizar(cenario);
	}
	
	private void normalizar(Scenario cenario) {
		// tratar cenario de id
		String aux = cenario.getSourceTagNames().stream().filter(t -> t.startsWith("@#")).findFirst().get();
		String[] aux01 = aux.split("@");
		id= aux01[1];	
	}

	public String getId() {
		return id;
	}
}