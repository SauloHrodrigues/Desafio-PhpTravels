package com.phptravels.kernel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {
	private static HSSFWorkbook pastaDeTrabalho;
	private static HSSFSheet abaPlanilha;
	private static HSSFCell celula; 
	private static Configuracoes configuracoes = new Configuracoes();
	
	private final int Codigo=0;
	private final int FirtName=1;
	private final int LastName=2;
	private final int BusinessName=3;
	private final int Email=4;

	//metodo setar o arquivo (abre o arquivo)
	private void setArquivoExcel(String sNomeDaAbaDaPlanilha ) { 
		File arquivo = new File("./src/test/resources/massa_dados/planilhaDados.xls"); 
		FileInputStream planilha = null;
		try {
			planilha = new FileInputStream(arquivo);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrada.");
		} 
		try {
			pastaDeTrabalho = new HSSFWorkbook(planilha);
		} catch (IOException e) {
			System.out.println("Planilha não encontrada.");
		}
		abaPlanilha = pastaDeTrabalho.getSheet(sNomeDaAbaDaPlanilha);
		
	}
		
	private String getConteudoCelula(int iNumeroDaLinha, int iNumeroDaCelula) {
		setArquivoExcel("MassaDados");
		//capturando o endetreço da celula na linha e celula(coluna), passada nos parametros
		celula = abaPlanilha.getRow(iNumeroDaLinha).getCell(iNumeroDaCelula);
		//retorna o valor da celula encontrada
		return celula.getStringCellValue();
	}
	
	private Integer pesquisarCodigoID(String codCenario) {
		int linha =0;
		int coluna = 0;
		
		do {	
			linha++;
		} while (!codCenario.equalsIgnoreCase(getConteudoCelula(linha,coluna)));
			
		return linha;
	}
	
	public String getExcelFirstName(String codigoCenario) {
		return (getConteudoCelula(pesquisarCodigoID(codigoCenario), FirtName));
	}
	
	public String getExcelLastName(String codigoCenario) {
		return (getConteudoCelula(pesquisarCodigoID(codigoCenario), LastName));
	}
	
	
	public String getExcelBusinessName(String codigoCenario) {
		return (getConteudoCelula(pesquisarCodigoID(codigoCenario), BusinessName));
	}
	
	public String getExcelEmail(String codigoCenario) {
		return (getConteudoCelula(pesquisarCodigoID(codigoCenario), Email));
	}
	
}
