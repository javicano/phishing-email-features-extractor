package com.jcano.phishing.features.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.james.mime4j.MimeException;

import com.jcano.phishing.features.model.Features;
import com.jcano.phishing.features.model.PhishingTermsFrequency;
import com.jcano.phishing.features.parser.EmailParser;

public class FilesReader {
	
	private List<String[]> dataRows = new ArrayList<String[]>();
	
	private PhishingTermsFrequency phishingTermsFrequency;
	
	private boolean isPhishing;
	
	public FilesReader(boolean isPhishing){
		this.phishingTermsFrequency = new PhishingTermsFrequency();
		this.isPhishing = isPhishing;
	}
	
	private void updatePhishingTermWeight(Features features) {
		if(features.isAccountTerm() == true) {
			phishingTermsFrequency.increaseAccountCount();
		}
		if (features.isAgreeTerm() == true) {
			phishingTermsFrequency.increaseAgreeCount();
		}
		if (features.isBankTerm() == true) {
			phishingTermsFrequency.increaseBankCount();
		}
		if (features.isClickTerm() == true) {
			phishingTermsFrequency.increaseClickCount();
		}
		if (features.isDearTerm() == true) {
			phishingTermsFrequency.increaseDearCount();
		}
		if (features.isHelloTerm() == true) {
			phishingTermsFrequency.increaseHelloCount();
		}
		if (features.isHereTerm() == true) {
			phishingTermsFrequency.increaseHereCount();
		}
		if (features.isImportantTerm() == true) {
			phishingTermsFrequency.increaseImportantCount();
		}
		if (features.isLoginTerm() == true) {
			phishingTermsFrequency.increaseLoginCount();
		}
		if (features.isPasscodeTerm() == true) {
			phishingTermsFrequency.increasePasscodeCount();
		}
		if (features.isPaymentTerm() == true) {
			phishingTermsFrequency.increasePaymentCount();
		}
		if (features.isPayPalTerm() == true) {
			phishingTermsFrequency.increasePaypalCount();
		}
		if (features.isPayrollTerm() == true) {
			phishingTermsFrequency.increasePayrollCount();
		}
		if (features.isPurchaseTerm() == true) {
			phishingTermsFrequency.increasePurchaseCount();
		}
		if (features.isRequestTerm() == true) {
			phishingTermsFrequency.increaseRequestCount();
		}
		if (features.isSuspendTerm() == true) {
			phishingTermsFrequency.increaseSuspendCount();
		}
		if (features.isUpdateTerm() == true) {
			phishingTermsFrequency.increaseUpdateCount();
		}
		if (features.isUrgentTerm() == true) {
			phishingTermsFrequency.increaseUrgentCount();
		}
		if (features.isVerifyTerm() == true) {
			phishingTermsFrequency.increaseVerifyCount();
		}
	}

	public void readCollection(String colllectionPath) throws FileNotFoundException {
		EmailParser emailParser = new EmailParser();
		
		File folder = new File(colllectionPath);
		File[] listOfFiles = folder.listFiles();
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
				try {
					Features features = emailParser.getEmailFeatures(file.getPath());
					features.setPhishing(isPhishing);
					this.updatePhishingTermWeight(features);
					if(dataRows.size() == 0) {
						dataRows.add(features.fieldNames()); //Print headers
					}
					dataRows.add(features.toArray());
				} catch (MimeException | IOException | StackOverflowError e) {
					System.out.println("ERROR::Error Reading file " + file.getName());
					//e.printStackTrace();
				}
		    	
		    } else if(file.isDirectory()) {
		    	this.readCollection(file.getPath());
		    }
		}
	}
	

	public List<String[]> getDataRows() {
		return this.dataRows;
	}
	
	public PhishingTermsFrequency getPhishingTermsFrequency() {
		return this.phishingTermsFrequency;
	}
	
	

}
