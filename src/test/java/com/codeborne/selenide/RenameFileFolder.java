package com.codeborne.selenide;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class RenameFileFolder {

    @Before
    public void StartThisSession() {
        clearBrowserCache();

        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); // Waiting for header login
        $(".headLoginDropdown").should(); // Waiting for drop-down
        $(".jsInputLogin").val("RenameFileFolder"); // input login credentials
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

    }

    @Test

    public void UserCanRenameFile() {

        $(By.id("tfid1")).sendKeys("C:\\For_test\\test.log"); //Аплоадим тестовый файл
        $(byText("test.log")).waitUntil(appear, 6000); //Проверяем, что аплоад прошел ок
        $(".logFileExt").click(); // Click file line to mark log file selected
        $(byText("Rename")).click(); //Click Rename button
        $("input.jsNewName").val("renamed file.log").pressEnter();//Giving new name to a file

    }

        @After
    public void ClearBin(){
            sleep(3000);
            $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
            $(byAttribute("data-element","fm-m")).waitUntil(Condition.appear, 6000);//Assert that More button at the top (context menu) appears
            $(byAttribute("data-element","fm-m")).click();//Click More button on the top (context menu)
            $(By.linkText("Delete")).click(); //Click delete button
            $(".jsConfirmOk").click();//confirm action
        $(byAttribute("imgdirid", "StJ70-En")).click();//click Recycle Bin image
        $(By.linkText("Empty recycle bin")).click();
        $(".jsConfirmOk").click();//confirm action
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
    }


}