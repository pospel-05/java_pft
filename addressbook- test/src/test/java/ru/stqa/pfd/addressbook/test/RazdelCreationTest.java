package ru.stqa.pfd.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pfd.addressbook.model.RazdelData;

public class RazdelCreationTest extends TestBase {

  @Test
  public void testRazdelCreation() {
    app.gotoRazdelPage();
    app.initRazdel();
    app.fillRazdelForm(new RazdelData("4", "4", "4"));
    app.submitRazdel();
  }

}
