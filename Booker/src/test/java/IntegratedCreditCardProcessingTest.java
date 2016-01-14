import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by mdalam on 1/10/16.
 */

public class IntegratedCreditCardProcessingTest extends BookerBase {

    @Test
    public void processPayment() throws InterruptedException {
        clickByXpath(".//*[@id='navbar']/div[3]/div[2]/div/nav/div[1]/ul/li[1]/span");
        clickByXpath(".//*[@id='main-menu-dropdown-wrapper']/div[2]/div[3]/div/div[1]/div[2]/a");
        clickByXpath(".//*[@id='hero']/div/div/p[2]/a");
        typeByCss("#FirstName", "Test");
        typeByCss("#LastName", "Test");
        sleepfor(2);
        typeByCss("#Company", "Test");
        typeByCss("#Phone", "7180000000");
        typeByCss("#Email", "write.alam+" + randomNumber + "@gmail.com");
        typeByCss("#NumberOfEmployees", "10");
        typeByCss("#Locations__c", "10");
        selectByIdWithOption("Segment__c", "Auto Repair");
        clickByXpath(".//*[@id='mktoForm_1107']/div[35]/span/button");
        sleepfor(5);
        switchWindow();
        //String msg = getTextByXpath(".//*[@id='section-1']/div/div[1]/h1");
        Assert.assertEquals(getTitle(), "Thanks for Your Booker Sales Inquiry");

    }
}
