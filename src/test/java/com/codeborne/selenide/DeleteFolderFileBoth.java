package com.codeborne.selenide;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class DeleteFolderFileBoth {

    @Before
    public void StartThisSession() {
        clearBrowserCache();

        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("tast"); // input login credentials
        $(".jsInputPassword").val("1").pressEnter(); //Login
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
    }

    @Test

    public void UserCanDeleteFolder() {


        $(byAttribute("data-element", "fm-5")).click();//click New folder button in top menu
        $("input.jsNewName").val("our new folder1").pressEnter();//Giving new name to a folder

        $(byAttribute("data-element", "fm-v.2")).click();//click New folder button in top menu
        $(".TfilesName").click(); // Click folder line to mark as selected
        $$(".fileMoreButton.floatRight.marginR15.jsMore.gaClick>i").get(0).click(); // waiting for element to appear (rename button) (more menu)
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting item
        $(byText("our new folder1")).waitUntil(Condition.disappear, 20000); //Assert that item is gone

    }

    @Test

    public void UserCanDeleteFile() {

        $("#tfid1").sendKeys("C:\\For_test\\test.log"); //Аплоадим тестовый файл
        $(byText("test.log")).waitUntil(appear, 6000); //Проверяем, что аплоад прошел ок

        $(byAttribute("data-element", "fm-v.2")).click();//click New folder button in top menu
        $(".logFileExt").click(); // Click file line to mark image file selected
        $$(By.cssSelector(".fileMoreButton.floatRight.marginR15.jsMore.gaClick>i")).get(0).click(); // waiting for element to appear (rename button) (more menu)
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting
        $(byText("test.log")).waitUntil(Condition.disappear, 20000);//Assert that item is gone

    }


    @Test

    public void UserCanDeleteAll() {

        $("#tfid1").sendKeys("C:\\For_test\\test.log"); //Upload test file
        $(byAttribute("data-element", "fm-5")).click();//click New folder button in top menu
        $("input.jsNewName").val("new folder1").pressEnter();//Giving new name to a folder
        $(byText("test.log")).waitUntil(appear, 20000); //Assert that test file is uploaded

        $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
        $(byAttribute("data-element","fm-m")).waitUntil(appear, 20000);
        $(byAttribute("data-element","fm-m")).click();//Click More button on the top (context menu)
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting folder
        $(byText("This folder is empty")).waitUntil(Condition.appear, 6000);//Assert that folder is empty

    }
    @After
    public void ClearBin(){
        $(byAttribute("imgdirid", "StJ70-En")).click();//click Recycle Bin image
        $(By.linkText("Empty recycle bin")).click();
        $(".jsConfirmOk").click();//confirm action
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
    }

}
