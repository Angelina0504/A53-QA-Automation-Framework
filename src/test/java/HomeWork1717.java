import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class HomeWork1717 extends BaseTest{
    @Test
    public void changeProfilePassword() throws InterruptedException {
        String expectedPasswordUpdatedMessage = "Profile updated";
        //Login
        //provide email
        provideEmail("demo@class.com");
        //provide password
        providePassword("te$t$tudent");
        //click submit
        clickSubmit();
        //navigate to profile page
        clickOnAvatar();
        // provide current password
        provideCurrentPassword("te$t$tudent");
        //provide new password
        String randomNewPassword=generateRandomPassword();
        provideNewPassword("te$t$tudent1");
        //click save button
        clickSave();
        //Assertion
        Assert.assertEquals(getUpdatedPasswordSuccessMsg(), expectedPasswordUpdatedMessage);
    }
    public String generateRandomPassword(){
        return UUID.randomUUID().toString().replace("te$t$tudent", "te$t$tudent1");
    }
    public String getUpdatedPasswordSuccessMsg(){
      WebElement notificationPassword= driver.findElement(By.cssSelector("div.success.show"));
      return notificationPassword.getText();
    }
    public void clickOnAvatar(){
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        avatarIcon.click();
    }
    public void provideCurrentPassword(String password){
        WebElement currentPasswordField = driver.findElement(By.cssSelector("name = 'current_password']"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
    }
    public void provideNewPassword(String newPassword) {
        WebElement profilePasswordField = driver.findElement(By.cssSelector("input[id='inputProfileNewPassword']"));
        profilePasswordField.sendKeys(newPassword);
    }
    public void clickSave(){
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

}
