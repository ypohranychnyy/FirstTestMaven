package com.codeborne.selenide;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PasteFolderD {

    @Test

    public void UserCanDeleteFolder() {
        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("tast");
        $(".jsInputPassword").val("1").pressEnter(); //Login
        $(byAttribute("data-element", "fm-5")).click();//click New folder button in top menu
        $("input.jsNewName").val("folder to delete").pressEnter();//Giving new name to a folder
        $(byAttribute("data-element", "fm-5")).click();//click New folder button in top menu
        $("input.jsNewName").val("folder to cut").pressEnter();//Giving new name to a folder

        $(".TfilesName").click(); // Click folder line to mark as selected
        $$(".fileMoreButton.floatRight.marginR15.jsMore.gaClick>i").get(0).click(); // waiting for element to appear (rename button) (more menu)
        $(By.linkText("Copy")).click(); //Click copy button
        sleep(500);
        $$(".fileMoreButton.floatRight.marginR15.jsMore.gaClick>i").get(0).click(); // waiting for element to appear (rename button) (more menu)
//        $(".LI.fpaste.commandPaste.gaClick").waitUntil(Condition.appear, 2000);//click Paste item
//        $(".LI.fpaste.commandPaste.gaClick").click();//click Paste item
//        $(".lucida .firepath-matching-node").waitUntil(Condition.appear, 2000);//click Paste item
//        $(".lucida .firepath-matching-node").click();//click Paste item
//        $(".fpaste .commandPaste .gaClick").waitUntil(Condition.appear, 2000);//click Paste item
//        $(".fpaste .commandPaste .gaClick").click();//click Paste item
//        $(".commandPaste").click(); // paste item
//        $(byAttribute("data-element", "cM-4.3")).waitUntil(Condition.appear, 20000);
//        $(byAttribute("data-element", "cM-4.3")).click();
        $(byAttribute("data-element", "viewL-name")).click();//Click the folder's name to open it
        $(byText("folder to delete")).waitUntil(Condition.appear, 20000); //Assert that item is gone


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