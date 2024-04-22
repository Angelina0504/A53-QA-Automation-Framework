import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver = null;
    public String url = "https://qa.koel.app/";
    public String urlProfile = "https://qa.koel.app/#!/profile";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void launchBrowser() {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    public void navigateToPage() {
        driver.get(url);
    }
    public void navigateToProfilePage(){
        driver.get(urlProfile);
    }
    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
    public void clickOnAvatar() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }
    public void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }
    public void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }
    public void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    public void isAvatarDisplayed() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    public void clickOnHomePage(){
        WebElement homePage = driver.findElement(By.cssSelector("[class='home']"));
        homePage.click();
    }

    public void isNewNameDisplayedCorrectly() {
        WebElement newName = driver.findElement(By.cssSelector("span[class='name']"));
}

    public String generateRandomEmail() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void provideNewEmail(String randomEmail) {
        WebElement profileEmailField = driver.findElement(By.cssSelector("input[id='inputProfileEmail']"));
        profileEmailField.clear();
        profileEmailField.sendKeys(randomEmail);
    }
    public void provideProfileNewEmail(String emailField) {
        WebElement profileEmailField = driver.findElement(By.cssSelector("input[id='inputProfileEmail']"));
        profileEmailField.clear();
        profileEmailField.sendKeys(emailField);
    }

    public String getProfileUpdatedSuccessMsg(){
        WebElement notificationMsgEmailUpdated = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsgEmailUpdated.getText();
    }

    public void clickOnShowNowPlayingCheckBox(){
        WebElement checkBox = driver.findElement(By.cssSelector("input[name='notify']"));
        checkBox.click();
    }

    public void clickOnAllSongs(){
        WebElement allSongs = driver.findElement(By.cssSelector("[class='songs']"));
        allSongs.click();
    }

    public void provideProfileNewPassword(String newPassword){
        WebElement provideNewPassword = driver.findElement(By.cssSelector("input[name='new_password']"));
        provideNewPassword.clear();
        provideNewPassword.sendKeys(newPassword);
    }

    //public void doubleClickOnSong(){
        //WebElement clickSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
   // clickSong.click();
    //}
    public void clickPlayBtn(){
        WebElement playNextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playBtn = driver.findElement(By.cssSelector("span[class='play']"));
        //xpath("//span[@data-testid='play-btn']"));   both works
        playNextBtn.click();
        playBtn.click();
    }

    public void clickOnLogoutBtn(){
        WebElement confirmBox = driver.findElement(By.cssSelector("[data-testid='btn-logout']"));
        confirmBox.click();
    }

    public void clickOnConfirmBeforeClosingApp(){
        WebElement confirmBox = driver.findElement(By.cssSelector("input[name='confirm_closing']"));
        confirmBox.click();
    }

    public void clickOnExtraTabAlbumButton(){
        WebElement extraAlbum = driver.findElement(By.cssSelector("button[id='extraTabAlbum']"));
        extraAlbum.click();
    }

    public void clickOnOverlayCheckBox(){
        WebElement overlayBox = driver.findElement(By.cssSelector("input[name='show_album_art_overlay']"));
        overlayBox.click();
    }
}
