package com.codeborne.selenide;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;



public class DeleteFolderD {

    @Test

    public void UserCanDeleteFolder() {
        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("tast");
        $(".jsInputPassword").val("1").pressEnter(); //Login

        $(byAttribute("data-element", "fm-5")).click();//click New folder button in top menu
        $("input.jsNewName").val("folder to delete").pressEnter();//Giving new name to a folder

        $(".TfilesName").click(); // Click folder line to mark as selected
        $$(".fileMoreButton.floatRight.marginR15.jsMore.gaClick>i").get(0).click(); // waiting for element to appear (rename button) (more menu)
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting item
        $(byText("folder to delete")).waitUntil(Condition.disappear, 20000); //Assert that item is gone
        $(byAttribute("imgdirid", "StJ70-En")).click();//click Recycle Bin image
        $(byText("folder to delete")).shouldNotBe(Condition.visible);//Assert that folder is not empty
        $(By.linkText("Empty recycle bin")).click();
        $(".jsConfirmOk").click();//confirm action
    }
}