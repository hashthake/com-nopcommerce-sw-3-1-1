package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UtilityTest extends BaseTest {

    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    public void verifyText(By by, String expectedText){
        String actualText = getTextFromElement(by);
        Assert.assertEquals(actualText,expectedText);
    }
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);

    }
}
