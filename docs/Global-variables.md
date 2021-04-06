# How to deal with global variables?

Create new global variable in Hooks.java at `src/main/java/com/automation/env/Global.java`
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

Global variables to store test data generated during testing and can be shared within a test scenario. In step definition files, calling Global.{global_variable} directly to set or get value.
