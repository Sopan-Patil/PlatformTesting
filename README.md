# PlatformTesting

PlatformTesting project contains automation of Platform site. 

## Description
- PlatformTesting automation is beneficial in testing features by creating multiple users
- Different level of testing can be performed ex:smoke, P1 etc.
- Multiple test cases can be combined using cucumber tags
- Extent report helps in generating detailed reports.
- Log 4j is used for logging and daily reports are generated.
- Schedule test on remote Jenkins server
- Project is integrated with browserstack. TenstNG xml can be executed via command or jenkins to trigger browserstack test with desired capabilities.

## Tools
[Eclipse](https://www.eclipse.org/downloads/)\
[Selenium](https://www.selenium.dev/downloads/)\
[Apache Maven](https://maven.apache.org/download.cgi)\
[TestNG](https://testng.org/doc/download.html)\
[Cucumber](https://cucumber.io/docs/installation/)\
[Log4j2](https://logging.apache.org/log4j/2.x/download.html)\
[ExtentReports](https://www.extentreports.com/)

## Configuration

- Set browserstack credentials in data.properties file
- Set project related credentials in /platform/src/main/java/platform/properties/ConfigProp.java
- Use [Maven repository](https://mvnrepository.com/artifact/org.apache.maven.surefire/surefire-report-parser) to download dependancy in pom.xml 

## Usage

- Set properties from configuration
- Run testng.xml with command line or eclipse
- Run test runner as Junit or TestNG for testing individual scripts

### Usage for Common
- Add following depndacy in your project pom.xml
```
<dependency>
	<groupId>Platform</groupId>
	<artifactId>common</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<scope>compile</scope>
	<type>jar</type>
</dependency>
 ```
- All utilities can be accessed using CommonFuntions class
- Load pom.xml from Common in Build parameter of jenkin job    

