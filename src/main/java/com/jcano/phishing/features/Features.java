package com.jcano.phishing.features;

public class Features {
	
	private final static int NUMBER_OF_ATTRIBUTES = 19;
	
	/**
	 * Checks if the email body contains HTML content.
	 */
	private boolean htmlBody;
	
	
	/**
	 * Checks if the email body contains javascript script tag.
	 */
	private boolean scriptTag;
	
	/**
	 * The number of URLs consisting of hexadecimal characters in the email.
	 */
	private int hexadecimalURLs;
	
	/**
	 * The number of domains in the URLs that exists in the email.
	 */
	private int domainsCount;
	
	/**
	 * The number of URLs whose label is different from its anchor in the email.
	 */
	private int textLinkDifference;
	
	/**
	 * The maximum number of dots that exist in a URL in the email.
	 */
	private int dotsCount;
	
	/**
	 * Checks if the email contains the term “Account”
	 */
	private boolean isAccountTerm;
	
	/**
	 * Checks if the email contains the term “Dear”
	 */
	private boolean isDearTeam;
	
	/**
	 * The number of image URLs.
	 */
	private int imagesAsURL;
	
	/**
	 * The number of URLs whose domain is specified as an IP address.
	 */
	private int ipUrls;
	
	/**
	 * Checks if the email contains the term “PayPal”
	 */
	private boolean isPayPalTerm;
	
	/**
	 * Checks if the email contains the term “Login”
	 */
	private boolean isLoginTerm;
	
	/**
	 * Checks if the email contains the term “Bank”
	 */
	private boolean isBankTerm;
	
	
	/**
	 * Checks if the email contains the term “Verify”
	 */
	private boolean isVerifyTerm;
	
	/**
	 * Checks if the email contains the term “Agree”
	 */
	private boolean isAgreeTerm;
	
	/**
	 * Checks if the email contains the term “Suspend”
	 */
	private boolean isSuspendTerm;
	
	/**
	 * Class attribute
	 */
	private boolean isPhishing;
	
	/**
	 * A weight that is assigned to each email and represents
	 * the sum of weights of the phishing terms that exists in that email
	 */
	private int phishingTermsWeight;
	
	/**
	 * 
	 */
	private boolean domainSender;

	public boolean isHtmlBody() {
		return htmlBody;
	}

	public void setHtmlBody(boolean htmlBody) {
		this.htmlBody = htmlBody;
	}
	
	public boolean isScriptTag() {
		return scriptTag;
	}

	public void setScriptTag(boolean scriptTag) {
		this.scriptTag = scriptTag;
	}

	public int getHexadecimalURLs() {
		return hexadecimalURLs;
	}

	public void setHexadecimalURLs(int hexadecimalURLs) {
		this.hexadecimalURLs = hexadecimalURLs;
	}

	public int getDomainsCount() {
		return domainsCount;
	}

	public void setDomainsCount(int domainsCount) {
		this.domainsCount = domainsCount;
	}

	public int getTextLinkDifference() {
		return textLinkDifference;
	}

	public void setTextLinkDifference(int textLinkDifference) {
		this.textLinkDifference = textLinkDifference;
	}

	public int getDotsCount() {
		return dotsCount;
	}

	public void setDotsCount(int dotsCount) {
		this.dotsCount = dotsCount;
	}

	public boolean isAccountTerm() {
		return isAccountTerm;
	}

	public void setAccountTerm(boolean isAccountTerm) {
		this.isAccountTerm = isAccountTerm;
	}

	public boolean isDearTeam() {
		return isDearTeam;
	}

	public void setDearTeam(boolean isDearTeam) {
		this.isDearTeam = isDearTeam;
	}

	public int getImagesAsURL() {
		return imagesAsURL;
	}

	public void setImagesAsURL(int imagesAsURL) {
		this.imagesAsURL = imagesAsURL;
	}

	public int getIpUrls() {
		return ipUrls;
	}

	public void setIpUrls(int ipUrls) {
		this.ipUrls = ipUrls;
	}

	public boolean isPayPalTerm() {
		return isPayPalTerm;
	}

	public void setPayPalTerm(boolean isPayPalTerm) {
		this.isPayPalTerm = isPayPalTerm;
	}

	public boolean isLoginTerm() {
		return isLoginTerm;
	}

	public void setLoginTerm(boolean isLoginTerm) {
		this.isLoginTerm = isLoginTerm;
	}

	public boolean isBankTerm() {
		return isBankTerm;
	}

	public void setBankTerm(boolean isBankTerm) {
		this.isBankTerm = isBankTerm;
	}

	public boolean isVerifyTerm() {
		return isVerifyTerm;
	}

	public void setVerifyTerm(boolean isVerifyTerm) {
		this.isVerifyTerm = isVerifyTerm;
	}

	public boolean isAgreeTerm() {
		return isAgreeTerm;
	}

	public void setAgreeTerm(boolean isAgreeTerm) {
		this.isAgreeTerm = isAgreeTerm;
	}

	public boolean isSuspendTerm() {
		return isSuspendTerm;
	}

	public void setSuspendTerm(boolean isSuspendTerm) {
		this.isSuspendTerm = isSuspendTerm;
	}

	public int getPhishingTermsWeight() {
		return phishingTermsWeight;
	}

	public void setPhishingTermsWeight(int phishingTermsWeight) {
		this.phishingTermsWeight = phishingTermsWeight;
	}
	
	public boolean isPhishing() {
		return isPhishing;
	}

	public void setPhishing(boolean isPhishing) {
		this.isPhishing = isPhishing;
	}
	
	public boolean isDomainSender() {
		return domainSender;
	}

	public void setDomainSender(boolean domainSender) {
		this.domainSender = domainSender;
	}
	
	public String[] fieldNames() {
		String[] fieldNames = new String[NUMBER_OF_ATTRIBUTES];
		fieldNames[0] = "htmlBody";
		fieldNames[1] = "scriptTag";
		fieldNames[2] = "hexadecimalURLs";
		fieldNames[3] = "domainsCount";
		fieldNames[4] = "textLinkDifference";
		fieldNames[5] = "dotsCount";
		fieldNames[6] = "isAccountTerm";
		fieldNames[7] = "isDearTeam";
		fieldNames[8] = "imagesAsURL";
		fieldNames[9] = "ipUrls";
		fieldNames[10] = "isPayPalTerm";
		fieldNames[11] = "isLoginTerm";
		fieldNames[12] = "isBankTerm";
		fieldNames[13] = "isVerifyTerm";
		fieldNames[14] = "isAgreeTerm";
		fieldNames[15] = "isSuspendTerm";
		fieldNames[16] = "phishingTermsWeight";
		fieldNames[17] = "domainSender";
		fieldNames[18] = "isPhishing";
		return fieldNames;
	}
	
	public String[] toArray() {
		String[] featuresArr = new String[NUMBER_OF_ATTRIBUTES];
		// htmlBody
		featuresArr[0] = this.htmlBody ? "1" : "0";
		// scriptTag
		featuresArr[1] = this.scriptTag ? "1" : "0";
		// hexadecimalURLs
		featuresArr[2] = String.valueOf(this.hexadecimalURLs);
		// domainsCount
		featuresArr[3] = String.valueOf(this.domainsCount);
		// textLinkDifference
		featuresArr[4] = String.valueOf(this.textLinkDifference);
		// dotsCount
		featuresArr[5] = String.valueOf(this.dotsCount);
		// isAccountTerm
		featuresArr[6] = this.isAccountTerm ? "1" : "0";
		// isDearTeam
		featuresArr[7] = this.isDearTeam ? "1" : "0";
		// imagesAsURL
		featuresArr[8] = String.valueOf(this.imagesAsURL);
		// ipUrls
		featuresArr[9] = String.valueOf(this.ipUrls);
		// isPayPalTerm
		featuresArr[10] = this.isPayPalTerm ? "1" : "0";
		// isLoginTerm
		featuresArr[11] = this.isLoginTerm ? "1" : "0";
		// isBankTerm
		featuresArr[12] = this.isBankTerm ? "1" : "0";
		// isVerifyTerm
		featuresArr[13] = this.isVerifyTerm ? "1" : "0";
		// isAgreeTerm
		featuresArr[14] = this.isAgreeTerm ? "1" : "0";
		// isSuspendTerm
		featuresArr[15] = this.isSuspendTerm ? "1" : "0";
		// phishingTermsWeight
		featuresArr[16] = String.valueOf(this.phishingTermsWeight);
		// domainSender
		featuresArr[17] = this.domainSender ? "1" : "0";
		// Class field
		featuresArr[18] = this.isPhishing ? "1" : "0";
		
		return featuresArr;
	}
	

}
