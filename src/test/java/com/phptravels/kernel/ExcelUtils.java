package com.phptravels.kernel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {
	private static HSSFWorkbook pastaDeTrabalho;
	private static HSSFSheet abaPlanilha;
	private static HSSFCell celula; 
	private static Configuracoes configuracoes;
	private FileInputStream planilha;
	private int totalRegistros;
	private int totalColunas;
	
	
	public ExcelUtils() {
		configuracoes = new Configuracoes();
	}

	//metodo setar o arquivo (abre o arquivo)
	private void setArquivoExcel(String sNomeDaAbaDaPlanilha ) {  
		File arquivo = new File(configuracoes.getBaseDados()); 
		planilha = null;
		try {
			planilha = new FileInputStream(arquivo);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrada.");
		} 
		try {
			pastaDeTrabalho = new HSSFWorkbook(planilha);
		} catch (IOException e) {
			System.out.println("Excel não encontrado!");
		}
		abaPlanilha = pastaDeTrabalho.getSheet(sNomeDaAbaDaPlanilha);
		totalRegistros = abaPlanilha.getLastRowNum();
		totalColunas = abaPlanilha.getRow(0).getLastCellNum();	
	}
	
	public void closeExcel() {
		try {
			planilha.close();
			pastaDeTrabalho.close();	
		} catch (IOException e) {
			System.out.println("Excel não encontrado! ");
			e.printStackTrace();
		}
	}
		
	private String getConteudoCelula(int iNumeroDaLinha, int iNumeroDaCelula) {
		celula = abaPlanilha.getRow(iNumeroDaLinha).getCell(iNumeroDaCelula);
		return celula.getStringCellValue();
	}
	
	public List<String> pesquisaRegistro(Integer coluna, String texto, String planilha) {
		setArquivoExcel(planilha);
		int linhaRegistro =0;
		List<String> registro= new ArrayList<>(); 
		
		while (linhaRegistro < totalRegistros) {
			if(texto.equalsIgnoreCase(getConteudoCelula(linhaRegistro, coluna))) {
				
				for(int i=0;i<totalColunas;i++) {
					registro.add(getConteudoCelula(linhaRegistro, i));
				}
				linhaRegistro = totalRegistros;
				break;
			}
			
			linhaRegistro++;
		}	
		
		return registro;	
	}
	
}
