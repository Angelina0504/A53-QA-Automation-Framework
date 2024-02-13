import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest{
    String newPlaylistName = "Sample Edited Playlist";

    //Test starts here
    @Test
    public void playSongByContextClick() {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        chooseAllSongsList();
        contextClickFirstSong();
        choosePlayOption();
        //Assertions
        Assert.assertTrue(isSongPlaying());
    }

    @Test
    public void  hoverOverPlayBtn(){
        loginToKoelApp();
        hoverPlay().click();
        Assert.assertTrue(hoverPlay().isDisplayed());
    }
    //Test End here
    //------------------------------------------------------------------------------------------------
    //Create a test to hover over play button and click on play and verify that the song is being played.

    @Test
    public void countSongsInPlayList() {
        loginToKoelApp();
        choosePlaylistByName("Playlist to count songs");
        displayAllSongs();

        //Assertions
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }
    @Test
    public void renamePlaylist() {
        String updatePlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";
        loginToKoelApp();
        doubleClickPlaylist();
        enterNewPlaylistName();

        //Assertions
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatePlaylistMsg);
    }
    @Test
    public void addSongToPlaylist()  {
        String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        searchSong("memoria");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        //Assertion
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);

    }
    //Helper methods start here
    public void clickViewAllBtn(){
        WebElement viewAll = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[@data-test='view-all-songs-btn']")));
        //WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
    }

    public void searchSong(String songName)  {
        WebElement searchField = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("div#searchForm input[type='search']")));
        //WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(songName);
    }
    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    public void choosePlaylist(){
        WebElement playlist = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]")));
        //WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
        playlist.click();
    }
    public void clickAddToBtn()  {
        WebElement addToButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")));
        //WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();
        //Thread.sleep(2000);
    }

    public void selectFirstSongResult() {
        WebElement firstSong =  wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
        //WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
    }
    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
    public void contextClickFirstSong() {
        WebElement firstSongInTheList = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongInTheList).perform();
    }
    public void choosePlayOption() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//nav[@data-testid='song-context-menu']//ul//li[@class='playback']/span[1]")))
                .click();
    }
    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
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
    public void displayAllSongs()  {

        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found: " + countSongs());
        for (WebElement e : songList) {
            System.out.println(e.getText());
        }
    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector(".playlist:nth-child(9)")));
        actions.doubleClick(playlistElement).perform();
    }
    public void enterNewPlaylistName(){
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
    //Helper methods end here
}


