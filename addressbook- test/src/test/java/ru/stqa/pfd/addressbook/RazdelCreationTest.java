package ru.stqa.pfd.addressbook;

import org.testng.annotations.Test;

public class RazdelCreationTest extends TestBase {

  @Test
  public void testRazdelCreation() {
    gotoRazdelPage();
    initRazdel();
    fillRazdelForm(new GroupData("4", "4", "4"));
    submitChapter();
  }

}
