import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    
    @Test (enabled = true, priority = 0, description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPassword(){

        navigateToPage();
        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }

    @Test //(enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailPassword()throws InterruptedException{

        navigateToPage();
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        isAvatarDisplayed();
    }

    @Test (enabled = true, priority = 3, description = "Login with valid email and empty password")
    public void loginValidEmailEmptyPassword() {

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }
    @Test
    public void loginWithCorrectEmailAndPassword(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("nataliya.yusupov@testpro.io");
        loginPage.providePassword("Ashatan5934$");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.clickOnAvatar().isDisplayed());
    }


}