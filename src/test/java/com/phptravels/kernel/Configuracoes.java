package com.phptravels.kernel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuracoes {

	private Properties properties;
	private final String propertyFilePath= "./src/test/resources/configuracoes/configuracoes.properties";
		
	public Configuracoes(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuracoes.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driver.path");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuracoes.properties file.");		
	}
	
	public String getUrl() {
		String url = properties.getProperty("execucao.url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuracoes.properties file.");
	}

	public String getBaseDados() {
		String url01 = properties.getProperty("BASE_DADOS");
		if(url01 != null) return url01;
		else throw new RuntimeException("url not specified in the Configuracoes.properties file.");
	}

}
