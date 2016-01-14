import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by mdalam on 1/9/16.
 */
public class LikeBookerOnFacebookTest extends BookerBase{

    @Test
    public void likeBookerTest() throws InterruptedException {
        log.info("Trying to like Booker on facebook");
        clickByXpath(".//*[@id='navbar']/div[3]/div[2]/div/nav/div[1]/ul/li[5]/a");
        clickByXpath(".//*[@id='collection-items']/ul/li[1]/a[1]");
        sleepfor(3);
        clickByXpath(".//*[@id='block-block-44']/div/a[4]/img");
        sleepfor(3);
        switchWindow();
        logInFacebook();
        sleepfor(3);
        clickByXpath(".//*[@id='u_0_2f']");
        Assert.assertEquals(getTitle(), "Booker");
        log.info("Successfully pressed on like button on Booker facebook");
        //Assert.assertTrue(getTitle().contains("Bookerr"));
        //log.info(getTitle());
        //log.info(getTextByXpath(".//*[@id='u_jsonp_5_1m']"));
    }
}
