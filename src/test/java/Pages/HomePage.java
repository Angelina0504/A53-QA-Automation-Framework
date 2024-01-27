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

    @FindBy (css = ".playlist:nth-child(9)")
    WebElement doubleClickPlaylist;

    @FindBy (css = ".playlist:nth-child(9)")
    WebElement newPlaylistName;

    @FindBy (css = "div.success.show")
    WebElement renamePlaylist;

    //Page Locators/Page Elements
     By userAvatarIcon = By.cssSelector("img.avatar");
<<<<<<< Updated upstream
     By clickPlaylist = By.cssSelector(".playlist:nth-child(9)");
     By firstPlaylistName = By.cssSelector("[name='name']");
     By notification = By.cssSelector("div.success.show");
=======

     By doubleClickOnPlaylist = By.cssSelector(".playlist:nth-child(9)");
     By newName = By.cssSelector("[name='name']");
     By renameNewPlaylist = By.cssSelector("div.success.show");
>>>>>>> Stashed changes

     // page methods using Selenium page factory



    //Page Methods using POM
    public WebElement getUserAvatarIcon(){
        return findElementUsingByLocator(userAvatarIcon);
    }
    public WebElement allSongsList(){
        return findElementUsingByLocator(allSongsList);
    }
<<<<<<< Updated upstream
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
=======
    public WebElement DoubleClickOnPlaylist(){
        findElementUsingByLocator(doubleClickOnPlaylist).click();
    }
    public WebElement newName(String name){
        findElementUsingByLocator(newName).sendKeys(name);
>>>>>>> Stashed changes
    }
    public WebElement renameNewPlaylist(){
        findElementUsingByLocator(renameNewPlaylist).click();



    //public String getRenamePlaylistSuccessMsg(){
      //  WebElement notificationMsg =  wait.until(ExpectedConditions.visibilityOfElementLocated(By
      //          .cssSelector("div.success.show")));
       // return notificationMsg.getText();
    //}

<<<<<<< Updated upstream
    public String getRenamePlaylistSuccessMsg(){
        WebElement notificationMsg =  wait.until(ExpectedConditions.visibilityOfElementLocated(notification));
        return notificationMsg.getText();
    }
=======
>>>>>>> Stashed changes
}
