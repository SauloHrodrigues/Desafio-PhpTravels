package br.com.phptravels.kernel.hooks;

import java.io.IOException;

import br.com.phptravels.kernel.Contexto;
import br.com.phptravels.kernel.utils.Evidencia;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
		
	@Before
	public void inicializarTeste(Scenario cenario) {
		Contexto.inicializar(cenario);
	}
	
	@After
	public void finalizaProjeto(Scenario cenario) throws IOException {
		new Evidencia().capturarTela(cenario);
		Contexto.finalizar();
	}
	
}