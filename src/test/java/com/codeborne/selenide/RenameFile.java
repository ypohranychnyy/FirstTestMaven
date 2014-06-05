package com.codeborne.selenide;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

/**
 * Created by Yuriy on 17.04.2014.
 */
public class RenameFile {
    @Before
    public void StartThisSession() {
        clearBrowserCache();

        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); // Waiting for header login
        $(".headLoginDropdown").should(); // Waiting for drop-down
        $(".jsInputLogin").val("RenameFile"); // input login credentials
        $(".jsInputPassword").val("1").pressEnter(); //Login

    }
        @Test

        public void UserCanRenameFile(){
            $(By.id("tfid1")).sendKeys("C:\\For_test\\test.log"); //Аплоадим тестовый файл
            $(byText("test.log")).waitUntil(appear, 20000); //Проверяем, что аплоад прошел ок
            $(".logFileExt").click(); // Click file line to mark log file selected
            $(byText("Rename")).click(); //Click Rename button
            $("input.jsNewName").val("renamed file.log").pressEnter();//Giving new name to a file
           sleep(3000);
            $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
            $(byAttribute("data-element","fm-m")).waitUntil(Condition.appear, 6000);//Assert that More button at the top (context menu) appears
            $(byAttribute("data-element","fm-m")).click();//Click More button on the top (context menu)
            $(By.linkText("Delete")).click(); //Click Rename button
            $(".jsConfirmOk").click();//confirm action
            $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
            $(byAttribute("imgdirid", "StJ70-En")).click();//click Recycle Bin image
            $(By.linkText("Empty recycle bin")).click();
            $(".jsConfirmOk").click();//confirm action
            $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
        }
    }