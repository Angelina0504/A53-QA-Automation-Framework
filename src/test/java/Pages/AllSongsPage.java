package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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

    public void choosePlayOption() {
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(playBtnInContextMeny))
                .click();
    }
    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public WebElement hoverPlay(){
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }

    public void choosePlaylistByName(String playlistName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                xpath("//a[contains(text(),'"+playlistName+"')]"))).click();
    }
    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }
    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }
    public void displayAllSongs() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found: " + countSongs());
        for (WebElement e : songList) {
            System.out.println(e.getText());
        }
    }
}
