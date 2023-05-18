package phpTravel.utils;

import static phpTravel.utils.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScrenShorts  {

	
	

//	public void imagens(Scenario scenario) {
//
//	File screenshot = ((TakesScreenshot) driver.getScreenshotAs(OutputType.FILE);
//
//	String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
//
//	 
//
//	String mensagem;
//
//	if (scenario.isFailed()) {
//
//	mensagem = "Falhou";
//
//	} else {
//
//	mensagem = "Passou";
//
//	}
//
//	 
//
//	try {
//
//	FileUtils.copyFile(screenshot, new File("./LoginSimples/img" + scenario.getName() + "-" + timestamp + "-" + mensagem + ".png"));
//
//	} catch (IOException e) {
//
//	e.printStackTrace();
//
//	}
//
//	}
}
