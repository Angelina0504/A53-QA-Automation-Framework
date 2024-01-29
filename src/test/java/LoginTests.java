import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Parameters({"BaseUrl"})
    @Test
    public void navigateToKoelApp(String BaseUrl) {
        navigateToUrl(BaseUrl);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl);
        driver.quit();
    }

    @Test
    public void loginWithValidEmailPassword() {

            provideEmail("demo@class.com");
            providePassword("te$t$tudent");
            clickSubmit();

            //Assertion
            WebElement avatarIcon = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));

            Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test(dataProvider = "InvalidLoginData")
    //@Parameters({"BaseUrl"})
    public void loginWithInvalidEmailValidPassword(String email, String password)  {
        //navigateToUrl();
        provideEmail(email);
        providePassword(password);
        clickSubmit();


        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void loginWithValidEmailInvalidPassword()  {
        //navigateToUrl();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo3@class.com");
        loginPage.providePassword("te$t3$tudent");
        loginPage.clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

     /**
     * Test Script using Page Object Model
     * Locators used in these test, were located using By abstract class.
     //* @author: Nataliya
     */
    @Test
    public void loginWithCorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo3@class.com");
        loginPage.providePassword("te$t3$tudent");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
     }
    @Test
    public void loginWithInCorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo3@class.com");
        loginPage.providePassword("te$t3$tudent");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
    //login using Page Factory elements and Fluent Interface
    @Test
    public void loginWithCorrectCredentialsUsingPageFactory(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmailToLogin("demo@class.com");
        loginPage.providePasswordToLogin("te$t$tudent");
        loginPage.clickSubmitBtnToLogin();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());

    }
}



