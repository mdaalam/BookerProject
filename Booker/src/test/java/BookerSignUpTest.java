import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by mdalam on 1/9/16.
 */
public class BookerSignUpTest extends BookerBase{

    @Test
    public void loginTest() throws IOException,InterruptedException {
        SignUpPage lgPage = PageFactory.initElements(driver, SignUpPage.class);
        log.info("Trying to sign up on Booker");
        lgPage.signUp("Support", "TestFirstName", "TestLastName", "TestCompany", "7180000000", "write.alam@gmail.com");
        sleepfor(2);
        Assert.assertEquals(getTitle(), "Thanks for Contacting the Booker Support Team");
        log.info("Successfully signed up on Booker");
    }
}