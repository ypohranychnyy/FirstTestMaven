package com.codeborne.selenide;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DeleteFileD {

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
        $(byAttribute("data-element", "cM-4.4")).waitUntil(Condition.appear, 20000); // delete button appears
        $(byAttribute("data-element", "cM-4.4")).click(); //click delete button
        $(".jsConfirmOk").click();//confirm action
        $(byText("test.log")).waitUntil(Condition.disappear, 20000); //Assert that item is gone

        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
        $(byAttribute("imgdirid", "StJ70-En")).click();//click Recycle Bin image
        $(By.linkText("Empty recycle bin")).click();
        $(".jsConfirmOk").click();//confirm action
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty

    }
}