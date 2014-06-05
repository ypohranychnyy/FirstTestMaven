package com.codeborne.selenide;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class CopyFileD {

    @Test

    public void UserCanDeleteFolder() {
        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("tast");
        $(".jsInputPassword").val("1").pressEnter(); //Login

// creating new folder and uploading file to copy/cut into the folder
        $("#tfid1").sendKeys("C:\\For_test\\test.log"); //Upload test file
        $(byText("test.log")).waitUntil(Condition.appear, 20000); //Assert that test file is uploaded

        $(".logFileExt").click(); // Click file line to mark image file selected
        $$(By.cssSelector(".fileMoreButton.floatRight.marginR15.jsMore.gaClick>i")).get(0).click(); // waiting for element to appear (rename button) (more menu)
        $(byAttribute("data-element", "cM-4.2")).waitUntil(Condition.appear, 20000); // copy button appears
        $(byAttribute("data-element", "cM-4.2")).click(); //click copy button
        $(byAttribute("data-element", "fm-5")).click();//click New folder button in top menu
        $("input.jsNewName").val("our new folder1").pressEnter();//Giving new name to a folder
        sleep(500);
        $$(".fileMoreButton.floatRight.marginR15.jsMore.gaClick>i").get(0).click(); // waiting for element to appear (rename button) (more menu)
        $(byAttribute("data-element", "cM-4.3")).waitUntil(Condition.appear, 20000); // paste button appears
        $(byAttribute("data-element", "cM-4.3")).click(); //click paste button
//       $(byAttribute("data-element", "viewL-name")).click();//Click the folder's name to open it
        $(byText("test.log")).waitUntil(Condition.appear, 20000); //Assert that item is present


        $("#firstDir").click(); //Click Root folder
        $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
        $(byAttribute("data-element", "fm-m")).waitUntil(Condition.appear, 6000);//Assert that More button at the top (context menu) appears
        $(byAttribute("data-element", "fm-m")).click();//Click More button on the top (context menu)
        $(By.linkText("Delete")).click(); //Click Rename button
        $(".jsConfirmOk").click();//confirm action
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
        $(byAttribute("imgdirid", "StJ70-En")).click();//click Recycle Bin image
        $(By.linkText("Empty recycle bin")).click();
        $(".jsConfirmOk").click();//confirm action
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty

    }
}