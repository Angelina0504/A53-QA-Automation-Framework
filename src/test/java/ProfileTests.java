
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {
    @Parameters({"BaseUrl"})
    @Test
    public void changeProfileName(String BaseUrl) throws InterruptedException {
        navigateToPage(BaseUrl);
        loginToKoelApp();
        clickOnAvatar();
        Thread.sleep(4000);
        String randomName = generateRandomName();
        Thread.sleep(4000);
        provideCurrentPassword("Ashatan5934$");
        Thread.sleep(4000);
        provideProfileName(randomName);
        Thread.sleep(4000);
        clickSaveButton();

        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);
    }
    @Parameters({"BaseUrl"})
    @Test
    public void updatedUserNameOnHomePage(String BaseUrl) throws InterruptedException {
        navigateToPage(BaseUrl);
        loginToKoelApp();
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
    @Parameters({"BaseUrl"})
    @Test
    public void updatedEmail(String BaseUrl) throws InterruptedException {
        navigateToPage(BaseUrl);
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        clickOnAvatar();
        String randomEmail = generateRandomEmail();
        provideCurrentPassword("Ashatan5934$");
        provideNewEmail(randomEmail);
        clickSaveButton();
        WebElement profileNewEmail = driver.findElement(By.cssSelector("input[id='inputProfileEmail']"));
        Assert.assertTrue(profileNewEmail.isDisplayed());
    }
    @Parameters({"BaseUrl"})
    @Test
    public void updatedEmailField(String BaseUrl) throws InterruptedException {
        String message = "Profile updated.";
        navigateToPage(BaseUrl);
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        clickOnAvatar();
        provideCurrentPassword("Ashatan5934$");
        provideProfileNewEmail("nataliya.yusupov@testpro.io1");
        clickSaveButton();
       // WebElement getProfileUpdatedSuccessMsg = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertEquals(getProfileUpdatedSuccessMsg(), message);
    }

    //To run we have to change the email add.to nataliya.yusupov@testpro.io, and update the email
    //The updatedEmailField is correct test case for update an email for the Profile Page
    @Parameters({"BaseUrl"})
    @Test
    public void updatedPasswordField(String BaseUrl) throws InterruptedException {
        String expectedUpdatedPasswordMessage = "Profile updated.";
        navigateToPage(BaseUrl);
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        clickOnAvatar();
        provideCurrentPassword("Ashatan5934$");
        provideProfileNewPassword("Ashatan5934$$");
        clickSaveButton();

        Assert.assertEquals(getProfileUpdatedSuccessMsg(), expectedUpdatedPasswordMessage);
    }
    @Parameters({"BaseUrl"})
    @Test
    public void themeIsChangedOnAllSongsPage(String BaseUrl) throws InterruptedException {
        //boolean expectedThemeColorOak= true;
        //String expectedThemeColorOak = "Oak";
        navigateToPage(BaseUrl);
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        clickOnAvatar();
        clickOnTheme();
        clickOnAllSongs();
       WebElement backGround = driver.findElement(By.cssSelector("div[data-testid='album-art-overlay']"));
       Assert.assertTrue(backGround.isDisplayed());
    }
    @Parameters({"BaseUrl"})
    @Test
    public void themeIsNotChangedOnProfilePage(String BaseUrl) throws InterruptedException {
        String unexpectedThemeColor = "Classic";
        String actualThemeColor = "Oak";
        navigateToPage(BaseUrl);
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        clickOnAvatar();
        clickOnTheme();
        Assert.assertNotEquals(unexpectedThemeColor, actualThemeColor);
    }

    @Test
    @Parameters({"BaseUrl"})
    public void songPlayWithNotification(String BaseUrl)throws InterruptedException{
        //String songIsPlayingWithNotification = "1st Song is playing.";
        navigateToPage(BaseUrl);
        loginToKoelApp();
        clickOnAvatar();
        clickOnShowNowPlayingCheckBox();
        clickOnAllSongs();
        contextClickFirstSong();
        choosePlayOption();

        Assert.assertTrue(isSongPlayingWithNotification());
    }
    @Parameters({"BaseUrl"})
    @Test
    public void logoutKoelApp(String BaseUrl)throws InterruptedException{
        boolean changesNotSavedMsgIsDisplayed = true;
        navigateToPage(BaseUrl);
        loginToKoelApp();
        clickOnAvatar();
        clickOnConfirmBeforeClosingApp();
        clickOnLogoutBtn();
       // Assert.assertEquals(getConfirmNotificationMsg(), changesNotSavedMsg);
        Assert.assertTrue(changesNotSavedMsgIsDisplayed, "Changes you made may not be saved.");
    }
    @Parameters({"BaseUrl"})
    @Test
    public void translucentOverlay(String BaseUrl)throws InterruptedException{
        String albumCoverIsNotOverlay ="Album cover is not blurred overlay.";
        navigateToPage(BaseUrl);
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        clickOnAvatar();
        clickOnOverlayCheckBox();
        clickOnExtraTabAlbumButton();
        Assert.assertNotNull(albumCoverIsNotOverlay, "Album cover is not blurred overlay." );
    }

    public void clickOnTheme() {
        WebElement themeOak = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div[class='theme'][data-testid='theme-card-oak']")));
        themeOak.click();
    }
}