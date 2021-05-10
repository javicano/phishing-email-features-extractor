package com.jcano.phishing.features;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.jcano.phishing.features.io.FileWriter;
import com.jcano.phishing.features.io.FilesReader;
import com.jcano.phishing.features.model.PhishingTermsFrequency;

/**
 * Phishing email classifier
 * Features extractor
 *
 */
public class FeaturesExtractor {
	
	private static Properties properties =  new Properties();
	private static String phishingCollectionPath = "";
	private static String hamColllectionPath = "";
	private static String outputDirectory = "";
	
    private static void  loadConfiguration () throws IOException  {
    	InputStream inputStream = FeaturesExtractor.class.getClassLoader().getResourceAsStream("config.properties");
    	properties.load(inputStream);
    	phishingCollectionPath = properties.getProperty("phishing.email.collection.path");
		hamColllectionPath = properties.getProperty("ham.email.collection.path");
		outputDirectory = properties.getProperty("output.directory");
    }
	
	public static void main( String[] args ) {
		
		try {
			loadConfiguration();
			
			FilesReader filesReader = new FilesReader(false);
			filesReader.readCollection(hamColllectionPath);
			System.out.println("Ham Terms Report");
			System.out.println("----------------------------");
			PhishingTermsFrequency phishingTermsFrequency = filesReader.getPhishingTermsFrequency();
			phishingTermsFrequency.getPhishingTermsFrequency();
			List<String[]> dataRows = filesReader.getDataRows();	
			
			filesReader = new FilesReader(true);
			filesReader.readCollection(phishingCollectionPath);
			System.out.println("Phishing Terms Report");
			System.out.println("----------------------------");
			phishingTermsFrequency = filesReader.getPhishingTermsFrequency();
			phishingTermsFrequency.getPhishingTermsFrequency();
			
			dataRows.addAll(filesReader.getDataRows());
			
			FileWriter fileWriter = new FileWriter();
			fileWriter.generateCSVfile(dataRows, outputDirectory, "email_features_output");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}