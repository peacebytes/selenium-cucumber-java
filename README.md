# Welcome to Selenium Java

This repository is an example of using Selenium Java to do automated functional test of web application. Test executions can be done on local browsers, on Selenium Grid or on BrowserStack.

	• Website for testing: http://automationpractice.com

Documentation can be found at `/docs':
- How to set up Report Portal on local running on Docker container
- How to set up Selenium Grid with Docker containers
- How to set up env for this starter-kit project
- How assertion is done in this project
- How to use global variables

## Install dependencies

Install dependencies and skip testing:
```
mvn clean install -DskipTests=true
```

## Quick compile & test
Default caps for the test will be decided by properties file `src/main/resources/Config.properties`
```
mvn clean install
```

## Execute tests in parallel in Selenium Grid

Start selenium grid on local:
```
cd src/main/resources/docker-selenium-grid
```
To have 4 instances of chrome headless, we have to start 2 chrome nodes (each has 2 instance as set up in docker-compose.yml), the command will be like:
```
docker-compose up -d --scale chrome=2
```

Check `pom.xml` > `<id>parallel</id>`, > `<forkCount>4</forkCount>`. By default, I set it to 4 for the purpose of demostration.

Compile code without execute test
```
cd ~/selenium-cucumber-java
mvn clean install -DskipTests=true
```

Run test in parallel
```
cd ~/selenium-cucumber-java
mvn test -Dcucumber.options='--tags @demo' -Pparallel
```

Notes: Selenium Grid in this repo just only supports headless mode.
## Execute tests on local

Running test on local with real browser mode so you can see really what your tests are like.
See `docs/Set-up-env.md` for details on set up local web drivers for Chrome and Firefox.

Compile code without execute test
```
mvn clean install -DskipTests=true
```

Run Smoke Test
```
mvn test -Dcucumber.options='--tags @Smoke'
```

Run All Test (default.browser=chrome & default.env=local)
```
mvn test
```

Execute test against specific browser (Firefox) and env
```
mvn test -Dtarget.browser=firefox -Dtarget.env=local
```

Run specific test features (default.browser=chrome & default.env=local)
Put `@wip` on top of feature files, then:
```
mvn test -Dcucumber.options='--tags @wip'
```

Put `@skip` on top of feature files, then:
```
mvn test
```

## Execute test on Browserstack?

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

## Report Portal integration

All test reports will be published in real-time to report portal.
How to set up Report Portal can be found here: https://automationbytes.me/how-to-setup-report-portal

Report Portal configuration will be kept at:
```
src/test/resources/reportportal.properties
```

Enabling StepReporter:
```
// file: src/test/java/com/automation/RunCukesTest.java
@RunWith(Cucumber.class)
@CucumberOptions(
plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter"}
)
public class RunCukesTest {
}
```

Enabling ScenarioReporter:
```
// file: src/test/java/com/automation/RunCukesTest.java
@RunWith(Cucumber.class)
@CucumberOptions(
plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"}
)
public class RunCukesTest {
}
```