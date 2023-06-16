package com.phptravels.test.model;

import java.util.List;

import com.phptravels.kernel.ExcelUtils;

public class FormularioModel {
	private final int codigoExcel = 0;
	private final int firstNameExcel = 1;
	private final int lastNameExcel = 2;
	private final int businessNameExcel= 3;
	private final int eMailExcel = 4; 
	
	private String planilha = "MassaDados";
	
	private ExcelUtils excel;
	private List<String> registro;
	
	//CONSTRUTOR
	public FormularioModel(String regCenario) {
		excel = new ExcelUtils();
		registro = excel.buscarRegistro(codigoExcel,regCenario, this.planilha);
		excel.closeExcel();
	}

	public String getFirstName() {
		return registro.get(firstNameExcel);
	}

	public String getLastName() {
		return registro.get(lastNameExcel);
	}

	public String getBusinessName() {
		return registro.get(businessNameExcel);
	}

	public String geteMail() {
		return registro.get(eMailExcel);
	}

}
