# Email Features Extractor 

This program is used to extract a list of attributes from email collection. This extracted features can be used in Machine Learning model builds. The collections directory includes two different collections of emails, one classified as ham and another one classified as phishing.

## Features descriptions

| Feature Name | Description |
|---|---|
| htmlBody | Checks if the email body contains HTML content |
| scriptTag | Checks if the email body contains javascript script tag |
| hexadecimalURLs | The number of URLs consisting of hexadecimal characters in the email |
| domainsCount | The number of domains in the URLs that exists in the email |
| dotsCount | The maximum number of dots that exist in a URL in the email |
| isAccountTerm | Checks if the email contains the term “Account” |
| isDearTeam | Checks if the email contains the term “Dear” |
| imagesAsURL | The number of image URLs |
| ipUrls | The number of URLs whose domain is specified as an IP address |
| isPayPalTerm | Checks if the email contains the term “PayPal” |
| isLoginTerm | Checks if the email contains the term “Login” |
| isBankTerm | Checks if the email contains the term “Bank” |
| isVerifyTerm | Checks if the email contains the term “Verify” |
| isAgreeTerm |Checks if the email contains the term “Agree” |
| isSuspendTerm | Checks if the email contains the term “Suspend” |
| domainSender | Checks if sender domain is the same as message-id domain |
| phishingTermsWeight |A weight that is assigned to each email and represents the sum of weights of the phishing terms that exists in that email|
| isPhishing | Label the email as phishing or ham |

## Getting Started

### Requirements
This program is built with Java 8. You can check your version of Java by entering the following command in a terminal window: 
```sh
java -version
```

### Configure collection and output folders
It is possible to configure and change the email collections directories and the folder where we want to create the output file. Just change the paths in *config.properties* file:  
* phishing.email.collection.path
* ham.email.collection.path
* output.directory
When these files are modified .jar file must be generated again.

### Build Jar file
```sh
mvn package
```

### Run Email Features Extractor
```sh
java -jar features-extractor-0.0.1.jar
```