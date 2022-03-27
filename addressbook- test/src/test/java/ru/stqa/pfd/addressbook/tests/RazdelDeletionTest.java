package ru.stqa.pfd.addressbook.tests;

import org.testng.annotations.Test;

public class RazdelDeletionTest extends TestBase {

  @Test
  public void testRazdelDeletion() throws Exception {
    app.getNavigationHelper().gotoRazdelPage();
    app.getRazdelHelper().deleteSelectRazdel();
    app.getRazdelHelper().deleteRazdel();
    app.getNavigationHelper().gotoRazdelPage();
  }

}
