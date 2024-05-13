package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    By soundBarVisualizer = By.cssSelector("[data-testid='sound-bar-play']");
    By hoverOverPlayResumeBtn = By.cssSelector("span[data-testid='play-btn']");
    By playResumeButton = By.cssSelector("span[data-testid='play-btn']");
//Create another constractor method for BaseClass
    //what ever driver we get we assing here
    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }
    public WebElement findElementByLocator(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public boolean isSongPlaying(){
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated
                (soundBarVisualizer));
        return soundBar.isDisplayed();

    }
    public WebElement hoverPlay()throws InterruptedException{
        WebElement playBtn = driver.findElement(hoverOverPlayResumeBtn);
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }
    public boolean clickOnPlayOrResumeBtn()throws InterruptedException{
        WebElement playResumeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(playResumeButton));
        actions.contextClick(playResumeBtn).click().perform();
        return playResumeBtn.isDisplayed();
    }


}
