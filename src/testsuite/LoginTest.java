package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
@Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
    //  Enter “tomsmith” username
    sendTextToElement(By.name("username"), "tomsmith");
    //* Enter “admin123“ password
    sendTextToElement(By.name("password"), "SuperSecretPassword!");
// Click on ‘LOGIN’ button
    clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
    //Verify the
    String expectedMessage = "Secure Area";
    String actualMessage = getTextFromElement(By.xpath("//h2[text()=' Secure Area']"));
    Assert.assertEquals("No Secure Area", expectedMessage, actualMessage);
}

    @Test
            public void  verifyThePasswordErrorMessage(){
        //Enter “tomsmith” username
        sendTextToElement(By.name("username"), "tomsmith");
        //* Enter “admin123“ password
        sendTextToElement(By.name("password"), "SuperSecretPassword");
// Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        //Verify the error message “Your password is invalid!”
        String expectedMessage = "Your password is invalid!\n"+"×";
        String actualMessage = getTextFromElement(By.xpath("//div[@id=\"flash\"]"));
        Assert.assertEquals("Your password is invalid",expectedMessage,actualMessage);
    }
    @After
                    public void tearDown(){
                closeBrowser();
    }

}