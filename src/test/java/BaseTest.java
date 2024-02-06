import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    //Data Providers
    @DataProvider(name="InvalidLoginData")
    public Object[][] getDataFromDataProviders(){
        return new Object[][]{
                {"invalid@mail.com", "wrongPassword"},
                {"demo@class.com", ""},
                {"", "te$t$tudent"},
                {"",""}
        };
    }
    public WebDriver driver;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public WebDriverWait wait;
    public Actions actions;
    public Wait<WebDriver> fluentWait;

    public String url = "https://qa.koel.app/";


    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) throws MalformedURLException {

        //chrome Options
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        //driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        //driver = new EdgeDriver();
        //Implicit Wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Explicit Wait
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        //Fluent Wait
        fluentWait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
                //.ignoring(NoAlertPresentException.class);
        actions = new Actions(getDriver());
        //driver.manage().window().maximize();
        //String url = BaseUrl;
        //navigate to Ur

        navigateToUrl(BaseUrl);
    }
    //initiation method
    public static WebDriver getDriver(){
        return threadDriver.get();
    }
    @AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }
   /* @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
*/

    void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type = 'email']")));
        //WebElement emailField = driver.findElement(By.cssSelector("input[type = 'email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type = 'password']")));
        //WebElement passwordField = driver.findElement(By.cssSelector ("input[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type = 'submit']")));
       // WebElement submitButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        submitButton.click();
    }

    //Helper Method
    public void navigateToUrl(String givenUrl){
        getDriver().get(givenUrl);
    }
    public void loginToKoelApp(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }
    //create a new method for new WebBrowser
    //this method returns WebDriver,the driver
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.0.0.197:4444/";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver();

            case "grid-edge": // gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox": // gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome": // gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();

//        ChromeOptions browserOptions = new ChromeOptions();
//        browserOptions.setPlatformName("macOS Sonoma");
//        browserOptions.setBrowserVersion("120.0");
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "120.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "nyusupov");
        ltOptions.put("accessKey", "4QB8r26uX0ZbeWKVaT6ilRu2k1dgknKiEXDZu350WmuUOGpis3");
        ltOptions.put("geoLocation", "AM");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("resolution", "2560x1440");
        ltOptions.put("timezone", "Denver");
        ltOptions.put("build", "Build #1");
        ltOptions.put("project", "NY");
        ltOptions.put("name", "DemoClass");
        ltOptions.put("selenium_version", "4.5.0");
        ltOptions.put("driver_version", "122.0");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        //browserOptions.setCapability("LT:Options", ltOptions);
        capabilities.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), capabilities);

    }

}