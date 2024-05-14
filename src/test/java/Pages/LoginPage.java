package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Elements Locators using PageFactory
    @FindBy(css = "[type='email']")
    WebElement emailTextField;
    @FindBy(css = "[type='password']")
    WebElement passwordTextField;
    @FindBy(css = "[type='submit']")
    WebElement loginButton;


    //Element Locators using PageObjectModel POM
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submit = By.cssSelector("button[type='submit']");
    //Page methods using  Selenium PageFactory

    public void provideEmailToLogin(String email){
        emailTextField.sendKeys(email);
        //return this;
    }
    public void providePasswordToLogin(String password){
        passwordTextField.sendKeys(password);
        //return this;
    }
    public void clickSubmitButtonToLogin(){
        loginButton.click();
        //return this;
    }


    //page methods using POM
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
