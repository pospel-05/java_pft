package ru.stqa.pfd.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {


    private WebDriver driver = null;

    NavigationHelper(WebDriver driver) {

    }

    public void gotoRazdelPage() {
        driver.findElement(By.xpath("//*[@id=\"w4\"]/li[8]/a")).click();
    }
}
