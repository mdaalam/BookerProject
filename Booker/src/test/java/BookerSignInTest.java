import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by mdalam on 1/9/16.
 */
public class BookerSignInTest extends BookerBase{

    @Test
    public void loginTest() throws IOException,InterruptedException {
        LoginPage lgPage = PageFactory.initElements(driver, LoginPage.class);
        log.info("Trying to login on booker");
        lgPage.login("TestAccountName", "TestUserName", "TestPassword");
        sleepfor(2);
        Assert.assertEquals(getTitle(), "Welcome to User's homepage!");
        log.info("Successfully loged in on Booker!");
    }
}
