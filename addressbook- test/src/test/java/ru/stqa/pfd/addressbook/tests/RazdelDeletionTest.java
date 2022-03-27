package ru.stqa.pfd.addressbook.tests;

import org.testng.annotations.Test;

public class RazdelDeletionTest extends TestBase {

  @Test
  public void testRazdelDeletion() throws Exception {
    app.gotoRazdelPage();
    app.deleteSelectRazdel();
    app.deleteRazdel();
    app.gotoRazdelPage();
  }

}
