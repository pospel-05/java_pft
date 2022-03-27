package ru.stqa.pfd.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pfd.addressbook.model.GroupData;

public class RazdelCreationTest extends TestBase {

  @Test
  public void testRazdelCreation() {
    app.getNavigationHelper().gotoRazdelPage();
    app.getRazdelHelper().initRazdel();
    app.getRazdelHelper().fillRazdelForm(new GroupData("4", "4", "4"));
    app.getRazdelHelper().submitChapter();
  }

}
