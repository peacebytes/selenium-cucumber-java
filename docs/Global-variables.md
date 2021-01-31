# How to deal with global variables?

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
