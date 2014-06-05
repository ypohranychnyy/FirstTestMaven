package com.codeborne.selenide;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RenameFolderD {

    @Test

    public void UserCanDeleteFolder() {
        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("tast");
        $(".jsInputPassword").val("1").pressEnter(); //Login

        $(byAttribute("data-element", "fm-5")).click();//click New folder button in top menu
        $("input.jsNewName").val("folder to delete").pressEnter();//Giving new name to a folder

//        $(".TfilesName").click(); // Click folder line to mark as selected
        $$(".fileMoreButton.floatRight.marginR15.jsMore.gaClick>i").get(0).click(); // waiting for element to appear (rename button) (more menu)
        $("#contextMenu").waitUntil(Condition.appear, 20000);
        $(byAttribute("data-element", "cM-4.5")).waitUntil(Condition.appear, 20000); // rename button appears
        $(byAttribute("data-element", "cM-4.5")).click(); //click rename button
        $("input.jsNewName").val("to delete").pressEnter();//Giving new name to a folder
        $(byText("to delete")).waitUntil(Condition.appear, 20000); //Assert that item is gone
        $(byAttribute("imgdirid", "StJ70-En")).click();//click Recycle Bin image
        $(byText("to delete")).shouldNotBe(Condition.visible);//Assert that folder is not empty
        $(By.linkText("Empty recycle bin")).click();
        $(".jsConfirmOk").click();//confirm action
    }
}