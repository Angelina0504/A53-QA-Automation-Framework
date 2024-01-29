import Pages.AllSongsPage;
import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork22A extends BaseTest{
    String newPlaylistName = "Sample Edited Playlist";

    //Test starts here
    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        BasePage basePage = new BasePage(driver);
        loginPage.login();

        homePage.goToAllSongsList();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlayOption();

        //Assertions
       // Assert.assertTrue(isSongPlaying());
        Assert.assertTrue(basePage.isSongPlaying());
    }
    /*@Test
    public void  hoverOverPlayBtn(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        loginPage.login();
        homePage.goToAllSongsList();
        homePage.hoverPlayBtn();*/


       /* //Assert.assertTrue(hoverPlay().isDisplayed());
        homePage.hoverPlay().click();
        Assert.assertTrue(homePage.isSongPlaying());
    }*/
    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
    public void contextClickFirstSong() {
        WebElement firstSongInTheList = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongInTheList).perform();
    }
    public void choosePlayOption(){
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
   /* public WebElement hoverPlay(){
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }*/

}
