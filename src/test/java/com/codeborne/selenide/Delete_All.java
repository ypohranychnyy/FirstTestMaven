package com.codeborne.selenide;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

/**
 * Created by Yuriy on 22.04.2014.
 */
public class Delete_All {
    @Before
    public void StartThisSession() {
        clearBrowserCache();

        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("tast");
        $(".jsInputPassword").val("1").pressEnter(); //Login
    }

    @Test
//It should be possible to delete all items in account

    public void UserCanDeleteAll() {
       /*
        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("tast");
        $(".jsInputPassword").val("1").pressEnter(); //Login
        */


        /*$(byAttribute("imgdirid", "StJ70-En")).click();//click Recycle Bin image
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is not empty
        $(By.id("webfx-tree-object-1-anchor")).click();//Click My 4Shared button
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);
        sleep(5000);*/

        $(By.id("tfid1")).sendKeys("C:\\For_test\\test.log"); //Upload test file
        $(byAttribute("data-element", "fm-5")).click();//click New folder button in top menu
        $("input.jsNewName").val("our new folder1").pressEnter();//Giving new name to a folder
        $(byText("test.log")).waitUntil(appear, 20000); //Assert that test file is uploaded

        $(byAttribute("data-element", "viewL-name")).click();//Click the folder's name to open it
        $(byText("This folder is empty")).waitUntil(Condition.appear, 7000);
        $(By.id("tfid1")).sendKeys("C:\\For_test\\test.doc"); //Upload test file
        $(byAttribute("data-element", "fm-5")).click();//click New folder button in top menu
        $("input.jsNewName").val("our new folder2").pressEnter();//Giving new name to a folder
        $(byText("test.doc")).waitUntil(appear, 20000); //Assert that test file is uploaded

        $(byAttribute("data-element", "viewL-name")).click();//Click the folder's name to open it
        $(byText("This folder is empty")).waitUntil(Condition.appear, 6000);
        $(By.id("tfid1")).sendKeys("C:\\For_test\\test.txt"); //Upload test file
        $(byText("test.txt")).waitUntil(appear, 20000); //Assert that test file is uploaded

        $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
        sleep(2500);
        $(byAttribute("data-element","fm-m")).click();//Click More button on the top (context menu)
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting folder
        $(byText("This folder is empty")).waitUntil(Condition.appear, 6000);//Assert that folder is empty

        $(By.id("backSpan")).click(); //Click Back button
        $(byText("test.doc")).waitUntil(appear, 20000); //Assert that test file is uploaded
        $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
//        sleep(2500);
        $(byAttribute("data-element","fm-m")).click();//Click More button on the top (context menu)
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting folder
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty

        $(By.id("backSpan")).click(); //Click Back button
        $(byText("test.log")).waitUntil(appear, 20000); //Assert that test file is uploaded
//        sleep(2500);
        $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
        sleep(2500);
        $(byAttribute("data-element","fm-m")).click();//Click More button on the top (context menu)
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting folder
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty

        //        closing

        $(By.id("firstDir")).click(); //Click Root folder
        $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
        sleep(500);
        $(byAttribute("data-element","fm-m")).click();//Click More button on the top (context menu)
//        $(byText("Delete")).waitUntil(appear, 20000); //Assert that test file is uploaded
        sleep(500);
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting folder
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
        $(byAttribute("imgdirid", "StJ70-En")).click();//click Recycle Bin image
        $(By.linkText("Empty recycle bin")).click();
        $(".jsConfirmOk").click();//confirm action
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
  }
}