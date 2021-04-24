package com.jcano.phishing.features.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.james.mime4j.MimeException;

import com.jcano.phishing.features.Features;
import com.jcano.phishing.features.parser.EmailParser;

public class FilesReader {
	
	private List<String[]> dataRows = new ArrayList<String[]>();

	public void readCollection(String hamColllectionPath, boolean isPhishing) throws FileNotFoundException {
		EmailParser emailParser = new EmailParser();
		File folder = new File(hamColllectionPath);
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
		    if (file.isFile()) {
				try {
					Features features = emailParser.getEmailFeatures(file.getPath());
					features.setPhishing(isPhishing);
					if(dataRows.size() == 0) {
			    		dataRows.add(features.fieldNames());
			    	}
			    	dataRows.add(features.toArray());
				} catch (MimeException | IOException | StackOverflowError e) {
					System.out.println("ERROR::Error Reading file " + file.getName());
					//e.printStackTrace();
				}
		    	
		    } else if(file.isDirectory()) {
		    	this.readCollection(file.getPath(), isPhishing);
		    }
		}
	}

	public List<String[]> getDataRows() {
		return this.dataRows;
	}

}
