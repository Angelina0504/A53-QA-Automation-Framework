import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17 extends BaseTest{

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
}
