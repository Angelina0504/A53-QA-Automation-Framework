import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.UUID;

public class BaseTest {
    @DataProvider(name="InvalidLoginData")
    public Object[][] getDataFomDataProvider(){
        return new Object[][]{
                {"invalid@mail.com", "invalidPassword"},
                {"nataliya.yusupov@testpro.io", ""},
                {"", "Ashatan5934$"},
                {"", ""},
        };
    }
    public WebDriver driver;
    public WebDriverWait wait;
    public Wait<WebDriver>fluentWait;

    public String url = "https://qa.koel.app/";
    public Actions actions;
    public String urlProfile = "https://qa.koel.app/#!/profile";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @Parameters({"BaseUrl"})
    @BeforeMethod
    public void launchBrowser(String BaseUrl) {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        //Implicit wait, no condition
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Explicit wait, conditions and amount of time
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Fluent Wait, how frequently we need to check, and amount of time
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
                //.ignoring(NoAlertPresentException.class);
        actions = new Actions(driver);
        driver.manage().window().maximize();
        //String url = BaseUrl;
        navigateToPage(BaseUrl);
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    public void navigateToPage(String givenUrl) {
        driver.get(givenUrl);
    }
    //public void navigateToProfilePage(){
        //driver.get(urlProfile);
    //}
    public void provideEmail(String email) {
        WebElement emailField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        WebElement passwordField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement submit =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
    }
    public void clickOnAvatar() {
        WebElement avatarIcon =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        avatarIcon.click();
    }
    public void provideCurrentPassword(String password) {
        WebElement currentPassword =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }
    public void clickSaveButton() {
        WebElement saveButton =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }
    public void provideProfileName(String randomName) {
        WebElement profileName =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        profileName.clear();
        profileName.sendKeys(randomName);
    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    public void isAvatarDisplayed() {
        WebElement avatarIcon =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    public void clickOnHomePage(){
        WebElement homePage =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='home']")));
        homePage.click();
    }

    public void isNewNameDisplayedCorrectly() {
        WebElement newName =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='name']")));
}

    public String generateRandomEmail() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void provideNewEmail(String randomEmail) {
        WebElement profileEmailField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='inputProfileEmail']")));
        profileEmailField.clear();
        profileEmailField.sendKeys(randomEmail);
    }
    public void provideProfileNewEmail(String emailField) {
        WebElement profileEmailField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='inputProfileEmail']")));
        profileEmailField.clear();
        profileEmailField.sendKeys(emailField);
    }

    public String getProfileUpdatedSuccessMsg(){
        WebElement notificationMsgEmailUpdated =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsgEmailUpdated.getText();
    }

    public void clickOnShowNowPlayingCheckBox(){
        WebElement checkBox =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='notify']")));
        checkBox.click();
    }

    public void clickOnAllSongs(){
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='songs']"))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
    public void provideProfileNewPassword(String newPassword){
        WebElement provideNewPassword =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='new_password']")));
        provideNewPassword.clear();
        provideNewPassword.sendKeys(newPassword);
    }

    public void clickPlayBtn(){
        WebElement playNextBtn =
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//i[@data-testid='play-next-btn']")));
        WebElement playBtn =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='play-btn']")));
                        //By.cssSelector("span[class='play']")));
        //xpath("//span[@data-testid='play-btn']"));   both works
        playNextBtn.click();
        playBtn.click();
    }

    public void clickOnLogoutBtn(){
        WebElement confirmBox =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='btn-logout']")));
        confirmBox.click();
    }

    public void clickOnConfirmBeforeClosingApp(){
        WebElement confirmBox =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='confirm_closing']")));
        confirmBox.click();
    }

    public void clickOnExtraTabAlbumButton(){
        WebElement extraAlbum =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='extraTabAlbum']")));
        extraAlbum.click();
    }

    public void clickOnOverlayCheckBox(){
        WebElement overlayBox =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='show_album_art_overlay']")));
        overlayBox.click();
    }
    public void actualThemeColorOak(){
        WebElement actualThemeColor =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='theme-card-oak']")));
    }

    public void unexpectedThemeColorClassic(){
        WebElement unexpectedThemeColor =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='theme-card-classic']")));
    }
    public void contextClickFirstSong()throws InterruptedException{
        WebElement firstSongInTheList =
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongInTheList).perform();
    }
    public void choosePlayOption()throws InterruptedException {
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("li.playback"))).click();
                        //(By.xpath("//nav[@data-testid='song-context-menu']//ul//li[@class='playback']/span[1]")))
                        //.click();
        //"//nav[@data-testid='song-context-menu']/ul//li[@class='playback']"
        //"//nav[@class='menu song-menu']/ul//li[@class='playback']
    }
    public boolean isSongPlayingWithNotification(){
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@data-testid='sound-bar-play']")));
        return soundBar.isDisplayed();
        // By.cssSelector"[data-testid='sound-bar-play']"

    }
    public boolean isSongPlaying(){
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBar.isDisplayed();
        // By.cssSelector"[data-testid='sound-bar-play']"

    }
    public void loginToKoelApp(){
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
    }

}
