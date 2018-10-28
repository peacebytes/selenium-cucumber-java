## What is this?

This repository is an example of using selenium-cucumber-java to do automated functional test of web application.

	• Based on: selenium-cucumber-java
	• Website: automationpractice.com

## How do I get set up?

Google for:

*Install JVM*

*Setup Maven*

*Setup WebDrivers*

## How to deal with global variables?
Create new global variable in Hooks.java at `com.automation.stepDefinitions.Hooks`
Example:
```
    //Global variables
    public static WebDriver driver;
    public static String email;
    public static String password;
    public static String url;
    public static String browser;
    public static String env;
    public static Integer timeout;
```

Global variables to store test data generated during testing and can be shared within a test scenario. In step definition files, calling Hooks.{global_variable} directly to set or get value.

## How to deal with test data?
Test data is stored at `src\main\resources\TestData.json`. Test Data will be loaded in Hooks for each test scenario.

Usage in Step Definition:
- If test data is an array, call:
```
TestDataJSONReader.readJsonArray(keyValueInJson);
```
- If test data is an object, call:
```
TestDataJSONReader.readJsonObject(keyValueInJson);
```

## How to complie, clean up and test scripts
```
mvn clean install
```

## How to run only feature files that I am working on?
Run specific test features (default.browser=headless & default.env=local)
Put `@wip` on top of feature files, then:
```
mvn test -Dcucumber.options='--tags @wip'
```

## How to skip test features that I don't want to run
Put `@skip` on top of feature files, then:
```
mvn test
```

## More options to test on local?
Run Smoke Test
```
mvn test -Dcucumber.options='--features /features/Smoketest.feature'
```

Run All Test (default.browser=headless & default.env=local)
```
mvn test
```
Compile code without execute test
```
mvn clean install -DskipTests=true
```
Execute test against specific browser and env
```
mvn test -Dtarget.browser=chrome -Dtarget.env=local
```

## How do I execute test on Browserstack?

Test on IE
```
mvn test -Dtarget.env=bs -Dtarget.browser=ie
```

Test on Edge
```
mvn test -Dtarget.env=bs -Dtarget.browser=edge
```

Test on Chrome
```
mvn test -Dtarget.env=bs -Dtarget.browser=chrome
```

Test on Firefox
```
mvn test -Dtarget.env=bs -Dtarget.browser=chrome
```
* Note: All test on Browserstack will be done on Windows 10.

## Ref:
```
https://github.com/cigohere
https://github.com/machzqcq
```
