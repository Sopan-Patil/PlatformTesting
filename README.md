# PlatformTesting

PlatformTesting project contains automation of Platform site. 

## Description
PlatformTesting automation is beneficial in testing features for multiple users, performing different level of testing ex:smoke, P1 etc., combining multiple test cases and generating detailed reports.\
Moreover this projct is used to schedule test on remote Jenkins server for our global team.\
Project is also integrated with browserstack. TenstNG xml can be executed via command or jenkins to trigger browserstack test with desired capabilities.

## Tools
[Eclipse](https://www.eclipse.org/downloads/)\
[Selenium](https://www.selenium.dev/downloads/)\
[Apache Maven](https://maven.apache.org/download.cgi)\
[TestNG](https://testng.org/doc/download.html)\
[Cucumber](https://cucumber.io/docs/installation/)\
[Log4j2](https://logging.apache.org/log4j/2.x/download.html)\
[ExtentReports](https://www.extentreports.com/)

## Configuration

Set browserstack credentials in data.properties file\
Set project related credentials in /platform/src/main/java/platform/properties/ConfigProp.java\
Use [Maven repository](https://mvnrepository.com/artifact/org.apache.maven.surefire/surefire-report-parser) to download dependancy i pom.xml 
