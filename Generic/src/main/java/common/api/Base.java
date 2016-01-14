package common.api;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by mdalam on 1/8/16.
 */
public class Base {
    public WebDriver driver = null;
    public Logger log = Logger.getLogger(Base.class.getName());

    @Parameters({"useSauceLab","userName", "key","appUrl","os","browserName","browserVersion"})
    @BeforeMethod
    public void setUp(boolean useSauceLab,String userName,String key,String appUrl, String os,
                      String browserName,String browserVersion )throws IOException {
        if(useSauceLab == true){
            getSauceLabDriver(userName, key, os, browserName, browserVersion);
        }else{
            getLocalDriver(os, browserName);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(appUrl);
        driver.manage().window().maximize();
        log.info("browser loaded with App");
    }

    @AfterMethod
    public void cleanUp(ITestResult result) throws InterruptedException{
        if (ITestResult.FAILURE == result.getStatus()) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("./Booker/Screenshots/" + result.getName() + timeStamp + ".png"));
                System.out.println("Screenshot taken");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
        sleepfor(2);
        log.info("driver is quiting");
        sleepfor(2);
        driver.quit();
    }

    //get local driver
    public WebDriver getLocalDriver(String os, String browserName){

        if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("chrome")){
            if(os.equalsIgnoreCase("windows")){
                System.setProperty("webdriver.chrome.driver","Generic\\selenium-browser-driver\\chromedriver.exe");
            }else{
                System.setProperty("webdriver.chrome.driver", "Generic/selenium-browser-driver/chromedriver");
            }
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }else if(browserName.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver","Generic\\selenium-browser-driver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else if(browserName.equalsIgnoreCase("htmlunit")){
            driver = new HtmlUnitDriver();
        }

        return driver;
    }

    //get cloud driver
    public WebDriver getSauceLabDriver(String userName, String key, String os, String browserName,
                                       String browserVersion )throws IOException{

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform", os);
        cap.setBrowserName(browserName);
        cap.setCapability("version", browserVersion);

        driver = new RemoteWebDriver(new URL("http://"+ userName + ":" +  key +
                "@ondemand.saucelabs.com:80/wd/hub"), cap);

        return driver;
    }

    public void sleepfor(int value)throws InterruptedException{
        int initvalue = (value *1000);
        Thread.sleep(initvalue);
    }

    public void getElementByCss(String locator, String text){
        driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(text);
    }

    public void getElementByXpath(String locator,String text){
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    public void getElementByid(String locator){

        driver.findElement(By.id(locator));
    }

    public void getElementByname(String locator){

        driver.findElement(By.name(locator));
    }

    public void syso(String value){

        System.out.println(value);
    }

    public void tonavBack(){

        driver.navigate().back();
    }

    public void tonavForward(){

        driver.navigate().forward();
    }

    public void selectByIdWithOption(String locator, String option) {
        WebElement id = driver.findElement(By.id(locator));
        Select select = new Select(id);
        select.selectByVisibleText(option);
    }

    public void selectById(String locator) {

        driver.findElement(By.id(locator));
    }

    public String getTextByXpath(String locator) {

        return driver.findElement(By.xpath(locator)).getText();
    }

    public void clickByCss(String locator){

        driver.findElement(By.cssSelector(locator)).click();
    }

    public void clickByXpath(String locator){

        driver.findElement(By.xpath(locator)).click();
    }

    public String getTitle(){

        return driver.getTitle();
    }

    public void typeByCssThenEnter(String locator, String value ) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);

    }

    public void typeByCss(String locator, String value) {

        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void clickCheckBox(String s) {

        driver.findElement(By.id(s)).click();
    }

    public void switchWindow() {
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public void switchTab() {
        String oldTab = driver.getWindowHandle();
        driver.findElement(By.linkText("Twitter Advertising Blog")).click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        // change focus to new tab
        driver.switchTo().window(newTab.get(0));
    }
}