import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AllSongsTest extends BaseTest{
    String newPlaylistName = "Sample Edited Playlist";
    @Test
     public void playSongByContextClick()throws InterruptedException{
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        clickOnAllSongs();
        contextClickFirstSong();
        choosePlayOption();

        Assert.assertTrue(isSongPlaying());

     }
     @Test
    public void clickOnExtraTabAlbum()throws InterruptedException{
         provideEmail("nataliya.yusupov@testpro.io");
         providePassword("Ashatan5934$");
         clickSubmit();
         clickOnAllSongs();
         contextClickFirstSong();
         chooseGoToAlbum();

      Assert.assertTrue(extraTabAlbumIsDisplayed());
     }
     @Test
     public void hoverOverPlayBtn()throws InterruptedException{
         loginToKoelApp();
         Thread.sleep(4000);
         //Assertion
        // WebElement playBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-testid='play-btn']")));
         Assert.assertTrue(hoverPlay().isDisplayed());
         /////////////////////////////////////////////Test case, when only return an element
     }
     @Test
     public void hoverAndPlaySong() throws InterruptedException{

         provideEmail("nataliya.yusupov@testpro.io");
         providePassword("Ashatan5934$");
         clickSubmit();
         Thread.sleep(4000);
         hoverPlay();
         Thread.sleep(4000);

         Assert.assertTrue(clickOnPlayOrResumeBtn());
     }
     @Test
     public void countSongsInPlaylist()throws InterruptedException{
        loginToKoelApp();
         //Thread.sleep(4000);
        choosePlaylistByName("Playlist to count songs");
        Thread.sleep(4000);
        //countSongs();
        displayAllSongs();

        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
     }
     @Test
     public void renamePlaylist()throws InterruptedException{
        String updatedPlaylistMsg ="Updated playlist \"Sample Edited Playlist.\"";
         loginToKoelApp();
         Thread.sleep(4000);
         doubleClickPlaylist();
         Thread.sleep(4000);
         enterNewPlaylistName();
         Thread.sleep(4000);
         //Assertions
         Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);

     }

     //------------------------------------------------------------------------------
    public void doubleClickPlaylist()throws InterruptedException{
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(5)")));
        actions.doubleClick(playlistElement).perform();
    }
    public void enterNewPlaylistName()throws InterruptedException{
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));

        //clear does not work since element as an attribute of required
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);

    }
    public String getRenamePlaylistSuccessMsg()throws InterruptedException{
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }
    public void choosePlaylistByName(String playlistName)throws InterruptedException{
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"')]")));
        playlist.click();
        //a[class='active']
    }
    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }
    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
    public void displayAllSongs(){
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found:" +countSongs());
          for(WebElement e : songList){
              System.out.println(e.getText());
          }
    }
     public void chooseGoToAlbum()throws InterruptedException{
         wait.until(ExpectedConditions.visibilityOfElementLocated
                 (By.xpath("//nav[@data-testid='song-context-menu']//ul//li[@class='go-to-album']")));
     }
     public boolean extraTabAlbumIsDisplayed() throws InterruptedException{
         WebElement extraTab = wait.until(ExpectedConditions.visibilityOfElementLocated
                 (By.cssSelector("button[id='extraTabAlbum']")));
         return extraTab.isDisplayed();
     }
     public WebElement hoverPlay()throws InterruptedException{
         WebElement playBtn = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
         actions.moveToElement(playBtn).perform();
         return wait.until(ExpectedConditions.visibilityOf(playBtn));
     }

     public boolean clickOnPlayOrResumeBtn()throws InterruptedException{
        WebElement playResumeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-testid='play-btn']")));
        actions.contextClick(playResumeBtn).click().perform();
        return playResumeBtn.isDisplayed();
     }
}
