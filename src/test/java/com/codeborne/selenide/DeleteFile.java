package com.codeborne.selenide;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Yuriy on 22.04.2014.
 */
public class DeleteFile {

        @Test

        public void DeleteFile() {

            open("https://www.4shared.com"); // Open 4Shared
            $(".controls .llink").click(); //Waiting for header login
            $(".headLoginDropdown").should(); //Waiting for drop-down

            $(".jsInputLogin").val("DeleteFile");
            $(".jsInputPassword").val("1").pressEnter(); //Login

            $(By.id("tfid1")).sendKeys("C:\\For_test\\test.log"); //Аплоадим тестовый файл
            $(byText("test.log")).waitUntil(appear, 20000); //Проверяем, что аплоад прошел ок

            $(".logFileExt").click(); // Click file line to mark image file selected
            $$(By.cssSelector(".fileMoreButton.floatRight.marginR15.jsMore.gaClick>i")).get(0).click(); // waiting for element to appear (rename button) (more menu)
            $(By.linkText("Delete")).waitUntil(Condition.appear, 20000);
            $(By.linkText("Delete")).click(); //Click Delete button
            $(".jsConfirmOk").waitUntil(Condition.appear, 20000);
            $(".jsConfirmOk").click(); //Confirm deleting
            $(byText("test.log")).waitUntil(Condition.disappear, 20000);//Assert that item is gone

            $(byAttribute("imgdirid", "StJ70-En")).click();//click Recycle Bin image
            $(By.linkText("Empty recycle bin")).click();
            $(".jsConfirmOk").click();//confirm action
            $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
        }
    }