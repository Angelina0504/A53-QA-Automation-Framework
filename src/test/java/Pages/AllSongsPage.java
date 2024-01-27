package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{
    //constructor
    public AllSongsPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //elements

    By firstSongInAllSongs = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playBtnInContextMeny = By.cssSelector("li.playback");


    //methods
    public WebElement firstSongInAllSongs() {
        return findElementUsingByLocator(firstSongInAllSongs);
    }
    public void contextClickFirstSong() {
            WebElement firstSongInTheList = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(firstSongInAllSongs));
            actions.contextClick(firstSongInTheList).perform();

    }

    public void choosePlayOption(){
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(playBtnInContextMeny))
                .click();
    }
}
