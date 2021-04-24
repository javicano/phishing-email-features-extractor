package com.jcano.phishing.features.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class FeaturesUtilsTest {

    @Test
    public void validateHasHTMLTags(){
    	Assert.assertFalse(FeaturesUtils.hasHTMLTags("Hi, how are you today Regards \n"));
    	Assert.assertTrue(FeaturesUtils.hasHTMLTags("Hi, how are you today Regards <script>alert('Hei')</script>"));
    	Assert.assertTrue(FeaturesUtils.hasHTMLTags("Hi, how are you today </br> Regards"));
    	Assert.assertTrue(FeaturesUtils.hasHTMLTags("Hi, how are you today <customTag> Regards"));
    }
    
    @Test
    public void validateHasURLs(){	
    	List<String> result = FeaturesUtils.getURLs("Hi, "
    			+ "how are you today? "
    			+ "This are the links: "
    			+ "1.- http://10.15.22.2:8080/link1 "
    			+ "2.- https://10.15.22.2/link2 "
    			+ "3.- https://domain.com/link2 "
    			+ "4.- https://ivalidDomain/link2");
    	List<String> expected = new ArrayList<String>();
    	expected.add(" http://10.15.22.2:8080/link1");
    	expected.add(" https://10.15.22.2/link2");
    	expected.add(" https://domain.com/link2");
    	
    	Assert.assertArrayEquals(result.toArray(), expected.toArray());
    }
    
    @Test
    public void isAccountTerm(){
    	String textWithAccount = "Please, add your ._ AcCount. number";
    	String textWithoutAccount = "He emphasized that accountability is not only about supply but also about demand.";
    	Assert.assertTrue(FeaturesUtils.isTerm(FeaturesUtils.ACCOUNT, textWithAccount));
    	Assert.assertFalse(FeaturesUtils.isTerm(FeaturesUtils.ACCOUNT, textWithoutAccount));
    }
    
    @Test
    public void isDearTerm(){
    	String textWithDear = "Dear customer";
    	String textWithoutDear = "Deardrops is the name of the band";
    	Assert.assertTrue(FeaturesUtils.isTerm(FeaturesUtils.DEAR, textWithDear));
    	Assert.assertFalse(FeaturesUtils.isTerm(FeaturesUtils.DEAR, textWithoutDear));
    }
    
    @Test
    public void isPaypalTerm(){
    	String textWithPaypal = "Please, introduce your paypal credentials";
    	String textWithoutPaypal = "Just for testing purpose";
    	Assert.assertTrue(FeaturesUtils.isTerm(FeaturesUtils.PAYPAL, textWithPaypal));
    	Assert.assertFalse(FeaturesUtils.isTerm(FeaturesUtils.PAYPAL, textWithoutPaypal));
    }
    
    @Test
    public void isLoginTerm(){
    	String textWithLogin = "Please, access to login page";
    	String textWithoutLogin = "Just for testing purpose";
    	Assert.assertTrue(FeaturesUtils.isTerm(FeaturesUtils.LOGIN, textWithLogin));
    	Assert.assertFalse(FeaturesUtils.isTerm(FeaturesUtils.LOGIN, textWithoutLogin));
    }
    
    @Test
    public void isBankTerm(){
    	String textWithBank = "Please, access to your bank website";
    	String textWithoutBank = "Just for testing purpose";
    	Assert.assertTrue(FeaturesUtils.isTerm(FeaturesUtils.BANK, textWithBank));
    	Assert.assertFalse(FeaturesUtils.isTerm(FeaturesUtils.BANK, textWithoutBank));
    }
	
    @Test
    public void isVerifyTerm(){
    	String textWithVerify = "Please verify your acces credentials";
    	String textWithoutVerify = "Just for testing purpose";
    	Assert.assertTrue(FeaturesUtils.isTerm(FeaturesUtils.VERIFY, textWithVerify));
    	Assert.assertFalse(FeaturesUtils.isTerm(FeaturesUtils.VERIFY, textWithoutVerify));
    }
	
    @Test
    public void isAgreeTerm(){
    	String textWithAgree = "Do you agree with the new condition terms?";
    	String textWithoutAgree = "Just for testing purpose";
    	Assert.assertTrue(FeaturesUtils.isTerm(FeaturesUtils.AGREE, textWithAgree));
    	Assert.assertFalse(FeaturesUtils.isTerm(FeaturesUtils.AGREE, textWithoutAgree));
    }
	
    @Test
    public void isSuspendTerm(){
    	String textWithSuspend = "Unfortunately we are going to suspend your account";
    	String textWithoutSuspend = "Just for testing purpose";
    	Assert.assertTrue(FeaturesUtils.isTerm(FeaturesUtils.SUSPEND, textWithSuspend));
    	Assert.assertFalse(FeaturesUtils.isTerm(FeaturesUtils.SUSPEND, textWithoutSuspend));
    }
    
    @Test
    public void numberOfIpsURLs(){
    	String text = "http://123.168.10.1/ \n" + 
    			"http://123.168.10.2/ \n" + 
    			"http://123.168.10.3/";
    	Assert.assertEquals(FeaturesUtils.numberOfIpUrls(text), 3);
    }
    
    @Test
    public void numberOfImagesAsURL(){
    	String text = "https://s1.pir.fm/pf/blog/articles/How-to-copy-a-web-page-link-or-URL-1800x980.png \n" + 
    			"http://s2.pir.fm/pf/blog/articles/How-to-copy-a-web-page-link-or-URL-1800x980.jpeg \n" + 
    			"http://s3.pir.fm/pf/blog/articles/How-to-copy-a-web-page-link-or-URL-1800x980.jpg \n" + 
    			"http://s4.pir.fm/pf/blog/articles/How-to-copy-a-web-page-link-or-URL-1800x980.pdf";
    	Assert.assertEquals(FeaturesUtils.numberOfImageAsURL(text), 3);
    }
    
    @Test
    public void matchDomainSender(){
    	String from = "Robert Elz <kre@munnari.OZ.AU>";
    	String messageId = "<13258.1030015585@munnari.OZ.AU>";
    	Assert.assertTrue(FeaturesUtils.matchDomainSender(from, messageId));
    	from = "Robert Elz <kre@munnari.ZZ.AU>";
    	Assert.assertFalse(FeaturesUtils.matchDomainSender(from, messageId));
    }

}
