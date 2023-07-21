package br.com.phptravels.kernel.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.phptravels.kernel.Contexto;
import cucumber.api.Scenario;

public class Evidencia  {

	public void capturarTela(Scenario sc) throws IOException {
		//TODO tratar exceção
		LocalDateTime data = LocalDateTime.now();
		int dd = data.getDayOfMonth();
		int MM = data.getMonthValue();
		int aaaa = data.getYear();
		int hh =data.getHour();
		int mm = data.getMinute();
		//arrumar TODO
		String aux =sc.getSourceTagNames().stream().filter(t->t.startsWith("@#")).findFirst().get();
		String[] tag = aux.split("@");
		String status;
		
		if(sc.isFailed()) {
			status="FAIL";
		}else {
			status ="PASS";
		}
		
//		TakesScreenshot screen = (TakesScreenshot) getDriver();
		TakesScreenshot screen = (TakesScreenshot) Contexto.getDriver();
		File evidencias= screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(evidencias, new File(
				"evidencias"+File.separator+tag[1]+"_"+dd+"_"+MM+"_"+aaaa+
				"_"+hh+"_"+mm+"_"+status+".jpg"));
	}

}
