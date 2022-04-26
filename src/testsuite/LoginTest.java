package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.UtilityTest;

public class LoginTest extends UtilityTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Click on login button should move to login page
        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
        //Validate actual and expected message
        verifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

    }

    @Test
    public void userShouldLoginWithValidCredentials() {
        //Click on login button should move to login page
        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));

        //find element for mail field and send data
        sendTextToElement(By.id("Email"), "123@gmail.com");

        //find element for password field and send data
        sendTextToElement(By.name("Password"), "ABC1234");

        //click on LOGIN button
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        //Validate text
        verifyText(By.xpath("//a[contains(text(),'Log out')]"), "Log out");

    }

    @Test
    public void verifyTheErrorMessage() {
        //Click on login button should move to login page
        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
        //find element for mail field and send data
        //find element for mail field and send data
        sendTextToElement(By.id("Email"), "123@gmail.com");

        //find element for password field and send data
        sendTextToElement(By.name("Password"), "ABC1234");

        //click on LOGIN button
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        //Validate message
        verifyText(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]\n"), "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


