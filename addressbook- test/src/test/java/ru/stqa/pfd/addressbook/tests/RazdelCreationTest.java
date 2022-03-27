package ru.stqa.pfd.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pfd.addressbook.model.GroupData;

public class RazdelCreationTest extends TestBase {

  @Test
  public void testRazdelCreation() {
    app.gotoRazdelPage();
    app.initRazdel();
    app.fillRazdelForm(new GroupData("4", "4", "4"));
    app.submitChapter();
  }

}
