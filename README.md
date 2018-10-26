## What is this?

This repository is an example of using selenium-cucumber-java to do automated functional test of web application.

	• Based on: selenium-cucumber-java
	• Website: automationpractice.com

## How do I get set up?

Google for:

*Install JVM*

*Setup Maven*

*Setup WebDrivers*

## How to run test features that I am working on?
Run specific test features (default.browser=chrome & default.env=local)
Put `@wip` on top of feature files, then:
```
mvn test -Dcucumber.options='--tags @wip'
```

## How to skip test features that I don't want to run
Put `@skip` on top of feature files, then:
```
mvn test
```

## How do I execute test on local?
Run Smoke Test
```
mvn test -Dcucumber.options='--features /features/Smoketest.feature'
```

Run All Test (default.browser=headless & default.env=local)
```
mvn clean install
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

## Ref sources:
```
https://github.com/cigohere
https://github.com/machzqcq
```
