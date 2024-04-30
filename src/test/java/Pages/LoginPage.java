package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    //Element Locators
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submit = By.cssSelector("button[type='submit']");

    public void provideEmail(String email){
        findElementByLocator(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElementByLocator(passwordField).sendKeys(password);
    }

    public void clickSubmit(){
        findElementByLocator(submit).click();
    }
    public void loginToKoelApp(){
        provideEmail("nataliya.yusupov@testpro.io");
        providePassword("Ashatan5934$");
        clickSubmit();
    }
}
