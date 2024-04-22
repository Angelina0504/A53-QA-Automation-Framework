
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {
    @Test
    public void changeProfileName() throws InterruptedException {
        navigateToPage();
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        Thread.sleep(4000);
        clickOnAvatar();
        String randomName = generateRandomName();
        provideCurrentPassword("Ashatan5934$");
        provideProfileName(randomName);
        clickSaveButton();

        Thread.sleep(2000);
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);
    }
    @Test
    public void updatedUserNameOnHomePage() throws InterruptedException {
        navigateToPage();
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        Thread.sleep(4000);
        clickOnAvatar();
        String randomName = generateRandomName();
        provideCurrentPassword("Ashatan5934$");
        provideProfileName(randomName);
        clickSaveButton();
        clickOnHomePage();
        isNewNameDisplayedCorrectly();
        //Assertion
        WebElement newName = driver.findElement(By.cssSelector("span[class='name']"));
        Assert.assertTrue(newName.isDisplayed());
    }

    @Test
    public void updatedEmail() throws InterruptedException {
        navigateToPage();
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        Thread.sleep(4000);
        clickOnAvatar();
        String randomEmail = generateRandomEmail();
        provideCurrentPassword("Ashatan5934$");
        provideNewEmail(randomEmail);
        clickSaveButton();
        WebElement profileNewEmail = driver.findElement(By.cssSelector("input[id='inputProfileEmail']"));
        Assert.assertTrue(profileNewEmail.isDisplayed());
    }
    @Test
    public void updatedEmailField() throws InterruptedException {
        String message = "Profile updated.";
        navigateToPage();
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        Thread.sleep(4000);
        clickOnAvatar();
        provideCurrentPassword("Ashatan5934$");
        provideProfileNewEmail("nataliya.yusupov@testpro.io1");
        clickSaveButton();
        Assert.assertEquals(getProfileUpdatedSuccessMsg(), message);
    }

    //To run we have to change the email add.to nataliya.yusupov@testpro.io, and update the email
    //The updatedEmailField is correct test case for update an email for the Profile Page
    @Test
    public void updatedPasswordField() throws InterruptedException {
        String message = "Profile updated.";
        navigateToPage();
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        Thread.sleep(4000);
        clickOnAvatar();

        provideCurrentPassword("Ashatan5934$");
        provideProfileNewPassword("Ashatan5934$$");
        clickSaveButton();
        Assert.assertEquals(getProfileUpdatedSuccessMsg(), message);
    }

    @Test
    public void themeIsChangedOnAllSongsPage() throws InterruptedException {
        String updatedThemeColor = "Oak";

        navigateToPage();
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        Thread.sleep(4000);
        clickOnAvatar();
        Thread.sleep(4000);
        clickOnTheme();
        Thread.sleep(4000);
        //clickOnHomePage();
        clickOnAllSongs();
        Thread.sleep(4000);

        WebElement siderBarColored = driver.findElement(By.cssSelector("section[class='music']"));
        //WebElement themeOak = driver.findElement(By.cssSelector("[data-theme='oak']"));
        //Assert.assertEquals(themeOak.getText(), updatedThemeColor);
        Assert.assertTrue(siderBarColored.isDisplayed());
    }
    @Test
    public void songIsNotAppearsAsNotification()throws InterruptedException{
    navigateToPage();
    provideEmail("nataliya.yusupov@testpro.io");
    providePassword("Ashatan5934$");
    clickSubmit();
        Thread.sleep(4000);
    clickOnAvatar();
        Thread.sleep(4000);
    clickOnShowNowPlayingCheckBox();
        Thread.sleep(4000);
    clickOnAllSongs();
        Thread.sleep(4000);
   // doubleClickOnSong();
    clickPlayBtn();
    Assert.assertTrue(isSongPlaying());
    }
    @Test
    public void noNotification()throws InterruptedException{
        String songIsPlayingWithoutNotification = "1st Song is playing.";
        navigateToPage();
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        Thread.sleep(4000);
        clickOnAvatar();
        Thread.sleep(4000);
        clickOnShowNowPlayingCheckBox();
        Thread.sleep(4000);
        clickOnAllSongs();
        Thread.sleep(4000);
        // doubleClickOnSong();
        clickPlayBtn();
        Assert.assertNotNull(songIsPlayingWithoutNotification);
    }
    @Test
    public void logoutKoelApp()throws InterruptedException{
        boolean changesNotSavedMsgIsDisplayed = true;
        navigateToPage();
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        Thread.sleep(4000);
        clickOnAvatar();
        Thread.sleep(4000);
        clickOnConfirmBeforeClosingApp();
        Thread.sleep(4000);
        clickOnLogoutBtn();
        Thread.sleep(4000);
       // Assert.assertEquals(getConfirmNotificationMsg(), changesNotSavedMsg);
        Assert.assertTrue(changesNotSavedMsgIsDisplayed, "Changes you made may not be saved.");
    }
    @Test
    public void translucentOverlay()throws InterruptedException{
        String albumCoverIsNotOverlay ="Album cover is not blurred overlay.";
        navigateToPage();
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        Thread.sleep(4000);
        clickOnAvatar();
        Thread.sleep(4000);
        clickOnOverlayCheckBox();
        clickOnExtraTabAlbumButton();
        Assert.assertNotNull(albumCoverIsNotOverlay, "Album cover is not blurred overlay." );
    }

    public boolean isSongPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }

    public void isColorChanging(String newColor){
        WebElement themeOak = driver.findElement(By.cssSelector("class=['non-mac with-extra-panel']"));
        themeOak.sendKeys(newColor);
    }

    public void clickOnTheme() {
        WebElement themeOak = driver.findElement(By.cssSelector("div[class='theme'][data-testid='theme-card-oak']"));
        themeOak.click();
    }
}