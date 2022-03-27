package ru.stqa.pfd.addressbook;

import org.testng.annotations.Test;

public class RazdelDeletionTest extends TestBase {

  @Test
  public void testRazdelDeletion() throws Exception {
    gotoRazdelPage();
    deleteSelectRazdel();
    deleteRazdel();
    gotoRazdelPage();
  }

}
