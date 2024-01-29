package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver){
        super(givenDriver);}
    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    WebElement firstSong;

    @FindBy(css = "li.playback")
    WebElement firstPlayOption;
    //elements
    By firstSongInAllSongs = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playBtnInContextMenu = By.cssSelector("li.playback");

    //AllSongs methods using Selenium Page Factory
    public void clickOnFirstSong(){
        firstSong.click();
        //return this;
    }
    public void clickOnPlayOption(){
        firstPlayOption.click();
        //return this;
    }
    //methods
    public WebElement firstSongInAllSongs() {
        return findElementUsingByLocator(firstSongInAllSongs);
    }
    public void contextClickFirstSong(){
        WebElement firstSongInTheList = wait.until(ExpectedConditions
                .visibilityOfElementLocated(firstSongInAllSongs));
        actions.contextClick(firstSongInTheList).perform();
    }
    public void choosePlayOption(){
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(playBtnInContextMenu))
                .click();
    }
    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }


}
