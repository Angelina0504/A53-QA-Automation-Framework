import Pages.AllSongsPage;
import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork23D extends BaseTest{
        String newPlaylistName = "Sample Edited Playlist";

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


}
