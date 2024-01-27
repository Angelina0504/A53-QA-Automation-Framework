package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Page Locators/Page Elements
     By userAvatarIcon = By.cssSelector("img.avatar");
     By clickPlaylist = By.cssSelector(".playlist:nth-child(9)");
     By firstPlaylistName = By.cssSelector("[name='name']");
     By notification = By.cssSelector("div.success.show");

    //Page Methods
    public WebElement getUserAvatarIcon(){
        return findElementUsingByLocator(userAvatarIcon);
    }
    public WebElement allSongsList(){
        return findElementUsingByLocator(allSongsList);
    }
    public WebElement clickPlaylist(){
        return findElementUsingByLocator(clickPlaylist);
    }
    public WebElement firstPlaylistName(){
        return findElementUsingByLocator(firstPlaylistName);
    }
    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(clickPlaylist));
        actions.doubleClick(playlistElement).perform();


    }
    public void enterNewPlaylistName(String newPlaylistName){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(firstPlaylistName));

        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notificationMsg =  wait.until(ExpectedConditions.visibilityOfElementLocated(notification));
        return notificationMsg.getText();
    }
}
