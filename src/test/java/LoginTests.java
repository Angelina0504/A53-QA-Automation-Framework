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
    public void loginWithValidEmailPassword() throws InterruptedException{
       // try {
            //navigateToUrl();
            provideEmail("demo@class.com");
            providePassword("te$t$tudent");
            clickSubmit();
            //Thread.sleep(2000);

            //Assertion
            WebElement avatarIcon = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        //} catch (Exception e) {
           // System.out.println("Something went wrong." +e);
         // }
    }

    @Test(dataProvider = "InvalidLoginData")
    //@Parameters({"BaseUrl"})
    public void loginWithInvalidEmailValidPassword(String email, String password) throws InterruptedException {
        //navigateToUrl();
        provideEmail(email);
        providePassword(password);
        clickSubmit();

        //Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void loginWithValidEmailInvalidPassword() throws InterruptedException {
        //navigateToUrl();
        provideEmail("demo@class.com");
        providePassword("wrongPassword");
        clickSubmit();

        //Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

     /**
     * Test Script using Page Object Model
     * Locators used in these test, were located using By abstract class.
     * @author: Nataliya
     */
    @Test
    public void loginWithCorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //loginPage.login(); could do the same thing, as
        //  loginPage.provideEmail("demo@class.com");
        //        loginPage.providePassword("te$t$tudent");
        //        loginPage.clickSubmit();
        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
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

    /**
     *
     * Login using page Factory elements and Fluent interface
     */
    @Test
    public void loginWithCorrectCredentialsUsingPageFactory(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //Steps
        loginPage.provideEmailToLogin("demo@class.com")
                .providePasswordToLogin("te$t$tudent")
                .clickSubmitBtnToLogin();
        //Assertions
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }




}



