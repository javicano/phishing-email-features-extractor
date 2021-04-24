package com.jcano.phishing.features.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.parser.AbstractContentHandler;
import org.apache.james.mime4j.stream.BodyDescriptor;
import org.apache.james.mime4j.stream.Field;

import com.jcano.phishing.features.Features;
import com.jcano.phishing.features.utils.FeaturesUtils;

public class ContentHandler extends AbstractContentHandler {
	
	private final static String FROM = "From";
	
	private final static String MESSAGE_ID = "Message-Id";
	
	private String from;
	
	private String messageId;
	
	private Features features = new Features();
    
    public void endHeader() throws MimeException {
    	features.setDomainSender(FeaturesUtils.matchDomainSender(from, messageId));
    }
    
    public void field(Field field) throws MimeException {
    	if(field.getName().equalsIgnoreCase(FROM)) {
    		this.from = field.getBody();
    	}
    	if(field.getName().equalsIgnoreCase(MESSAGE_ID)) {
    		this.messageId = field.getBody();
    	}
    }
	
	public void body(BodyDescriptor bd, InputStream is)
            throws MimeException, IOException {
		
        String bodyStr = new BufferedReader(
        	      new InputStreamReader(is, StandardCharsets.UTF_8))
        	        .lines()
        	        .collect(Collectors.joining("\n"));
        features.setHtmlBody(FeaturesUtils.hasHTMLTags(bodyStr));
        features.setScriptTag(FeaturesUtils.hasScriptTag(bodyStr));
        features.setHexadecimalURLs(FeaturesUtils.getNumberOfUrlsWithHexaChars(FeaturesUtils.getURLs(bodyStr)));
        features.setAccountTerm(FeaturesUtils.isTerm(FeaturesUtils.ACCOUNT, bodyStr));
        features.setAgreeTerm(FeaturesUtils.isTerm(FeaturesUtils.AGREE, bodyStr));
        features.setDearTeam(FeaturesUtils.isTerm(FeaturesUtils.DEAR, bodyStr));
        features.setDomainsCount(0);
        features.setDotsCount(0);
        features.setImagesAsURL(FeaturesUtils.numberOfImageAsURL(bodyStr));
        features.setLoginTerm(FeaturesUtils.isTerm(FeaturesUtils.LOGIN, bodyStr));
        features.setPayPalTerm(FeaturesUtils.isTerm(FeaturesUtils.PAYPAL, bodyStr));
        features.setPhishingTermsWeight(10);
        features.setSuspendTerm(FeaturesUtils.isTerm(FeaturesUtils.SUSPEND, bodyStr));
        features.setVerifyTerm(FeaturesUtils.isTerm(FeaturesUtils.VERIFY, bodyStr));
    }
    
	public Features getFeatures() {
    	return this.features;
    }

}
