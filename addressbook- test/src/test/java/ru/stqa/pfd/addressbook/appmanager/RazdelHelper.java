package ru.stqa.pfd.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pfd.addressbook.model.GroupData;

import static org.testng.Assert.assertTrue;

public class RazdelHelper {

    private WebDriver driver;
    private boolean acceptNextAlert = true;

    public RazdelHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void submitChapter() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void fillRazdelForm(GroupData groupData) {
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

    public void initRazdel() {
      driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/p/a")).click();
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

    public void deleteRazdel() {
      assertTrue(closeAlertAndGetItsText().matches("^Вы уверены, что хотите удалить этот элемент[\\s\\S]$"));
    }

    public void deleteSelectRazdel() {
      driver.findElement(By.xpath("//*[@id=\"w0\"]/table/tbody/tr[3]/td[3]/a[2]/span")).click();
    }
}
