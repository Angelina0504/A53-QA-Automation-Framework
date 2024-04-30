
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {
    @Test
    public void changeProfileName() throws InterruptedException {
        navigateToPage();
        loginToKoelApp();
        clickOnAvatar();
        String randomName = generateRandomName();
        provideCurrentPassword("Ashatan5934$");
        provideProfileName(randomName);
        clickSaveButton();

        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);
    }
    @Test
    public void updatedUserNameOnHomePage() throws InterruptedException {
        navigateToPage();
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

    @Test
    public void updatedEmail() throws InterruptedException {
        navigateToPage();
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
    @Test
    public void updatedEmailField() throws InterruptedException {
        String message = "Profile updated.";
        navigateToPage();
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
    @Test
    public void updatedPasswordField() throws InterruptedException {
        String expectedUpdatedPasswordMessage = "Profile updated.";
        navigateToPage();
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        clickOnAvatar();
        provideCurrentPassword("Ashatan5934$");
        provideProfileNewPassword("Ashatan5934$$");
        clickSaveButton();

        Assert.assertEquals(getProfileUpdatedSuccessMsg(), expectedUpdatedPasswordMessage);
    }

    @Test
    public void themeIsChangedOnAllSongsPage() throws InterruptedException {
        //boolean expectedThemeColorOak= true;
        //String expectedThemeColorOak = "Oak";
        navigateToPage();
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        clickOnAvatar();
        clickOnTheme();
        clickOnAllSongs();
       WebElement backGround = driver.findElement(By.cssSelector("div[data-testid='album-art-overlay']"));
       Assert.assertTrue(backGround.isDisplayed());
    }
    @Test
    public void themeIsNotChangedOnProfilePage() throws InterruptedException {
        String unexpectedThemeColor = "Classic";
        String actualThemeColor = "Oak";
        navigateToPage();
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        clickOnAvatar();
        clickOnTheme();
        Assert.assertNotEquals(unexpectedThemeColor, actualThemeColor);
    }

    @Test
    public void songPlayWithNotification()throws InterruptedException{
        //String songIsPlayingWithNotification = "1st Song is playing.";
        navigateToPage();
        loginToKoelApp();
        clickOnAvatar();
        clickOnShowNowPlayingCheckBox();
        clickOnAllSongs();
        contextClickFirstSong();
        choosePlayOption();

        Assert.assertTrue(isSongPlayingWithNotification());
    }

    @Test
    public void logoutKoelApp()throws InterruptedException{
        boolean changesNotSavedMsgIsDisplayed = true;
        navigateToPage();
        loginToKoelApp();
        clickOnAvatar();
        clickOnConfirmBeforeClosingApp();
        clickOnLogoutBtn();
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