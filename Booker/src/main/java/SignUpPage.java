import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by mdalam on 1/11/16.
 */
public class SignUpPage {
    @FindBy(how = How.XPATH, using = ".//*[@id='navbar']/div[3]/div[2]/div/nav/div[2]/ul/li[7]/a")
    public static WebElement logIn;

    @FindBy(how = How.XPATH, using = ".//*[@id='no_account']/p[2]/a")
    public static WebElement signUp;

    @FindBy(how = How.CSS, using = "#FirstName")
    public static WebElement firstName;

    @FindBy(how = How.CSS, using = "#LastName")
    public static WebElement lastName;

    @FindBy(how = How.CSS, using = "#Company")
    public static WebElement businessName;

    @FindBy (how = How.CSS, using = "#Phone")
    public static WebElement phoneNumber ;

    @FindBy (how = How.CSS, using = "#Email")
    public static WebElement emailAddress ;

    @FindBy (how = How.CSS, using = ".btn.btn-blue")
    public static WebElement contactUs ;

    @FindBy (how = How.ID, using = "Contact_Us_Department__c")
    public static WebElement department ;


    public void enterFirstName(String fName){
        firstName.sendKeys(fName, Keys.ENTER);
    }

    public void enterLastName(String lName){
        lastName.sendKeys(lName, Keys.ENTER);
    }

    public void enterBusinessName(String company){
        businessName.sendKeys(company, Keys.ENTER);
    }

    public void enterPhoneNumber(String pNumber) {
        phoneNumber.sendKeys(pNumber, Keys.ENTER);
    }

    public void enterEmail(String eAddress){
        emailAddress.sendKeys(eAddress, Keys.ENTER);
    }

    public void selectByIdWithOption(String option) {
        WebElement id = department;
        Select select = new Select(id);
        select.selectByVisibleText(option);
    }

    public void signUp(String initDepartment, String initFirstName, String initLastName, String initCompany, String initPhone, String initEmail){
        logIn.click();
        signUp.click();
        this.selectByIdWithOption(initDepartment);
        this.enterFirstName(initFirstName);
        this.enterLastName(initLastName);
        this.enterBusinessName(initCompany);
        this.enterPhoneNumber(initPhone);
        this.enterEmail(initEmail);
        contactUs.click();
    }
}
