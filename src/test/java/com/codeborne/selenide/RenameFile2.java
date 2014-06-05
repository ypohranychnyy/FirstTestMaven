package com.codeborne.selenide;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

/**
 * Created by Yuriy on 17.04.2014.
 */
public class RenameFile2 {

    @Before
    public void StartThisSession() {
        clearBrowserCache();

        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("RenameFolder"); // input login credentials
        $(".jsInputPassword").val("1").pressEnter(); //Login
    }

    @Test

    public void UserCanRenameFolder() {

        $(byAttribute("data-element", "fm-5")).click();//click New folder button in top menu
        $("input.jsNewName").val("new folder1").pressEnter();//Giving new name to a folder
        $(".TfilesName").click(); // Click folder line to mark as selected
        $$(By.cssSelector(".fileMoreButton.floatRight.marginR15.jsMore.gaClick>i")).get(0).click(); // waiting for element to appear (rename button)
        $(By.linkText("Rename")).click(); //Click Rename button
        $("input.jsNewName").val("renamed folder").pressEnter();//Giving new name to a folder
        $(By.cssSelector(".TfilesName")).shouldHave(Condition.matchText("^['renamed folder']")); // and try to assert that rename was successful
        sleep(3000);


        $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
        sleep(500);
        $(byAttribute("data-element", "fm-m")).click();//Click More button on the top (context menu)
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