import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by mdalam on 1/10/16.
 */

public class LoginPage{

    @FindBy(how = How.XPATH, using = ".//*[@id='navbar']/div[3]/div[2]/div/nav/div[2]/ul/li[7]/a")
    public static WebElement logIn;

    @FindBy(how = How.CSS, using = "#txtAccountName")
    public static WebElement accountName;

    @FindBy(how = How.CSS, using = "#txtUsername")
    public static WebElement userName;

    @FindBy(how = How.CSS, using = "#txtPassword")
    public static WebElement password;

    @FindBy (how = How.CSS, using = "#btnSubmit")
    public static WebElement loginSubmit ;

    public void enterAccountName(String item){
        accountName.sendKeys(item, Keys.ENTER);
    }
    public void enterUserName(String item){
        userName.sendKeys(item, Keys.ENTER);
    }
    public void enterPassword(String item){
        password.sendKeys(item, Keys.ENTER);
    }

    public void login(String initAccountName, String initUserName, String initPassword){
        logIn.click();
        this.enterAccountName(initAccountName);
        this.enterUserName(initUserName);
        this.enterPassword(initPassword);
        loginSubmit.click();
    }
}
