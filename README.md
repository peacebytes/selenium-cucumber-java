## What is this?

This repository is an example of using selenium-cucumber-java to do automated functional test of web application.

	• Based on: selenium-cucumber-java
	• Website: automationpractice.com

## How do I get set up?

*Install JVM, Maven*
See google :)

*Setup WebDrivers*

Download Chrome driver http://chromedriver.chromium.org/downloads & Firefox driver https://github.com/mozilla/geckodriver/releases

Put them in `/home/{your_user_name_here}/Downloads/browserdrivers`

If you are running console terminal in ubuntu 18, update ~/.profile:
```
vim ~/.profile
```

Adding these lines:
```
BROWSER_DRIVERS="/home/{your_user_name_here}/Downloads/browserdrivers";
PATH="$BROWSER_DRIVERS:$PATH";
```

For the changes to take effect, restart your computer or source your .profile file using the following command:
```
source ~/.profile
```

## How to run test in parallel in Selenium Grid

Start selenium grid on local:
```
cd src/main/resources/docker-selenium-grid
```
To have 4 instances of chrome headless, we have to start 2 chrome nodes (each has 2 instance as set up in docker-compose.yml), the command will be like:
```
docker-compose up -d --scale chrome=2
```

Check `pom.xml` > `<id>parallel</id>`, > `<forkCount>4</forkCount>`. By default, I set it to 4 for the purpose of demostration.

Build test first:
```
mvn clean install -DskipTests=true
```
Then run test in parallel
```
mvn test -Dcucumber.options='--tags @demo' -Pparallel
```

## How to test on local?

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

## How to view report?
Report can be found at `/target/cucumber/cucumber.html/index.html`

## How report will look like in parallel tests?

[Report Portal](https://reportportal.io/) integration will be our best bet. To be updated with integration of report portal to this Selenium Java framework.

How to set up Report Portal can be found here: https://automationbytes.me/how-to-setup-report-portal

More documentation at : `/docs`
