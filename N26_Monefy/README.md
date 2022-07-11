# N26_Monefy

###### An Automation framework using Java, Appium and TestNG.

## Project Description

###### This project has implemented Page Object Model pattern with TestNG and Appium for few basic transactional scenarios on Monefy app.

### The Project was developed using:

1. **TestNG** : `7.6.0` - latest version
2. **Selenium** : `4.2.1` - latest version
3. **JavaClient** : `8.1.1` - latest version
4. **Appium Desktop Client** : `1.22.3`
5. **Apache POI** : `5.2.2` - latest version
6. **Log4j** : `2.17.2` - latest version
7. **slf4j** : `1.7.36` - latest version
8. **Extent Reports** : `5.0.9` - latest version

## Design:

### Page Object Model Pattern using PageFactory:

* Page Object Model is a design pattern that creates Object Repository for web UI elements. It reduces code duplication and improves test maintenance.
* Page Object classes can be found in `src/main/java/com/automation/demo/pages` package.
* Page Object manager can be found in `src/main/java/com/automation/demo/managers` package.

### Tests:

* Automation Test cases can be found at `src/test/java/com/automation/demo/tests`
* This test launches Chrome browser, opens the provided test url, applies relevant filters and fetches search result and validates the result for applied filters.

### Project Structure:

* `src/main/java/com/automation/demo/pages` - contains java code for Page Factory implementation
* `src/main/java/com/automation/demo/managers` - contains java code for Page Object Manager implementation
* `src/test/java/com/automation/demo/tests` - contains automation test code with TestNG tests implementation
* `src/main/resources` - contains properties files
* `src/test/resources` - contains `monefy.apk` and config files for logger
* `./runner.xml` - XML file to configure and run the tests as per user's preference
* `test-output` folder contains the HTML test run results and logs


### Prerequisites to Run the project:

* Environment Requirements: Maven v3.5.4 or later, Java 11 or later, Eclipse or IntelliJ IDE
* JDK can be configured in pom.xml
* Appium must be configured

### Execution Instructions:

* Clone/Importing the project
* Compile using the IDE Maven plugin or mvn clean compile.
* Once all maven dependencies have been downloaded, run the `/runner.xml`
* The tests should run and test results are generated as HTML reports and Logs in `/test-output`