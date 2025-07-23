## QA Automation Project

This project contains automated tests for the Bakeronline application.

### Installation and Execution

1. Clone this repository to your local machine.
2. Open the project in IntelliJ or any IDE that supports Maven.
3. Maven will automatically download and install the project dependencies listed in the `pom.xml` file. The other option is to manually trigger the Maven build using the IDE or by running the following command in the project directory:
   `mvn clean install`
4. Execute tests by running the `CukesRunner` class or use the following command:
`mvn test`

### Test Framework and Tools

This is a BDD Cucumber Automation Framework developed in Java 17 using Selenium, Maven and JUnit. It allows functional testing of the Bakeronline application from the end user's perspective by implementing Cucumber's Gherkin language for writing test scenarios.

### Key Features

- Implementation of the Page Object Model (POM) for better web element management and maintenance
- Utilization of the Singleton Design Pattern to maintain a single instance of the WebDriver for smooth test execution
- Test data management using `configuration.properties` file for easy configuration changes
- Creation of the `ConfigurationReader` utility class to read data from `configuration.properties` file
- Use of the BDD approach with Gherkin language for clear communication
- Custom Cucumber runners to execute different test suites based on pre-defined tags
- HTML reporting
- Automatic screenshot capture and attachment to the report on scenario failure
- Implementation of utility methods stored in the utilities package for code reusability
- Hooks class for managing WebDriver sessions and automatic cleanup after each test case execution

### Folder Structure

The project follows the following folder structure:

```plaintext
src
├── test
│   ├── java
│   │   ├── com
│   │   │   ├── baker_online
│   │   │   │   ├── pages
│   │   │   │   │   └── PageObjectClasses.java
│   │   │   │   ├── runners
│   │   │   │   │   └── CukesRunner.java
|   |   |   |   |   └── FailedTestRunner.java
│   │   │   │   ├── step_definitions
│   │   │   │   │   └── StepDefinitionClasses.java
│   │   │   │   └── utilities
│   │   │   │       └── ConfigurationReader.java
|   |   |   |       └── Driver.java
|   |   |   |       └── BrowserUtils.java
|   |   |   |       └── MailSlurpUtils.java
│   └── resources
│       ├── features
│       │   └── FeatureFiles.feature
├── pom.xml
├── configuration.properties
└── README.md
```

### Test Data

Test data for account creation is received through `Faker` class to get the dynamic results each time when running the tests.
For the login, the data is stored in the `configuration.properties` file and can be changed from the outside of the code in order to run the tests set against different test data. 

The framework allows executing automated tests against Chrome and Firefox browser, by changing the browser type in the `configuration.properties` file.


### Known Issues and Limitations

- Limitation: Since the requirements documentation for the application are not available, the success/error messages that have to be displayed are only assumed based on the current app behavior in order to complete the testing task.

### Reporting

Test reports will be generated in the `target` folder after test execution.









