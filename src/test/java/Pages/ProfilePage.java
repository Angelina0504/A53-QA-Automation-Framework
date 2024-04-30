package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver givenDriver){
        super(givenDriver);
    }
    //Locators
    By currentPassword = By.cssSelector("[name='current_password']");
    By saveButton = By.cssSelector("button.btn-submit");
    By profileName = By.cssSelector("[name='name']");
    By homePage = By.cssSelector("[class='home']");

    //Methods
    public void provideCurrentPassword(String password){
        findElementByLocator(currentPassword).sendKeys(password);
    }
    public void clickSaveButton() {
        findElementByLocator(saveButton).click();
    }
    public void provideProfileName(String randomName){
        findElementByLocator(profileName).sendKeys(randomName);
    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    public void clickOnHomePage(){
        findElementByLocator(homePage).click();
    }

}
