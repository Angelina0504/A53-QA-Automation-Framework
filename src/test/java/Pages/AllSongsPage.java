package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver){
        super(givenDriver);
    }

    By firstSongInAllSongs = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playBtnInContextMenu = By.cssSelector("li.playback");
    By goToAlbum = By.xpath("//nav[@data-testid='song-context-menu']//ul//li[@class='go-to-album']");
    By extraTabMenu = By.cssSelector("button[id='extraTabAlbum']");
    By soundBar = By.cssSelector("[data-testid='sound-bar-play']");
    public boolean isSongPlaying(){
       return findElementByLocator(soundBar).isDisplayed();
       // return soundBar.isDisplayed();
    }
   public WebElement firstSongInAllSongs(){
        return findElementByLocator(firstSongInAllSongs);
   }
    public void contextClickFirstSong()throws InterruptedException{
        WebElement firstSongInTheList =
                wait.until(ExpectedConditions.visibilityOfElementLocated(firstSongInAllSongs));
        actions.contextClick(firstSongInTheList).perform();

    }
    public void choosePlayOption()throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (playBtnInContextMenu)).click();
    }
    public void chooseGoToAlbum()throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(goToAlbum)).click();
    }
    public boolean extraTabAlbumIsDisplayed() throws InterruptedException {
        WebElement extraTab = wait.until(ExpectedConditions.visibilityOfElementLocated
                (extraTabMenu));
        return extraTab.isDisplayed();
    }
}
