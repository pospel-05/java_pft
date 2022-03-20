package ru.stqa.pfd.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class UntitledTestCase {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  public final StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() {
    //System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    String baseUrl = "https://www.google.com/";
    WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("https://phonebook-app.com/go/demo-ru/www/00admin/index.php?r=partition%2Fcreate");
    driver.findElement(By.id("loginform-username")).click();
    driver.findElement(By.id("loginform-username")).clear();
    driver.findElement(By.id("loginform-username")).sendKeys("master");
    driver.findElement(By.id("loginform-password")).click();
    driver.findElement(By.id("loginform-password")).clear();
    driver.findElement(By.id("loginform-password")).sendKeys("master");
    driver.findElement(By.name("login-button")).click();
  }

  @Test
  public void testUntitledTestCase() {
    driver.findElement(By.id("partition-title")).click();
    driver.findElement(By.id("partition-title")).clear();
    driver.findElement(By.id("partition-title")).sendKeys("4");
    driver.findElement(By.id("partition-short_title")).click();
    driver.findElement(By.id("partition-short_title")).clear();
    driver.findElement(By.id("partition-short_title")).sendKeys("4");
    driver.findElement(By.id("partition-order")).click();
    driver.findElement(By.id("partition-order")).clear();
    driver.findElement(By.id("partition-order")).sendKeys("4");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    //ERROR: Caught exception [unknown command [может]]
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
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

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
