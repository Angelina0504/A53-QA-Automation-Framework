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
    By allSongsList = By.cssSelector("li a.songs");
    //By hoverPlay = By.cssSelector("[data-testid='sound-bar-play']");

    //Page Methods
    public WebElement getUserAvatarIcon(){
        return findElementUsingByLocator(userAvatarIcon);
    }
    public WebElement allSongsList(){
        return findElementUsingByLocator(allSongsList);
    }
    //public void goToAllSongsList(){
        //findElementUsingByLocator(allSongsList).click();
    //}
    //public void hoverPlayBtn(){
       /* findElementUsingByLocator(hoverPlay).click();
    }
    public WebElement hoverPlay(){
        WebElement playBtn = driver.findElement(hoverPlay);
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }*/
    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();

    }
    public void enterNewPlaylistName(String newPlaylistName){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector("[name='name']")));

        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notificationMsg =  wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector("div.success.show")));
        return notificationMsg.getText();
    }
}
