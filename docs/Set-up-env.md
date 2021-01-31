# How do I get set up

### Install JVM*
You might need an Oracle account to download a jdk.
See google :)

### Install Maven
For Mac, you can do
```
brew install maven
```

### Setup WebDrivers

This is for running tests on local. 

Download Chrome driver http://chromedriver.chromium.org/downloads 
Firefox driver https://github.com/mozilla/geckodriver/releases

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

In Mac (my case is Catalina 10.15.x), you might need to create `~/.zshrc` instead of `~/.profile`.

In Windows, Open the Start Search, type in "env", and choose "Edit the system environment variables". Go to Advanced tab and then click on "Environment Variables"