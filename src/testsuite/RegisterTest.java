package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.UtilityTest;

public class RegisterTest extends UtilityTest {

    //base Url
    String baseUrl = "https://demo.nopcommerce.com/";


    @Before
    public void setupIt() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){

        //Find registration tab on the homepage and click it
        clickOnElement(By.linkText("Register"));

        //Verify the text ‘Register’
        verifyText(By.xpath("//h1[contains(text(),'Register')]"), "Register");

    }

    @Test
    public void userSholdRegisterAccountSuccessfully(){

        //Find registration tab on the homepage and click it
        clickOnElement(By.linkText("Register"));

        //Select gender radio button
        clickOnElement(By.id("gender-male"));

        //Enter First name
        sendTextToElement(By.id("FirstName"), "Harry");

        //Enter Last name
        sendTextToElement(By.id("LastName"), "Thaker");

        //Select Day Month and Year Syntax - Select select = new Select (WebElement)

//        Select birthDay = new Select(By.name("DateOfBirthDay"));
        selectByVisibleTextFromDropDown(By.name("DateOfBirthDay"),"08");

        //select Month
        selectByVisibleTextFromDropDown(By.name("DateOfBirthMonth"),"February");

        //select Year
        selectByVisibleTextFromDropDown(By.name("DateOfBirthYear"), "1982");

        //Enter Email address
        sendTextToElement(By.id("Email"), "hvthaker@gmail.com");

        //Enter Password
        sendTextToElement(By.id("Password"), "Ahmedabad21");

        //Enter Confirm password
        sendTextToElement(By.id("ConfirmPassword"), "Ahmedabad21");

        //Click on REGISTER button
        clickOnElement(By.id("register-button"));

        //Verify the text 'Your registration completed
        verifyText(By.xpath("//div[contains(text(),'Your registration completed')]"), "register-button");

        String expectedMessage = "Your registration completed";
        WebElement actualMessageElement = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

        //click continue button
        WebElement continueBtn = driver.findElement(By.xpath("/a[contains(text(),'Continue')]"));
        continueBtn.click();

    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}

