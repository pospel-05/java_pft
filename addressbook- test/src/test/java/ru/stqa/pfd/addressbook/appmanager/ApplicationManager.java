package ru.stqa.pfd.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pfd.addressbook.SessionHelper;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class ApplicationManager {
    WebDriver driver;
    public final StringBuffer verificationErrors = new StringBuffer();

    private SessionHelper SessionHelper;
    private NavigationHelper navigationHelper;
    private RazdelHelper razdelHelper;

    public void init() {
        //System.setProperty("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
        String baseUrl = "https://www.google.com/";
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://phonebook-app.com/go/demo-ru/www/00admin/index.php?r=partition%2Fcreate");
        SessionHelper.login("master", "master");
        RazdelHelper razdelHelper = new RazdelHelper(driver);
        NavigationHelper navigationHelper = new NavigationHelper(driver);
        SessionHelper SessionHelper = new SessionHelper(driver);
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public RazdelHelper getRazdelHelper() {
        return razdelHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
