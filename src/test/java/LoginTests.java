import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    //LoginPage loginPage = new LoginPage(driver);
    //HomePage homePage = new HomePage(driver);
    @Parameters({"BaseUrl"})
    @Test(enabled = true, priority = 0, description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPassword(String BaseUrl) {

        navigateToPage(BaseUrl);
        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl); //https://qa.koel.app/
    }
    @Parameters({"BaseUrl"})
    @Test //(enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailPassword(String BaseUrl) throws InterruptedException {

        navigateToPage(BaseUrl);
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        //isAvatarDisplayed();
        //Assert.assertTrue(avatarIcon.isDisplayed());

    }
    @Parameters({"BaseUrl"})
    @Test(enabled = true, priority = 3, description = "Login with valid email and empty password")
    public void loginValidEmailEmptyPassword(String BaseUrl) {

        navigateToPage(BaseUrl);
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl); //https://qa.koel.app/
    }

    @Test
    public void loginWithCorrectEmailAndPassword()  {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("nataliya.yusupov@testpro.io");
        loginPage.providePassword("Ashatan5934$");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
    @Parameters({"BaseUrl"})
    @Test
    public void loginWithCorrectEmailAndIncorrectPassword()  {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("nataliya.yusupov@testpro.io");
        loginPage.providePassword("Ashatan5934$$");
        loginPage.clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void loginValidEmailAndPassword()  {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //loginPage.provideEmail("nataliya.yusupov@testpro.io");
        //loginPage.providePassword("Ashatan5934$");
        //loginPage.clickSubmit();
        loginPage.loginToKoelApp();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
    //Login tests using PageFactory and Fluent Interface-----------------------------------------------------------------


    @Test
    public void loginWithCorrectCredentialsUsingPageFactory(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmailToLogin("nataliya.yusupov@testpro.io");
        loginPage.providePasswordToLogin("Ashatan5934$");
        loginPage.clickSubmitButtonToLogin();
        //Assertions
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }


    @Test
    public void loginWithInValidEmailAndPassword()  {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("nataliya.yusupov@testpro.io1");
        loginPage.providePassword("Ashatan5934$1");
        loginPage.clickSubmit();
        //loginPage.loginToKoelApp();
        //Assert.assertEquals(loginPage.getCurrentUrl(), BaseUrl);
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

    @Parameters({"BaseUrl"})
    @Test
    public void loginValidGoodEmailPassword(String BaseUrl) throws InterruptedException {

        navigateToPage(BaseUrl);
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        WebElement avatarIcon =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
    @Parameters({"BaseUrl"})
    @Test
    public void loginValidCorrectEmailCorrectPassword(String BaseUrl) throws InterruptedException {

        navigateToPage(BaseUrl);
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
        WebElement avatarIcon =
                fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
    @Parameters({"BaseUrl"})
    @Test
    public void loginValidEmailNoPassword(String BaseUrl) throws InterruptedException{

        navigateToPage(BaseUrl);
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("");
        clickSubmit();
        Thread.sleep(4000);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl);

    }
    @Test(dataProvider = "InvalidLoginData")
    //@Parameters({"BaseUrl"})
    public void loginInvalidEmailAndValidPassword(String email, String password) throws InterruptedException{

        //navigateToPage(BaseUrl);
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        Thread.sleep(4000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
    @Test
    public void loginValidEmailValidPassword() {
      try {
          provideEmail("nataliya1.yusupov@testpro.io");
          providePassword("Ashatan5934$");
          clickSubmit();
          WebElement avatarIcon =
                  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
          Assert.assertTrue(avatarIcon.isDisplayed());
      }catch (Exception e){
          System.out.println("Something went wrong." +e);
      }
    }
    @Test
    public void loginInValidEmailValidPassword() {
        try {

            provideEmail("nataliya1.yusupov@testpro.io");
            providePassword("Ashatan5934$");
            clickSubmit();
            WebElement avatarIcon =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
            //Assert.assertTrue(avatarIcon.isDisplayed());
            if(!avatarIcon.isDisplayed()){
                Assert.fail("Avatar icon is not displayed.");
            }
            Assert.assertTrue(avatarIcon.isDisplayed());
            }catch (Exception e)
              {
            System.out.println("Something went wrong." + e);
            Assert.fail("Something went wrong." + e);
              }
    }
    



}