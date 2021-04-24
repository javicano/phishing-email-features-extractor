package com.jcano.phishing.features.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FeaturesUtils {
	
	private static final String HTML_PATTERN = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";
	
	private static final String SCRIPT_PATTERN = "<script[\\s\\S]*?>[\\s\\S]*?<\\/script>";
	
	// Pattern for recognizing a URL, based off RFC 3986
	private static final Pattern URL_PATTERN = Pattern.compile(
		        "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
		                + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
		                + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
		        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
	
	private static final Pattern IP_PATTERN = Pattern.compile("\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b");
	
	private static final Pattern URL_IMAGES = Pattern.compile("https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)(.jpeg|.jpg|.png|.tif|.tiff|.bmp|.gif|.eps|.raw)");
	
	private static final Pattern EMAIL_DOMAIN = Pattern.compile("(?<=@)[a-zA-Z0-9\\.]+(?<=)");
	
	public static final String ACCOUNT = "account";
	
	public static final String DEAR = "dear";
	
	public static final String PAYPAL = "paypal";
	
	public static final String LOGIN = "login";
	
	public static final String BANK = "bank";
	
	public static final String VERIFY = "verify";
	
	public static final String AGREE = "agree";
	
	public static final String SUSPEND = "suspend";
	
	public static boolean hasHTMLTags(String email){
		Pattern pattern = Pattern.compile(HTML_PATTERN);
	    Matcher matcher = pattern.matcher(email);
	    return matcher.find();
	}
	
	public static boolean hasScriptTag(String email){
		Pattern pattern = Pattern.compile(SCRIPT_PATTERN);
	    Matcher matcher = pattern.matcher(email.toLowerCase());
	    return matcher.find();
	}
	
	public static boolean hasURL(String email){
	    Matcher matcher = URL_PATTERN.matcher(email);
	    return matcher.find();
	}
	
	public static List<String> getURLs(String email){
		List<String> urls = new ArrayList<String>();
		Matcher matcher = URL_PATTERN.matcher(email);
		while(matcher.find()) {
			urls.add(matcher.group());
		}
		return urls;
	}
	
	public static int getNumberOfUrlsWithHexaChars(List<String> urls) {
		String [] hexaChars = {"24","26","2C","2F","3A","3B","3D","3F","40","20","22","3C","3E","23","25","7B","7D","7C","5C","5E","7E","5B","5D","60"}; 
		int counter = 0;
		for(String url: urls) {
			for(String hexaChar: hexaChars) {
				if(url.contains("%" + hexaChar)) {
					counter++;
				}
			}
		}
		return counter;
	}
	
	public static boolean isTerm(String term, String email){
		String IS_TERM_PATTERN = "\\b" + term.toLowerCase() + "\\b";
		Pattern pattern = Pattern.compile(IS_TERM_PATTERN);
		Matcher matcher = pattern.matcher(email.toLowerCase());
		return matcher.find();
	}
	
	public static int numberOfImageAsURL(String email){
		Matcher matcher = URL_IMAGES.matcher(email.toLowerCase());
		return matcher.results().toArray().length;
	}
		
	public static int numberOfIpUrls(String text){
		Matcher matcher = IP_PATTERN.matcher(text.toLowerCase());
		return matcher.results().toArray().length;
	}
	

	public static boolean matchDomainSender(String from, String messageId){
		boolean result = false;
		if(from != null && !from.equalsIgnoreCase("") && messageId != null && !messageId.equalsIgnoreCase("")) {
			Matcher fromMatcher = EMAIL_DOMAIN.matcher(from);
			Matcher messageIdMatcher = EMAIL_DOMAIN.matcher(messageId);
			if (fromMatcher.find() && messageIdMatcher.find()){
				String fromDomain = fromMatcher.group();
				String messageIdDomain = messageIdMatcher.group();
				if(!fromDomain.equalsIgnoreCase("") && !messageIdDomain.equalsIgnoreCase("")) {
					if(fromDomain.equalsIgnoreCase(messageIdDomain)) {
						result = true;
					}
					if(fromDomain.contains(messageIdDomain) || messageIdDomain.contains(fromDomain)) {
						result = true;
					}
					
				}
			}
		}
		return result;
		
	}

}
