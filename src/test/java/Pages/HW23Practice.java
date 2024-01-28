package Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW23Practice extends BasePage {
    public HW23Practice(WebDriver givenDriver) {
        super(givenDriver);
    }

    @Test
    public void renamePlaylist() {
        String newPlaylistName = "Test Pro Edited Playlist";
        String updatedPlaylistMsg = "Updated playlist \"Test Pro Edited Playlist.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        //Assertions
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }

    @Test
    public void playSongByRightClick() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongPage = new AllSongsPage(driver);
        BasePage basePage = new BasePage(driver);
        //login
        loginPage.login();
        homePage.goToAllSongsList();
        //homePage.allSongsList();
        allSongPage.contextClickFirstSong();
        allSongPage.choosePlayOption();
        //Assertions
        Assert.assertTrue(basePage.isSongPlaying());
    }

}
