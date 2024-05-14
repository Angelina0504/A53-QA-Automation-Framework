package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Page locators
    By userAvatarIcon = By.cssSelector("img.avatar");


    By allSongs = By.cssSelector("li a.songs");
    //Page methods
    public WebElement getUserAvatarIcon(){
        return findElementByLocator(userAvatarIcon);
    }
    public WebElement clickOnAllSongs(){
        return findElementByLocator(allSongs);
    }
    public void goToAllSongsList(){
        findElementByLocator(allSongs).click();
    }
}

