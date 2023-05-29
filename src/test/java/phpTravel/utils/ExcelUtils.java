package phpTravel.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

	//metodo setar o arquivo (abre o arquivo)
	public void setArquivoExcel(String sNomeDaAbaDaPlanilha ) {
		File arquivo = new File("C:\\Saulo - keego\\Keego\\Projetos\\Desafio-PhpTravels\\src\\test\\java\\massa_dados\\planilhaDados.xls"); 
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
		
	}// FIM - metodo setar o arquivo 
	
	
	
	public String getValorDaCelulaDoArquivo(int iNumeroDaLinha, int iNumeroDaCelula) {
		setArquivoExcel("MassaDados");
		//capturando o endetreço da celula na linha e celula(coluna), passada nos parametros
		celula = abaPlanilha.getRow(iNumeroDaLinha).getCell(iNumeroDaCelula);
		//retorna o valor da celula encontrada
		return celula.getStringCellValue();
	}
	

	
}
