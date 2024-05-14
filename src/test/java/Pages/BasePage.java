package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    By soundBarVisualizer = By.cssSelector("[data-testid='sound-bar-play']");
    By hoverOverPlayResumeBtn = By.cssSelector("span[data-testid='play-btn']");
    By playResumeButton = By.cssSelector("span[data-testid='play-btn']");
    By choosePlaylist = By.xpath("//a[contains(text(),'+playlistName+')]");
    By displayAllCountSongs = By.cssSelector("section#playlistWrapper td.title");
    By playlistDetailsForCountingSongs = By.cssSelector("span.meta.text-secondary span.meta");
    By countSongsInPlaylist = By.cssSelector("section#playlistWrapper td.title");

//Create another constructor method for BaseClass
    //what ever driver we get we write here
    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    public WebElement findElementByLocator(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public boolean isSongPlaying(){
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated
                (soundBarVisualizer));
        return soundBar.isDisplayed();

    }
    public WebElement hoverPlay()throws InterruptedException{
        WebElement playBtn = driver.findElement(hoverOverPlayResumeBtn);
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }
    public boolean clickOnPlayOrResumeBtn()throws InterruptedException{
        WebElement playResumeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(playResumeButton));
        actions.contextClick(playResumeBtn).click().perform();
        return playResumeBtn.isDisplayed();
    }
    public void choosePlaylistByName(String playlistName)throws InterruptedException{
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(choosePlaylist));
        playlist.click();
        //a[class='active']
    }
    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(displayAllCountSongs);
        for (WebElement e : songList) {
            System.out.println(e.getText());

        }
    }
    public String getPlaylistDetails() {
        return driver.findElement(playlistDetailsForCountingSongs).getText();
    }
    public int countSongs(){
        return driver.findElements(countSongsInPlaylist).size();
    }


}
