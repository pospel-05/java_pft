package ru.stqa.pfd.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pfd.addressbook.model.RazdelData;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class ApplicationManager {
    public final StringBuffer verificationErrors = new StringBuffer();
    WebDriver driver;
    private boolean acceptNextAlert = true;

    public void init() {
        driver = new ChromeDriver();
        String baseUrl = "https://www.google.com/";
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://phonebook-app.com/go/demo-ru/www/00admin/index.php?r=site%2Flogin");
        login("master", "master");
    }

    private void login(String username, String password) {
      driver.findElement(By.id("loginform-username")).click();
      driver.findElement(By.id("loginform-username")).clear();
      driver.findElement(By.id("loginform-username")).sendKeys(username);
      driver.findElement(By.id("loginform-password")).click();
      driver.findElement(By.id("loginform-password")).clear();
      driver.findElement(By.id("loginform-password")).sendKeys(password);
      driver.findElement(By.name("login-button")).click();
    }

    public void gotoRazdelPage() {
        driver.findElement(By.xpath("//*[@id=\"w3\"]/li[8]/a")).click();
    }

    public void initRazdel() {
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/p/a")).click();
    }

    public void fillRazdelForm(RazdelData groupData) {
      driver.findElement(By.id("partition-title")).click();
      driver.findElement(By.id("partition-title")).clear();
      driver.findElement(By.id("partition-title")).sendKeys(groupData.name());
      driver.findElement(By.id("partition-short_title")).click();
      driver.findElement(By.id("partition-short_title")).clear();
      driver.findElement(By.id("partition-short_title")).sendKeys(groupData.label());
      driver.findElement(By.id("partition-order")).click();
      driver.findElement(By.id("partition-order")).clear();
      driver.findElement(By.id("partition-order")).sendKeys(groupData.namber());
    }

    public void submitRazdel() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void deleteSelectRazdel() {
        driver.findElement(By.xpath("//*[@id=\"w0\"]/table/tbody/tr[3]/td[3]/a[2]/span")).click();
    }

    public void deleteRazdel() {
        assertTrue(closeAlertAndGetItsText().matches("^Вы уверены, что хотите удалить этот элемент[\\s\\S]$"));
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

    String closeAlertAndGetItsText() {
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
