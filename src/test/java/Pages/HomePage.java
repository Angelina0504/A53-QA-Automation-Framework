package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    //Element locators using Page Factory
    @FindBy(css = "li a.songs")
    WebElement songsList;

    //Page Locators/Page Elements
    By userAvatarIcon = By.cssSelector("img.avatar");
    By allSongsList = By.cssSelector("li a.songs");
    //Home Page methods using Selenium Page Factory
    public void clickOnSongsList(){
        songsList.click();
        //return this;
    }


    //Page Methods
    public WebElement getUserAvatarIcon(){
        return findElementUsingByLocator(userAvatarIcon);
    }
    public WebElement allSongsList(){
        return findElementUsingByLocator(allSongsList);
    }

}
