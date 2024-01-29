package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static final int TIME = 6;
    protected WebDriver driver;

    protected WebDriverWait wait;
    protected Actions actions;

    private By soundVisualiser = By.cssSelector("[data-testid='sound-bar-play']");
    private By allSongsList = By.cssSelector("li a.songs");

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    public WebElement findElementUsingByLocator(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(soundVisualiser));
        return soundBarVisualizer.isDisplayed();
    }
    public void goToAllSongsList(){
        findElementUsingByLocator(allSongsList).click();
    }
    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();

    }
    public void enterNewPlaylistName(String newPlaylistName){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector("[name='name']")));

        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notificationMsg =  wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector("div.success.show")));
        return notificationMsg.getText();
    }
}
