## What is this?

This repository is an example of using selenium-cucumber-java to do automated functional test of web application.

	• Based on: selenium-cucumber-java - web application BDD test
	• Website: automationpractice.com

## How do I get set up?

**Install JVM**
**Setup Maven**
**Setup WebDrivers**

## How do I execute test?

1. Run All Test (default.browser=chrome & default.env=local)
```
mvn clean install
```
2. Compile code without execute test
```
mvn clean install -DskipTests=true
```
3. Run specific test features (default.browser=chrome & default.env=local)
Put `@wip` on top of feature file, then:
```
mvn test -Dcucumber.options='--tags @wip'
```
4. Execute test against specific browser and env
```
mvn test -Dtarget.browser=firefox -Dtarget.env=local
```
