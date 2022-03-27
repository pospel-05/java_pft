package ru.stqa.pfd.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
    private WebDriver driver;

    public SessionHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(By.id("loginform-username")).click();
        driver.findElement(By.id("loginform-username")).clear();
        driver.findElement(By.id("loginform-username")).sendKeys(username);
        driver.findElement(By.id("loginform-password")).click();
        driver.findElement(By.id("loginform-password")).clear();
        driver.findElement(By.id("loginform-password")).sendKeys(password);
        driver.findElement(By.name("login-button")).click();
    }

}
